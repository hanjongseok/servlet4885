package com.naver.dao;

import java.sql.*;

import com.naver.dto.HugiDTO;
import db.DB;

public class HugiDAOImpl implements HugiDAO {

	@Override
	public void insert(HugiDTO dto) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DB.conn();
			String sql = "INSERT INTO hugi (mb_num, mv_num, title, content) VALUES ( ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, dto.getMb_num());
			pstmt.setString(2, dto.getMv_num());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getHugi());

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
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
