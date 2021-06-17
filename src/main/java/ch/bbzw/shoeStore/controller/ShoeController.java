package ch.bbzw.shoeStore.controller;

import ch.bbzw.shoeStore.dto.ShoeWithPrice;
import ch.bbzw.shoeStore.model.Shoe;
import ch.bbzw.shoeStore.model.User;
import ch.bbzw.shoeStore.service.ShoeService;
import ch.bbzw.shoeStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/shoe")
@PreAuthorize("hasAuthority('PURCHASER') or hasAuthority('ADMIN') or hasAuthority('SELLER')")
public class ShoeController {
    private final ShoeService shoeService;

    @Autowired
    public ShoeController(final ShoeService shoeService) {
        this.shoeService = shoeService;
    }

    @GetMapping("/")
    public List<Shoe> getAll() {
        return shoeService.getAll();
    }

    @GetMapping("/{id}")
    public Shoe get(@PathVariable final long id) {
        return shoeService.get(id).orElse(null);
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Shoe add(@RequestBody final ShoeWithPrice shoeWithPrice) {
        return shoeService.add(shoeWithPrice);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable final long id) {
        shoeService.delete(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Shoe update(@PathVariable final long id, @RequestBody final Shoe shoe) {
        return shoeService.update(id, shoe).orElse(null);
    }
}
