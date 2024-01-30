package com.module.springboot.jazApp.DTO;

import com.module.springboot.jazApp.entity.Rents;
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