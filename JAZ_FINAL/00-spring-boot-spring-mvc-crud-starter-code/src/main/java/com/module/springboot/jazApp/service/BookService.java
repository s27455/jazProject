package com.module.springboot.jazApp.service;



import com.module.springboot.jazApp.entity.Book;

import java.util.List;

public interface BookService {
    Book findByCode(int code);

    List<Book> findAll();
}
