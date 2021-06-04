package ch.bbzw.shoeStore.controller;

import ch.bbzw.shoeStore.model.Purchase;
import ch.bbzw.shoeStore.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/purchase")
@PreAuthorize("hasAuthority('PURCHASER') or hasAuthority('ADMIN') or hasAuthority('SELLER')")
public class PurchaseController {
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(final PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/")
    public List<Purchase> getAll() {
        return purchaseService.getAll();
    }

    @PostMapping("/{id}")
    public Purchase add(@PathVariable final long id) {
        return purchaseService.add(id);
    }
}
