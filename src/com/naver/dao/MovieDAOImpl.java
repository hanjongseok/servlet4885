package com.naver.dao;

import java.sql.*;
import java.util.ArrayList;

import com.naver.dto.MovieDTO;

import db.DB;

public class MovieDAOImpl implements MovieDAO{

	@Override
	public void insert(MovieDTO dto) {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.conn(); 
//			String sql = "INSERT INTO movie (je, bae, gam, img) VALUES (?, ?, ?, ?)WHERE NOT EXISTS ((SELECT je, bae, gam, img FROM movie WHERE je = ?)";
			
			StringBuffer sql = new StringBuffer();
			sql.append("INSERT INTO movie (je, bae, gam, img)");
			sql.append(" SELECT ?, ?, ?, ? FROM DUAL WHERE NOT EXISTS");
			sql.append("(SELECT je, bae, gam, img FROM movie WHERE je = ?  )");
			
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, dto.getJe());
			pstmt.setString(2, dto.getBae());
			pstmt.setString(3, dto.getGam());
			pstmt.setString(4, dto.getImg());
			pstmt.setString(5, dto.getJe());
			
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

//	@Override
//	public boolean select(MovieDTO dto) {
//		// TODO Auto-generated method stub
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		boolean isEmail = false;   // 데이터가 없으면 false
//		try {
//			conn = DB.conn();
////			String sql = "SELECT * FROM user WHERE  id= '" + id + "'";
//			String sql = "SELECT * FROM member WHERE  email = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, email);
//			rs = pstmt.executeQuery();
//			
//			if (rs.next()) {
//				isEmail = true;  // 데이터가 있으면 true
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
//		return isEmail;
//	}

	public ArrayList<MovieDTO> select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		ArrayList<MovieDTO> list = new ArrayList<MovieDTO>();
		try {
			conn = DB.conn();
			String sql = "SELECT * FROM movie";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MovieDTO dto = new MovieDTO();
				dto.setNum(rs.getInt("num"));
				dto.setJe(rs.getString("je"));
				dto.setBae(rs.getString("bae"));
				dto.setGam(rs.getString("gam"));
				dto.setImg(rs.getString("img"));
				list.add(dto);
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
		return list;
	}

	@Override
	public MovieDTO select(String email, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 전달 변수(dto 담을 그릇)
		MovieDTO dto = null;
//		try {
//			conn = DB.conn();
//			String sql = "SELECT * FROM member WHERE  email = ? AND pw = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, email);
//			pstmt.setString(2, pw);
//			rs = pstmt.executeQuery();
//			
//			if (rs.next()) {
//				dto = new MovieDto();
//				dto.setNum(rs.getInt("num"));
//				dto.setEmail(rs.getString("email"));
//				dto.setPw(rs.getString("pw"));
//				dto.setName(rs.getString("name"));
//				dto.setTel(rs.getString("tel"));
//			} else {
//				System.out.println("사용자가 없다");
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
		return dto;
	}

	@Override
	public void update(MovieDTO dto) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = DB.conn(); 
//			String sql = "UPDATE user SET jumsu=? WHERE  id=?";
//			pstmt = conn.prepareStatement(sql);
//			
////			pstmt.setInt(1, dto.getJumsu());
//			pstmt.setString(2, dto.getId());
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
		
	}

	
	
}
