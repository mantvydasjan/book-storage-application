package com.assessment.bookstorageapplication.repository;

import com.assessment.bookstorageapplication.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByBarcode(Long id);
    
    List<Book> findAllByOrderByQuantityDesc();
    
    boolean existsById(Long id);
}

