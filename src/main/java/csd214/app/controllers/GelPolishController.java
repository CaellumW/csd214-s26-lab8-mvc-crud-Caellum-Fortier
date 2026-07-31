package csd214.app.controllers;
import csd214.app.entities.GelPolishEntity;
import csd214.app.repositories.GelPolishRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public class GelPolishController {
    private final GelPolishRepository polishRepository;

    public GelPolishController(GelPolishRepository polishRepository) {
        this.polishRepository = polishRepository;
    }

    // 1. READ (List all books)
    @GetMapping
    public String listPolishes(Model model) {
        model.addAttribute("polishes", polishRepository.findAll());
        return "polish-list";
    }

    // 2. CREATE (Show empty form)
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("polish", new GelPolishEntity());
        return "polish-form";
    }

    // 3. SAVE (Handles both inserts and edits)
    @PostMapping("/save")
    public String savePolish(@ModelAttribute("polish") GelPolishEntity polish) {
        polish.setColourShade(polish.getColourShade()); // let's just get polish colour here
        polishRepository.save(polish);
        return "redirect:/polishes";
    }

    // 4. EDIT (Retrieve existing state)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        GelPolishEntity polish = polishRepository.findById(id).orElse(null);
        if (polish != null) {
            model.addAttribute("polish", polish);
            return "polish-form";
        }
        return "redirect:/polishes";
    }

    // 5. DELETE
    @GetMapping("/delete/{id}")
    public String deletePolish(@PathVariable("id") Long id) {
        polishRepository.deleteById(id);
        return "redirect:/polishes";
    }
}
