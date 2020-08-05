
package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.utill.FoodApiExamSearchBlog;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//view (jsp, html)에서 넘어오는 데이터를 search 값을 받아준다
		String search = request.getParameter("search");
		//네이버 api를 활용해서 정보를 가져온나(json형태)
		 String jsonData = FoodApiExamSearchBlog.search(search+"맛집");
		//view 쪽에 정보를 출력
		 
		 response.setContentType("application/json; charset=UTF-8");
		 PrintWriter out = response.getWriter();		
		 out.println(jsonData);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
