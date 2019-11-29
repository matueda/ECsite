package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.AccountPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserDetailsDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	public AccountPageDTO getMyAccountUserInfo(String loginId) throws SQLException {
		AccountPageDTO dto = new AccountPageDTO();
		String sql ="SELECT * FROM login_user_transaction WHERE login_id = ?";
		try {

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {

				dto.setId(rs.getString("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("updated_date"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return dto;
	}

}
