package com.assessment.bookstorageapplication.controller;

import com.assessment.bookstorageapplication.model.AntiqueBook;
import com.assessment.bookstorageapplication.model.Book;
import com.assessment.bookstorageapplication.service.AntiqueBookService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/antique")
@Validated
@Data
public class AntiqueBookController {

    @Autowired
    private final AntiqueBookService bookService;

    @PostMapping
    public ResponseEntity<AntiqueBook> addBook(@Valid @RequestBody AntiqueBook book) {
        bookService.addBook(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{barcode}")
    public ResponseEntity<AntiqueBook> getBookByBarcode(@PathVariable long barcode) {
        AntiqueBook book = bookService.getBookByBarcode(barcode);
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
    

  
}
