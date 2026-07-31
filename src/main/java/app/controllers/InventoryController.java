package app.controllers;

import app.entities.ProductEntity;
import app.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventoryController {

    private final ProductRepository productRepository;

    public InventoryController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Handles: GET http://localhost:8080/inventory
    @GetMapping
    public String getFullInventory(Model model) {
        List<ProductEntity> products = productRepository.findAll();
        model.addAttribute("products", products); // Pack the model
        return "inventory"; // Return view name template
    }

    // Handles: GET http://localhost:8080/inventory/search?name=Gallic
    @GetMapping("/search")
    public String searchProducts(@RequestParam String name, Model model) {
        List<ProductEntity> products = productRepository.findByNameContainingIgnoreCase(name);
        model.addAttribute("products", products);
        return "inventory";
    }
}
