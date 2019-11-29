package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class AttentionRegistrationDAO {
	public boolean referenceUserInfo(String loginUserId){
		//DB設定
		DBConnector db=new DBConnector();
		Connection con = db.getConnection();

		//ログインユーザーの情報を取得、順番はID順
		String sql="SELECT COUNT(*) AS COUNT FROM login_user_transaction where login_id = ?";
		boolean result = false;
		try{
			//SQL発行
			PreparedStatement ps = con.prepareStatement(sql);
			//オブジェクトを返す

			ps.setString(1, loginUserId);

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
	public int attentionRegistration(String familyName, String firstName, String familyNameKana, String firstNameKana, String streetAddress, String callNumber, String loginUserId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update login_user_transaction set family_name=? , first_name=? , family_name_kana=? , first_name_kana=? , street_address=? , call_number=?, updated_date=now() where login_id=?";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("familyName "+familyName);
			System.out.println("firstName "+firstName);
			System.out.println("familyNameKana "+familyNameKana);
			System.out.println("firstNameKana "+firstNameKana);
			System.out.println("streetAddress "+streetAddress);
			System.out.println("callNumber "+callNumber);
			System.out.println("loginUserId "+loginUserId);
			System.out.println("終わり");
			ps.setString(1, familyName);
			ps.setString(2, firstName);
			ps.setString(3, familyNameKana);
			ps.setString(4, firstNameKana);
			ps.setString(5, streetAddress);
			ps.setString(6, callNumber);
			ps.setString(7, loginUserId);
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
