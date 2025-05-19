package com.korit.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/api/name")
public class NameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("age"));

        // .getParameter()는 무조건 String으로 가져오기 때문에
        // 숫자로 바꾸고자 한다면 중간에 Pasing 과정을 거친다.

        String name = req.getParameter("name");
        String age = req.getParameter("age");

        // age로 들어온 것이 숫자인 경우에만 바꿔줘야만 한다.
        // 그렇지 않으면 오류 발생 -> try-catch문
        int intAge = 0;
        try {
            intAge = Integer.parseInt(age);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(intAge + 10);

        resp.getWriter().println("이수원");
    }
}
