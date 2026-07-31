package csd214.app.controllers;
import csd214.app.entities.NailAccessoryEntity;
import csd214.app.repositories.NailAccessoryRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class NailAccessoryController {
    private final NailAccessoryRepository accessoryRepository;

    public NailAccessoryController(NailAccessoryRepository accessoryRepository) {
        this.accessoryRepository = accessoryRepository;
    }

    // 1. READ (List all books)
    @GetMapping
    public String listAccessories(Model model) {
        model.addAttribute("accessories", accessoryRepository.findAll());
        return "accessory-list";
    }

    // 2. CREATE (Show empty form)
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("accessory", new NailAccessoryEntity());
        return "accessory-form";
    }

    // 3. SAVE (Handles both inserts and edits)
    @PostMapping("/save")
    public String saveAccessory(@ModelAttribute("accessory") NailAccessoryEntity accessory) {
        accessory.setAccessoryType(accessory.getAccessoryType()); // and here we'll grab accessory type - seems like the most obvious attribut
        accessoryRepository.save(accessory);
        return "redirect:/accessories";
    }

    // 4. EDIT (Retrieve existing state)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        NailAccessoryEntity accessory = accessoryRepository.findById(id).orElse(null);
        if (accessory != null) {
            model.addAttribute("accessory", accessory);
            return "accessory-form";
        }
        return "redirect:/accessories";
    }

    // 5. DELETE
    @GetMapping("/delete/{id}")
    public String deleteAccessory(@PathVariable("id") Long id) {
        accessoryRepository.deleteById(id);
        return "redirect:/accessories";
    }
}
