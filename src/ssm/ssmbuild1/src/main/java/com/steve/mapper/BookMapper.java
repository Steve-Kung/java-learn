package com.steve.mapper;

import com.steve.pojo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    public List<Book> selectBooks();
    public void addBook(Book book);
    public void deleteBook(@Param("bookId") int id);
    public void updateBook(Book book);
    public Book selectBookById(@Param("bookId") int id);
    public Book selectBookByName(@Param("bookName") String name);
}
