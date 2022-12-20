package com.assessment.bookstorageapplication.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class AntiqueBook extends Book {

    @Max(value = 1900, message = "Year should not be greater than 1900")
    private int releaseYear;

    public AntiqueBook(long barcode, String name, String author, int quantity, float pricePerUnit, int releaseYear) {
        super(barcode, name, author, quantity, pricePerUnit);
        this.releaseYear = releaseYear;
    }
}
