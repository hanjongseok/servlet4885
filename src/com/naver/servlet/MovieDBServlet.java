
package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.naver.dao.MovieDAO;
import com.naver.dao.MovieDAOImpl;
import com.naver.dto.MovieDTO;
import com.naver.utill.ApiExamSearchBlog;
import com.naver.utill.NvMovie;

@WebServlet("/MovieDBServlet")
public class MovieDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MovieDBServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		ArrayList<MovieDTO> list = NvMovie.movie();
		MovieDAO dao = new MovieDAOImpl();
		for (MovieDTO t : list) {
			dao.insert(t);
		}
	
		Gson gson = new Gson();
		String json = gson.toJson(list);
		 response.setContentType("application/json; charset=UTF-8");
		 PrintWriter out = response.getWriter();		
		 out.println(json);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
