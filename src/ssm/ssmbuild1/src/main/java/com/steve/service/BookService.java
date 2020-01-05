package com.steve.service;

import com.steve.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    public List<Book> selectBooks();
    public void addBook(Book book);
    public void deleteBook(int id);
    public void updateBook(Book book);
    public Book selectBookById(int id);
    public Book selectBookByName(String name);
}
