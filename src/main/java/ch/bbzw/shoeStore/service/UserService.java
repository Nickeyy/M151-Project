package ch.bbzw.shoeStore.service;

import ch.bbzw.shoeStore.model.User;
import ch.bbzw.shoeStore.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(final UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional
    public User add(final User user) {
        return userRepo.save(user);
    }

    @Transactional
    public void delete(final long id) {
        userRepo.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        final Iterable<User> users = userRepo.findAll();
        return StreamSupport
                .stream(users.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<User> getCurrentUser() {
        final SecurityContext context = SecurityContextHolder.getContext();
        final Optional<User> optionalUser = userRepo.findByUsername(context.getAuthentication().getName());
        return optionalUser;
    }
}
