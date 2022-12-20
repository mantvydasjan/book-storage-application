package com.assessment.bookstorageapplication.controller;

import com.assessment.bookstorageapplication.model.Book;
import com.assessment.bookstorageapplication.service.BookService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
@Data
public class BookController {

    @Autowired
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
    
    @GetMapping(path = "/{barcode}")
    public ResponseEntity<Book> getBookByBarcode(@PathVariable long barcode) {
        Book book = bookService.getBookByBarcode(barcode);
        return new ResponseEntity<>(book, HttpStatus.FOUND);
    }
    
    @PatchMapping("/update/{barcode}")
    public Book updateBook(@PathVariable Long barcode,
                           @RequestBody Map<Object, Object> objectMap) {
        return bookService.updateBook(barcode, objectMap);
    }

    @GetMapping(path = "/totalPrice/{barcode}")
    public ResponseEntity<Double> getTotalPrice(@PathVariable long barcode) {
        double totalPrice = bookService.getTotalPrice(barcode);
        return new ResponseEntity<>(totalPrice, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooksByQuantity() {
        List<Book> books = bookService.findBooksByQuantity();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
    
    
    
}
