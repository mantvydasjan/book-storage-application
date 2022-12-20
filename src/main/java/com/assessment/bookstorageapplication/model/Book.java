package com.assessment.bookstorageapplication.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @Column(nullable = false, updatable = false)
    private long barcode;
    private String name;
    private String author;
    private int quantity;
    private float pricePerUnit;
    
    
}
