package ch.bbzw.shoeStore.service;

import ch.bbzw.shoeStore.dto.ShoeWithPrice;
import ch.bbzw.shoeStore.model.Price;
import ch.bbzw.shoeStore.model.Shoe;
import ch.bbzw.shoeStore.repo.PriceRepo;
import ch.bbzw.shoeStore.repo.ShoeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ShoeService {
    private final ShoeRepo shoeRepo;
    private final PriceRepo priceRepo;

    @Autowired
    public ShoeService(final ShoeRepo shoeRepo, final PriceRepo priceRepo) {
        this.shoeRepo = shoeRepo;
        this.priceRepo = priceRepo;
    }

    @Transactional
    public Shoe add(final ShoeWithPrice shoeWithPrice) {
        Price price = priceRepo.save(shoeWithPrice.getPrice());
        Shoe shoe = new Shoe(shoeWithPrice.getName(), shoeWithPrice.getSize(), shoeWithPrice.getRealse_date(), shoeWithPrice.getInventory(), price);
        return shoeRepo.save(shoe);
    }

    @Transactional
    public void delete(final long id) {
        shoeRepo.deleteById(id);
    }

    @Transactional
    public Optional<Shoe> update(final long id, final Shoe shoe) {
        final Optional<Shoe> optionalShoe = shoeRepo.findById(id);
        if (optionalShoe.isPresent()) {
            Shoe foundShoe = optionalShoe.get();
            foundShoe.setName(shoe.getName());
            foundShoe.setInventory(shoe.getInventory());
            foundShoe.setPrice(shoe.getPrice());
            foundShoe.setRealse_date(shoe.getRealse_date());
            foundShoe.setSize(shoe.getSize());
        }
        return Optional.empty();
    }

    @Transactional(readOnly = true)
    public List<Shoe> getAll() {
        final Iterable<Shoe> shoes = shoeRepo.findAll();
        return StreamSupport
                .stream(shoes.spliterator(), false)
                .collect(Collectors.toList());
    }
}
