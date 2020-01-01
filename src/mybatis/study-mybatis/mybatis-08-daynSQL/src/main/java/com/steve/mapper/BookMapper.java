package com.steve.mapper;

import com.steve.pojo.Book;

import java.util.List;
import java.util.Map;

public interface BookMapper {
    public void addBook(Book book);
    public List<Book> selectBooks();
    public List<Book> queryBookIF(Map map);
    public List<Book> queryBookChoose(Map map);
    public void updateBook(Map map);
    public List<Book> queryBookForeach(Map map);
}
