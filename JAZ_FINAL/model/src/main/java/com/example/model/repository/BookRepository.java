package com.example.model.repository;

import com.example.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByBookCode(Integer bookCode);

    Book findByBookCode(int bookCode);
}