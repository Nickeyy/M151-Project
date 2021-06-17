package ch.bbzw.shoeStore.service;
import ch.bbzw.shoeStore.model.Purchase;
import ch.bbzw.shoeStore.model.Shoe;
import ch.bbzw.shoeStore.model.User;
import ch.bbzw.shoeStore.repo.PurchaseRepo;
import ch.bbzw.shoeStore.repo.ShoeRepo;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@CacheConfig(cacheNames = {"purchase"})
public class PurchaseService {
    private final PurchaseRepo purchaseRepo;
    private final ShoeRepo shoeRepo;
    private final UserService userService;
    private final ShoeService shoeService;

    public PurchaseService(final PurchaseRepo purchaseRepo, final ShoeRepo shoeRepo, final UserService userService, final ShoeService shoeService) {
        this.purchaseRepo = purchaseRepo;
        this.shoeRepo = shoeRepo;
        this.userService = userService;
        this.shoeService = shoeService;
    }

    @Transactional
    @CachePut(key = "#shoeId")
    @CacheEvict(key = "0")
    public Purchase add(final long shoeId) {
        final Optional<Shoe> optionalShoe = shoeRepo.findById(shoeId);
        if(optionalShoe.isPresent()) {
            Shoe shoe = optionalShoe.get();
            if (shoe.getInventory() == 0) {
                return null;
            } else {
                shoe.setInventory(shoe.getInventory() - 1);
                shoeService.update(shoeId, shoe);
            }
            final Optional<User> optionalUser = userService.getCurrentUser();
            if(optionalUser.isPresent()) {
                User user = optionalUser.get();
                Purchase purchase = new Purchase(shoe, user);
                return purchaseRepo.save(purchase);
            }
        }
        return null;
    }

    @Transactional(readOnly = true)
    @Cacheable(key = "0")
    public List<Purchase> getAll() {
        final Iterable<Purchase> purchases = purchaseRepo.findAll();
        return StreamSupport
                .stream(purchases.spliterator(), false)
                .collect(Collectors.toList());
    }

}
