package com.assessment.bookstorageapplication.config;

import com.assessment.bookstorageapplication.model.AntiqueBook;
import com.assessment.bookstorageapplication.model.Book;
import com.assessment.bookstorageapplication.model.ScienceJournal;
import com.assessment.bookstorageapplication.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PredefinedDataFiller {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book(7897836, "Effective Java", "Joshua Blosh", 6, 49.99F));
            bookRepository.save(new Book(7877814, "Head First Java", "Kathy Sierra", 9, 45.99F));
            bookRepository.save(new Book(7848293, "Thinking in Java", "Bruce Eckel", 2, 39.99F));
            bookRepository.save(new AntiqueBook(2462312, "The Declaration of Independence", "Thomas Jefferson", 3, 939.99F, 1776));
            bookRepository.save(new AntiqueBook(2478434, "Shakespeare’s First Folio", "William Shakespeare", 2, 899.99F, 1622));
            bookRepository.save(new AntiqueBook(2478438, "The Gutenberg Bible", "Johannes Gutenberg", 1, 799.99F, 1440));
            bookRepository.save(new ScienceJournal(4154136, "Nature", "Max Planck", 9, 19.99F, 8));
            bookRepository.save(new ScienceJournal(4156132, "Computers", "Max Planck", 14, 16.99F, 7));
            bookRepository.save(new ScienceJournal(4195612, "Human", "Max Planck", 11, 16.99F, 6));
        };
    }
}
