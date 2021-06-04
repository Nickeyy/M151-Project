package ch.bbzw.shoeStore.repo;

import ch.bbzw.shoeStore.model.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepo extends CrudRepository<Purchase, Long> {
}
