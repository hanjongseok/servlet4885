package com.naver.dao;

import java.util.ArrayList;

import com.naver.dto.MovieDTO;

public interface MovieDAO {

	// 데이터 넣고 
		public void insert(MovieDTO dto);
		
		// ID로 검색하고
//		public boolean select(String email);
		
		// 전체 데이터 가져오기
		public ArrayList<MovieDTO> select();
		
		// Email 과 PW를 검색
		public MovieDTO select(String email, String pw);
		
		// 점수 정보 업데이트
		public void update(MovieDTO dto);
	
}
