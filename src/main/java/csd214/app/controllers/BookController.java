package csd214.app.controllers;

import csd214.app.entities.BookEntity;
import csd214.app.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // 1. READ (List all books)
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book-list";
    }

    // 2. CREATE (Show empty form)
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new BookEntity());
        return "book-form";
    }

    // 3. SAVE (Handles both inserts and edits)
    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") BookEntity book) {
        book.setName(book.getTitle()); // Sync title to polymorphic parent name field
        bookRepository.save(book); // Hibernate upserts automatically [7]
        return "redirect:/books"; // Safe PRG redirect pattern
    }

    // 4. EDIT (Retrieve existing state)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        BookEntity book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            model.addAttribute("book", book);
            return "book-form";
        }
        return "redirect:/books";
    }

    // 5. DELETE
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }
}
