package com.example.servlet02.sec04;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionLogout", value = "/logout")
public class SessionLogout extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        session.invalidate(); // 세션 무효화

        out.print("로그아웃 되었습니다. <br>");
        out.print("<a href='sessionLogin.html'>로그인</a>");
    }
}
