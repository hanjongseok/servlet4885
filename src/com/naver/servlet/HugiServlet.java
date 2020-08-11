
package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.dao.HugiDAO;
import com.naver.dao.HugiDAOImpl;
import com.naver.dto.*;

@WebServlet("/HugiServlet")
public class HugiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HugiServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HugiDTO dto = new HugiDTO();
			
		String mb_num = request.getParameter("mb_num");
		String mv_num = request.getParameter("mv_num");
		String title = request.getParameter("h_tit");
		String hugi = request.getParameter("hugi");
//		float score = request.getParameter("score");
		System.out.println(mb_num);
		System.out.println(mv_num);
		System.out.println(title);
		System.out.println(hugi);

		
////데이터 db에 넣기
		dto.setMb_num(mb_num);
		dto.setMv_num(mv_num);
		dto.setTitle(title);
		dto.setHugi(hugi);
		
		HugiDAO dao = new HugiDAOImpl();
		
		dao.insert(dto);

	
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
