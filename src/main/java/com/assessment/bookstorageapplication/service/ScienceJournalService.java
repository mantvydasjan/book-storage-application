package com.assessment.bookstorageapplication.service;

import com.assessment.bookstorageapplication.model.ScienceJournal;
import com.assessment.bookstorageapplication.repository.ScienceJournalRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

@Service
@Slf4j
@Data
public class ScienceJournalService {

    private final ScienceJournalRepository bookRepository;

    public void addBook(ScienceJournal book) {
        if (bookRepository.existsById(book.getBarcode())) {
            ScienceJournal existingBook = bookRepository.findBookByBarcode(book.getBarcode());
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


    public ScienceJournal getBookByBarcode(Long barcode) {
        return bookRepository.findBookByBarcode(barcode);
    }

    public ScienceJournal updateBook(Long barcode, Map<Object, Object> objectMap) {
        ScienceJournal book = bookRepository.findBookByBarcode(barcode);
        objectMap.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(ScienceJournal.class, (String) key);
            field.setAccessible(true);
            ReflectionUtils.setField(field, book, value);
        });
        log.info("Book updated!");
        bookRepository.save(book);
        return book;

    }

    public double getTotalPrice(long barcode) {
        ScienceJournal book = bookRepository.findBookByBarcode(barcode);
        return book.getPricePerUnit() * book.getQuantity() * book.getScienceIndex();
    }
  

}
