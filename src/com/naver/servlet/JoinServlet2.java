package com.naver.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.dao.DAO;
import com.naver.dao.DAOImpl;
import com.naver.dto.DTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		
//		request.setAttribute("email", "a@a.com");             //String name = "ssss";  이거와 같다
//		RequestDispatcher dis = request.getRequestDispatcher("join.jsp");
//		dis.forward(request, response);
//   	넘어온 데이터를 받고 넘어온 데이터를 db에 넣고 로그인 페이지고 이동
		//한글 처리
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String mobile1 = request.getParameter("mobile1");
		String mobile2 = request.getParameter("mobile2");
		System.out.println(name);
		System.out.println(email);
		System.out.println(pw);
		System.out.println(mobile1);
		System.out.println(mobile2);
//데이터 db에 넣기
		DTO dto = new DTO();
		dto.setEmail(email);
		dto.setName(name);
		dto.setPw(pw);
		dto.setMobile(mobile1+mobile2);
		DAO dao = new DAOImpl();
		
		dao.insert(dto);
		response.sendRedirect("login.nhn");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
