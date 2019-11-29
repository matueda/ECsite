package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ResetPasswordDAO {
	public boolean referenceUserInfo(String loginUserId,String loginPassword){
		//DB設定
		DBConnector db=new DBConnector();
		Connection con = db.getConnection();

		//ログインユーザーの情報を取得、順番はID順
		String sql="SELECT COUNT(*) AS COUNT FROM login_user_transaction where login_id = ? and login_pass=?";
		boolean result = false;
		try{
			//SQL発行
			PreparedStatement ps = con.prepareStatement(sql);
			//オブジェクトを返す

			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);

			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				//true
				if(rs.getInt("COUNT") > 0) {
					result = true;
				}

			}
			//例外処理
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int resetPassword(String loginUserId, String loginPassword) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update login_user_transaction set login_pass=?, updated_date=now() where login_id=?";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginPassword);
			ps.setString(2, loginUserId);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	}
