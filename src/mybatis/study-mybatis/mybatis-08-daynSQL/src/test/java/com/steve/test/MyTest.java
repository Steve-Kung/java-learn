package com.steve.test;

import com.steve.mapper.BookMapper;
import com.steve.pojo.Book;
import com.steve.utils.IdUtil;
import com.steve.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addBook(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        mapper.addBook(new Book(IdUtil.getId(), "this is good", "steve", new Date(),100));
        mapper.addBook(new Book(IdUtil.getId(), "this is nice", "steve", new Date(),100));
        mapper.addBook(new Book(IdUtil.getId(), "this is veryNice", "steve", new Date(),100));
        mapper.addBook(new Book(IdUtil.getId(), "this is veryGood", "steve", new Date(),100));
        List<Book> books = mapper.selectBooks();
        for (Book book : books) {
            System.out.println(book);
        }
        sqlSession.close();
    }
    @Test
    public void queryBookIF(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title","this is good");
        map.put("author", "steve");
        List<Book> books = mapper.queryBookIF(map);
        for (Book book : books) {
            System.out.println(book);
        }
        sqlSession.close();
    }

    @Test
    public void queryBookChoose(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title","this is good");
        map.put("author", "steve");
        map.put("views",80);
        List<Book> books = mapper.queryBookChoose(map);
        for (Book book : books) {
            System.out.println(book);
        }
        sqlSession.close();
    }

    @Test
    public void updateBook(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("title","this is good2");
        map.put("author", "steve2");
        map.put("id","7121800c84434111974f308ab79451be");
        mapper.updateBook(map);
        List<Book> books = mapper.selectBooks();
        for (Book book : books) {
            System.out.println(book);
        }
        sqlSession.close();
    }

    @Test
    public void queryBookForeach(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<String> ids = new ArrayList<String>();
        ids.add("7121800c84434111974f308ab79451be");
        ids.add("0cb0e74b50444ce98b6c9d882f5477ba");
        ids.add("d1a778add0cc451199d26d0e67ca2137");
        map.put("ids",ids);
        List<Book> books = mapper.queryBookForeach(map);
        for (Book book : books) {
            System.out.println(book);
        }
        sqlSession.close();
    }
}
