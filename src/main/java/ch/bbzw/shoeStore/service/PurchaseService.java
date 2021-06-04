package ch.bbzw.shoeStore.service;
import ch.bbzw.shoeStore.model.Purchase;
import ch.bbzw.shoeStore.model.Shoe;
import ch.bbzw.shoeStore.model.User;
import ch.bbzw.shoeStore.repo.PurchaseRepo;
import ch.bbzw.shoeStore.repo.ShoeRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PurchaseService {
    private final PurchaseRepo purchaseRepo;
    private final ShoeRepo shoeRepo;
    private final UserService userService;

    public PurchaseService(final PurchaseRepo purchaseRepo, final ShoeRepo shoeRepo, final UserService userService) {
        this.purchaseRepo = purchaseRepo;
        this.shoeRepo = shoeRepo;
        this.userService = userService;
    }

    @Transactional
    public Purchase add(final long shoeId) {
        final Optional<Shoe> optionalShoe = shoeRepo.findById(shoeId);
        if(optionalShoe.isPresent()) {
            Shoe shoe = optionalShoe.get();
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
    public List<Purchase> getAll() {
        final Iterable<Purchase> purchases = purchaseRepo.findAll();
        return StreamSupport
                .stream(purchases.spliterator(), false)
                .collect(Collectors.toList());
    }
}
