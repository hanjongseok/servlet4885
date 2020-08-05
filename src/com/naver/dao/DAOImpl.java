package com.naver.dao;

import java.sql.*;
import java.util.ArrayList;

import com.naver.dto.DTO;

import db.DB;

public class DAOImpl implements DAO{

	@Override
	public void insert(DTO dto) {
		// 디비 연결
		// 쿼리 만들고
		// 쿼리 실행

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.conn(); 
			String sql = "INSERT INTO member_tbl (email, pw, name, mobile) VALUES (?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getMobile());
			
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	@Override
	public DTO select(String email, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		DTO dto = null;
		try {
			conn = DB.conn();
			String sql = "SELECT * FROM member_tbl WHERE email=? AND pw=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new DTO();
				dto.setNum(rs.getInt("num"));
				dto.setEmail(rs.getString("email"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setMobile(rs.getString("mobile"));
			
			} else {
				System.out.println("사용자가 없다");
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if( rs != null && !rs.isClosed()){
                    rs.close();
                }
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
		
		
		
		
	}

	
	
	@Override
	public boolean select(String email) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isEmail = false;
		
		// 전달 변수(dto 담을 그릇)
		DTO dto = null;
		try {
			conn = DB.conn();
			String sql = "SELECT * FROM member_tbl WHERE  email= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if( rs != null && !rs.isClosed()){
                    rs.close();
                }
				if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isEmail;
	}

//	@Override
//	public ArrayList<DTO> select() {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		// 전달 변수(dto 담을 그릇)
//		ArrayList<DTO> list = new ArrayList<DTO>();
//		try {
//			conn = DB.conn();
//			String sql = "SELECT * FROM member_tbl";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				DTO dto = new DTO();
//				dto.setName(rs.getString("name"));
//				list.add(dto);
//			}
//
//		} catch (Exception e) {
//			System.out.println("에러: " + e);
//		} finally {
//			try {
//				if( rs != null && !rs.isClosed()){
//                    rs.close();
//                }
//				if( pstmt != null && !pstmt.isClosed()){
//                    pstmt.close();
//                }
//				if (conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return list;
//	}

//	@Override
//	public void update(DTO dto) {
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = DB.conn(); 
//			String sql = "UPDATE member_tbl SET WHERE  id=?";
//			pstmt = conn.prepareStatement(sql);
//			
//			
//			int count = pstmt.executeUpdate();
//			if (count == 0) {
//				System.out.println("데이터 입력 실패");
//			} else {
//				System.out.println("데이터 입력 성공");
//			}
//
//		} catch (Exception e) {
//			System.out.println("에러: " + e);
//		} finally {
//			try {
//				if (conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//				if( pstmt != null && !pstmt.isClosed()){
//                    pstmt.close();
//                }
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		
//	}


}