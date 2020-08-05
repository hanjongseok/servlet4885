package com.naver.dao;

import java.util.ArrayList;

import com.naver.dto.DTO;

public interface DAO {

	// 데이터 넣고 
	public void insert(DTO dto);
	
	// ID로 검색하고
	public boolean select(String email);
	
	// 전체 데이터 가져오기
//	public ArrayList<DTO> select();
	
	
	//이메일과 pw를 검색
	public DTO select(String email, String pw);
	
	
	// 점수 정보 업데이트
//	public void update(DTO dto);
}