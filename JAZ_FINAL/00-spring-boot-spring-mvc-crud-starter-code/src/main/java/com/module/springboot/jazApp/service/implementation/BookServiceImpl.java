package com.module.springboot.jazApp.service.implementation;
import com.module.springboot.jazApp.repository.BookRepository;
import com.module.springboot.jazApp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.module.springboot.jazApp.entity.Book;
import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book findByCode(int code) {
        return bookRepository.findByBookCode(code);
    }
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
