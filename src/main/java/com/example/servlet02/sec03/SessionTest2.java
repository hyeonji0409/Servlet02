package com.example.servlet02.sec03;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "SessionTest2", value = "/sess2")
public class SessionTest2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        out.println("세션 아이디 : " + session.getId() + "<br>");
        out.println("최초 세션 생성 시각 : " + new Date(session.getCreationTime()) + "<br>");
        out.println("최근 세션 접근 시각 : " + new Date(session.getLastAccessedTime()) + "<br>");

        out.println("기본 세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
        session.setMaxInactiveInterval(5);        // 세션 유효 시간을 5초로 설정
        out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");

        if(session.isNew()) {
            out.print("새 세션이 만들어졌습니다");
        }
    }
}
