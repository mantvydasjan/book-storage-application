package com.assessment.bookstorageapplication.repository;

import com.assessment.bookstorageapplication.model.ScienceJournal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScienceJournalRepository extends JpaRepository<ScienceJournal, Long> {
    
    ScienceJournal findBookByBarcode(Long id);

    boolean existsById(Long id);
}
