
package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.SetAllPropertiesRule;

import com.google.gson.Gson;
import com.naver.dao.DAO;
import com.naver.dao.MovieDAO;
import com.naver.dao.MovieDAOImpl;
import com.naver.dto.MovieDTO;
import com.naver.utill.ApiExamSearchBlog;
import com.naver.utill.NvMovie;

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MovieServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		String search = request.getParameter("search");

		// view 쪽에 정보를 출력
//		 
		MovieDAO dao = new MovieDAOImpl();
		
		ArrayList<MovieDTO> list = dao.select();
//		ArrayList<MovieDTO> list = NvMovie.movie();

		response.setContentType("application/json; charset=UTF-8");
//		request.setAttribute("movie", dto);
//		System.out.println(dto);	
		Gson gson = new Gson();
		String jsonData = gson.toJson(list);
		System.out.println(jsonData);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonData);

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
