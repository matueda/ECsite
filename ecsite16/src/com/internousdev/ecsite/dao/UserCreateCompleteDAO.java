package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserCreateCompleteDAO {

	//アカウント作成なので戻り値はなし
		public void createUser(String loginUserId,String loginUserPassword,String userName) throws SQLException{

			//DB設定
			DBConnector db=new DBConnector();
			Connection con=db.getConnection();
			DateUtil dateUtil = new DateUtil();

			//ログインユーザー情報にID、PASS、名前、挿入した時間を挿入
String sql = "INSERT INTO login_user_transaction (login_id,login_pass,user_name,insert_date) VALUES(?,?,?,?)";
			try{
				//チェック
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, loginUserId);
					ps.setString(2, loginUserPassword);
					ps.setString(3, userName);
					ps.setString(4, dateUtil.getDate());

					ps.execute();
					//例外処理
			}catch(Exception e){
				e.printStackTrace();
				//必ず切断
			}finally{
					con.close();
			}
		}
}
