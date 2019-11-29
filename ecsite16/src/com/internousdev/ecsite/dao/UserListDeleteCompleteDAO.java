package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {
	public int deleteUserList()throws SQLException{

		//DB設定
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	//ユーザー情報を削除。ただし管理者権限を除く
String sql="DELETE FROM login_user_transaction WHERE admin_flg <=0";

	PreparedStatement ps;
	int result = 0;
	try{
			ps=con.prepareStatement(sql);
			result = ps.executeUpdate();
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
			con.close();
	}
	return result;
}
}
