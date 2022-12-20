package com.assessment.bookstorageapplication.repository;

import com.assessment.bookstorageapplication.model.AntiqueBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AntiqueBookRepository extends JpaRepository<AntiqueBook, Long> {
    
    AntiqueBook findBookByBarcode(Long id);

    boolean existsById(Long id);
}
