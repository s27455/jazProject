package com.example.model.DTO;

import com.example.model.entity.Rents;
import lombok.Data;

@Data
public class RentDTO {

    private Rents rents;

    private String bookTitle;

    private Integer bookCode;

    private Integer studentId;

    public RentDTO(Rents rents, String bookTitle, Integer bookCode, Integer studentId) {
        this.rents = rents;
        this.bookTitle = bookTitle;
        this.bookCode = bookCode;
        this.studentId=studentId;
    }
}