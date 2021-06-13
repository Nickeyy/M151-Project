package ch.bbzw.shoeStore.repo;

import ch.bbzw.shoeStore.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User checkPassword(String username, String password);

    Optional<User> findByUsername(String username);

    @Query("SELECT u FROM User u WHERE u.deleted = false")
    Iterable<User> getallNotDeletedUser();
}
