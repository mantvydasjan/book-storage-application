package com.assessment.bookstorageapplication.service;

import com.assessment.bookstorageapplication.model.AntiqueBook;
import com.assessment.bookstorageapplication.repository.AntiqueBookRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.Year;
import java.util.Map;

@Service
@Slf4j
@Data
public class AntiqueBookService {

    private final AntiqueBookRepository bookRepository;

    public void addBook(AntiqueBook book) {
        if (bookRepository.existsById(book.getBarcode())) {
            AntiqueBook existingBook = bookRepository.findBookByBarcode(book.getBarcode());
            int currentQuantity = existingBook.getQuantity();
            int increase = book.getQuantity();
            book.setQuantity(currentQuantity + increase);
            bookRepository.save(book);
            log.info("Book quantity increased!");
        } else {
            bookRepository.save(book);
            log.info("New book was added!");
        }
    }


    public AntiqueBook getBookByBarcode(Long barcode) {
        return bookRepository.findBookByBarcode(barcode);
    }

    public AntiqueBook updateBook(Long barcode, Map<Object, Object> objectMap) {
        AntiqueBook book = bookRepository.findBookByBarcode(barcode);
        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(AntiqueBook.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, book, value);
        });
        log.info("Book updated!");
        bookRepository.save(book);
        return book;

    }

    public double getTotalPrice(long barcode) {
        AntiqueBook book = bookRepository.findBookByBarcode(barcode);

        return book.getPricePerUnit() * book.getQuantity() * (Year.now().getValue() - book.getReleaseYear()) / 10;
    }
    

}
