package com.example.servlet02.sec02;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet(name = "GetCookieServlet", value = "/get")
public class GetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        Cookie[] allValues = request.getCookies();
        for(int i = 0; i<allValues.length; i++){
            if(allValues[i].getName().equals("cookieTest")){
                out.println("<h2>Cookie값 가져오기 : "
                + URLDecoder.decode(allValues[i].getValue(), "utf-8"));
            }
        }
    }
}
