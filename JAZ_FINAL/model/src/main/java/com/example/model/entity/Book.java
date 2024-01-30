package com.example.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;

@Data
@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "book_code")
    private int bookCode;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @OneToMany(mappedBy = "book")
    private Set<Rents> rents;
    }
