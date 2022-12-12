package kz.baibalaeva.demo.controllers;


import kz.baibalaeva.demo.db.DB;
import kz.baibalaeva.demo.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerBook {
    @GetMapping(value = ("/"))
    String getAllBooks(Model model){
        model.addAttribute("book", DB.getAllBooks());
        return "index";
    }

    @PostMapping(value = ("/addBook"))
    String addNewBook(@RequestParam(name = "photo", defaultValue = "") String photo,
                      @RequestParam(name = "name", defaultValue = "") String name,
                      @RequestParam(name = "price", defaultValue = "0") int price){
        Book book= new Book(null, photo, name, price);
        DB.addBook(book);
        return ("redirect:/");
    }

    @GetMapping(value = "/details/{idshka}")
    public String details(Model model, @PathVariable(name="idshka") Long id){
        Book book = DB.getBook(id);
        model.addAttribute("book", book);
        return "details";
    }
}
