package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.util.DBConnector;

public class UserCreateConfirmDAO {
	//そのユーザーIDが存在するかどうかをtrueかfalseで
	public boolean isExistUser(String loginUserId) {
		//DB設定
		DBConnector db=new DBConnector();
		Connection con = db.getConnection();

		//全てのCOUNT数値をユーザー情報のログインIDと参照
		String sql = "SELECT COUNT(*) AS COUNT FROM login_user_transaction where login_id = ?";
		boolean result = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ResultSet rs = ps.executeQuery();
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
}
