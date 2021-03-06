package com.example.servlet02.sec01;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
        String user_address = request.getParameter("user_address");
        String user_email = request.getParameter("user_email");
        String user_hp = request.getParameter("user_hp");

        String data = "<html><body>";
        data += "안녕하세요!<br> 로그인하셨습니다.<br><br>";
        data += "아이디 : " + user_id + "<br>";
        data += "비밀번호 : " + user_pw + "<br>";
        data += "주소 : " + user_address + "<br>";
        data += "이메일 : " + user_email + "<br>";
        data += "휴대전화 : " + user_hp;
        out.print(data);

        // URL Rewriting 방식 이용

        user_address = URLEncoder.encode(user_address, "utf-8");
        out.print("<br><br><a href='/Gradle___com_example___Servlet02_1_0_SNAPSHOT_war/second?user_id=" + user_id
                + "&user_pw=" + user_pw
                + "&user_address=" + user_address
                + "'>두 번째 서블릿으로 보내기</a>");
        data = "</body></html>";
        out.print(data);
    }
}
