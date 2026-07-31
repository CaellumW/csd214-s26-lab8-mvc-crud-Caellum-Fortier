package app.controllers;

import app.entities.NailKitEntity;
import app.repositories.NailKitRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class NailKitController {
    private final NailKitRepository kitRepository;

    public NailKitController(NailKitRepository kitRepository) {
        this.kitRepository = kitRepository;
    }

    // 1. READ (List all books)
    @GetMapping
    public String listKits(Model model) {
        model.addAttribute("kits", kitRepository.findAll());
        return "kit-list";
    }

    // 2. CREATE (Show empty form)
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("kit", new NailKitEntity());
        return "kit-form";
    }

    // 3. SAVE (Handles both inserts and edits)
    @PostMapping("/save")
    public String saveKit(@ModelAttribute("kit") NailKitEntity kit) {
        kit.setKitType(kit.getKitType()); // and we'll do kit type here
        kitRepository.save(kit);
        return "redirect:/kits";
    }

    // 4. EDIT (Retrieve existing state)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        NailKitEntity kit = kitRepository.findById(id).orElse(null);
        if (kit != null) {
            model.addAttribute("kit", kit);
            return "kit-form";
        }
        return "redirect:/kits";
    }

    // 5. DELETE
    @GetMapping("/delete/{id}")
    public String deleteKit(@PathVariable("id") Long id) {
        kitRepository.deleteById(id);
        return "redirect:/kits";
    }
}
