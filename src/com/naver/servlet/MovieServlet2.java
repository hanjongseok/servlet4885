
package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/MovieServlet2")
public class MovieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MovieServlet2() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//jquery사용 x
		// view 쪽에 정보를 출력
//		 
		MovieDAO dao = new MovieDAOImpl();	
		//데이터베이스 데이터 가져오기 버젼
		ArrayList<MovieDTO> list = dao.select();		
		//네이버 크롤링 버젼
//		ArrayList<MovieDTO> list = NvMovie.movie();
		
		//request에 데이터를 저장
		request.setAttribute("movie", list);
		//movie2.jsp로 데이터를 보낸다
		
		//view로 보냄
		RequestDispatcher dis =  request.getRequestDispatcher("movie2.jsp");
		
		dis.forward(request, response);
		
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
