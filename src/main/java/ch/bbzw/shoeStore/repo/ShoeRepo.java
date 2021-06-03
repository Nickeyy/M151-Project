package ch.bbzw.shoeStore.repo;

import ch.bbzw.shoeStore.model.Shoe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoeRepo extends CrudRepository<Shoe, Long> {
}
