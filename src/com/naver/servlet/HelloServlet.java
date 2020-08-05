package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HelloServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//여기 메소드만 신경쓰기
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		PrintWriter out =  response.getWriter();
		System.out.println("콘솔창 입력 ㅇㅇㅇㅇ");
		System.out.println("당신이 입력한 이메일을 전달해줌 <br>"+email);
		out.println("hello wolrd  이수근 돼지 <br>");
		out.println("hello wolrd  이수근 돼지 ");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}




//1. 받을 때 : 한글깨짐 해결(post 방식)
//request.setCharacterEncoding("utf-8");    
//2. 받을 때 : GET방식 처리
//String filename = 
// new  String(request.getParameter("parameter").getBytes("8859_1"),"KSC5601");   
//3. 보낼 때 한글처리
//response.setContentType("text/html;charset=utf-8");     




