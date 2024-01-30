package com.module.springboot.jazApp.repository;

import com.module.springboot.jazApp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Book findByBookCode(Integer bookCode);

    Book findByBookCode(int bookCode);
}