package com.steve.controller;

import com.steve.pojo.Book;
import com.steve.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

//    查看所有书籍
    @RequestMapping("/selectBooks")
    public String selectBooks(Model model){
        List<Book> bookList = bookService.selectBooks();
        model.addAttribute("bookList", bookList);
        return "allBooks";
    }
//    进入添加书籍页面
    @RequestMapping("/toAddBookPage")
    public String toAddBookPage(){
        return "addBookPage";
    }
    //添加书籍操作
    @RequestMapping("/addBook")
    public String addBook(Book book){
        bookService.addBook(book);
        return "redirect:/book/selectBooks";
    }

    //    进入修改书籍页面
    @RequestMapping("/toUpdateBookPage/{bookId}")
    public String toUpdateBookPage(@PathVariable("bookId") int bookId, Model model){
        Book updateBook = bookService.selectBookById(bookId);
        model.addAttribute("updateBook", updateBook);
        return "updateBookPage";
    }
    // 修改书籍操作
    @RequestMapping("/updateBook")
    public String updateBook(Book book){
        bookService.updateBook(book);
        return "redirect:/book/selectBooks";
    }
    // 删除书籍操作
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBook(bookId);
        return "redirect:/book/selectBooks";
    }
    // 查询书籍名字
    @RequestMapping("/selectBookByName")
    public String selectBookByName(String bookName, Model model){
        Book book = bookService.selectBookByName(bookName);
        String str = null;
        if(book == null){
            str = "不好意思，您所查询书籍暂时还没有，请点击返回查看全部书籍";
        }
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(book);
        model.addAttribute("bookList", bookList);
        model.addAttribute("msg", str);
        return "allBooks";
    }

}
