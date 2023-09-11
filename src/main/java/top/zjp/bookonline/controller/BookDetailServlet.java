package top.zjp.bookonline.controller;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import top.zjp.bookonline.entity.Book;
import top.zjp.bookonline.service.BookService;
import top.zjp.bookonline.service.impl.BookServiceImpl;

import java.io.IOException;

/**
 * 图书详情接口
 *
 * @author zjp
 */
@WebServlet("/detail/*")
public class BookDetailServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        bookService = new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的URL,并去除空格
        String requestPath = req.getRequestURI().trim();
        //获得最后一个"/"的位置
        int position = requestPath.lastIndexOf("/");
        //从该位置到最后取子串,也就是"/detail/3"中的3,有了这个id,就可以取集合中找到匹配的图书对象
        String id = requestPath.substring(position + 1);
        //根据id查找图书
        Book book = bookService.getBookById(Integer.parseInt(id));
        //携带参数转发到book_detail 页面
        req.setAttribute("book", book);
        req.getRequestDispatcher("/book_detail.jsp").forward(req, resp);
    }
}
