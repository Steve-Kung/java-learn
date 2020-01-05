package com.steve.service;

import com.steve.mapper.BookMapper;
import com.steve.pojo.Book;

import java.util.List;

public class BookServiceImpl implements BookService {
//    service层调用mapper层
    private BookMapper bookMapper;
//    set方法
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public List<Book> selectBooks() {
        return bookMapper.selectBooks();
    }

    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    public void deleteBook(int id) {
        bookMapper.deleteBook(id);
    }

    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    public Book selectBookById(int id) {
        return bookMapper.selectBookById(id);
    }

    public Book selectBookByName(String name) {
        return bookMapper.selectBookByName(name);
    }
}
