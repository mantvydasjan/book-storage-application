package com.assessment.bookstorageapplication.service;

import com.assessment.bookstorageapplication.model.Book;
import com.assessment.bookstorageapplication.repository.BookRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
@Data
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    public void addBook(Book book) {
        if (bookRepository.existsById(book.getBarcode())) {
            Book existingBook = bookRepository.findBookByBarcode(book.getBarcode());
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


    public Book getBookByBarcode(Long barcode) {
        return bookRepository.findBookByBarcode(barcode);
    }

    public Book updateBook(Long barcode, Map<Object, Object> objectMap) {
        Book book = bookRepository.findBookByBarcode(barcode);
        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Book.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, book, value);
        });
        log.info("Book updated!");
        bookRepository.save(book);
        return book;

    }

    public double getTotalPrice(long barcode) {
        Book book = bookRepository.findBookByBarcode(barcode);
        return book.getPricePerUnit() * book.getQuantity();
    }

    public List<Book> findBooksByQuantity() {

        return bookRepository.findAllByOrderByQuantityDesc();
    }


}

