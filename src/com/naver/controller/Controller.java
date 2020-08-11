package com.naver.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("*.nhn")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		StringBuffer url = request.getRequestURL();
		String uri = request.getRequestURI();
		String[] arrUri = uri.split("/");
		uri = arrUri[2];
//		for(int i=0; i<arrUri.length; i++) {
//			System.out.println(arrUri[i]);
//			
//		}

		String site = null;
		if (uri.equals("main.nhn")) {
			site = "main.jsp";
		} else if (uri.equals("login.nhn")) {
			site = "login.jsp";
		} else if (uri.equals("join.nhn")) {
			site = "join.jsp";
		} else if (uri.equals("login_ok.nhn")) {
			site = "LoginServlet";
		} else if (uri.equals("logout.nhn")) {
			site = "logout.jsp";

		} else if (uri.equals("join_ok.nhn")) {
			site = "JoinServlet";
			
		} else if (uri.equals("emailck.nhn")) {
			site = "EmailCKseervlet";
			
		} else if (uri.equals("search.nhn")) {
			site = "search.jsp";
			
		} else if (uri.equals("search_ok.nhn")) {
			site = "SearchServlet";
			
		} else if (uri.equals("food.nhn")) {
			site = "food.jsp";
			
		} else if (uri.equals("food_ok.nhn")) {
			site = "FoodServlet";
			
			
		} else if (uri.equals("movie.nhn")) {
			site = "movie.jsp";
			
		} else if (uri.equals("movie_ok.nhn")) {
			site = "MovieServlet";
			
		} else if (uri.equals("movie2.nhn")) {//2
			site = "MovieServlet2";
			
		} else if (uri.equals("hugi.nhn")) {
			site = "hugi.jsp";
			
		} else if (uri.equals("hugi_ok.nhn")) {
			site = "HugiServlet";
			
			

		} else {
			site = "404.jsp";
			System.out.println("error");
		}
		RequestDispatcher dis = request.getRequestDispatcher(site);
		dis.forward(request, response);

//		String addr =request.getRemoteAddr();
//		System.out.println(addr);				
//		int port =request.getRemotePort();
//		System.out.println(port);		
//		String host =request.getRemoteHost();
//		System.out.println(host);
//		response.getWriter().println("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
