package com.sunny.spring.boot.collection.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <Description> <br>
 *
 * @author Sunny<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/05/13 1:15 <br>
 * @see com.sunny.spring.boot.collection.web.servlet <br>
 */
@WebServlet(urlPatterns = "/my/async/servlet", asyncSupported = true)
public class MyAsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取异步的上下文
        AsyncContext asyncContext = req.startAsync();
        /**
         * 在子线程中执行
         */
        asyncContext.start(() -> {
            try {
                resp.getWriter().println("Hello Sunny, this is my asynchronized servlet!!");
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

      // resp.getWriter().println("Hello Sunny, this is out of my asynchronized servlet!!");


    }
}
