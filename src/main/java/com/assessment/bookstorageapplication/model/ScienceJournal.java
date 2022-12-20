package com.assessment.bookstorageapplication.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ScienceJournal extends Book {

    @Min(value = 1 , message = "Science index should not be less than 1")
    @Max(value = 10 , message = "Science index should not be higher than 10")
    private int scienceIndex;

    public ScienceJournal(long barcode, String name, String author, int quantity, float pricePerUnit, int scienceIndex) {
        super(barcode, name, author, quantity, pricePerUnit);
        this.scienceIndex = scienceIndex;
    }
}
