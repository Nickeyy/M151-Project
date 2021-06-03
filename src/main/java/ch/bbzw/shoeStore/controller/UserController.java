package ch.bbzw.shoeStore.controller;

import ch.bbzw.shoeStore.model.User;
import ch.bbzw.shoeStore.repo.UserRepo;
import ch.bbzw.shoeStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(path="/user")
@PreAuthorize("hasAuthority('PURCHASER') or hasAuthority('ADMIN') or hasAuthority('SELLER')")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public Authentication getInfo() {
        final SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication();
    }

    @GetMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<User> getAll() {
        return userService.getAll();
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User add(@RequestBody final User user) {
        return userService.add(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable final long id) {
        userService.delete(id);
    }
}
