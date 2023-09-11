package top.zjp.bookonline.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.zjp.bookonline.entity.Book;
import top.zjp.bookonline.service.BookService;
import top.zjp.bookonline.service.impl.BookServiceImpl;

import java.io.IOException;
import java.util.List;

/**
 * 拦截/index请求,获取所有图书数据,并通过服务器端转发跳转到主页
 *
 * @author zjp
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookService bookService = new BookServiceImpl();
        List<Book> bookList = bookService.getBooks();
        //存入request
        req.setAttribute("bookList", bookList);
        //通过服务器端转发,将数据带过去,并保持地址栏不变
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
