package com.example.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "rents")
public class Rents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne  // Dodane połączenie z klasą Student
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "book_code")
    private Book book;

    @Column(name = "book_code", insertable = false, updatable = false)
    private Integer bookCode;

    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer studentId;

    @Column(name = "rent_start_date")
    private LocalDate rentStartDate;

    @Column(name = "rent_end_date")
    private LocalDate rentEndDate;


    public Rents (Integer bookCode, Integer studentId, LocalDate rentStartDate){
        this.bookCode=bookCode;
        this.studentId=studentId;
        this.rentStartDate=rentStartDate;
    }
}







