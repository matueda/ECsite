package com.internousdev.ecsite.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import com.internousdev.ecsite.dto.AccountPageDTO;
import com.internousdev.ecsite.util.DBConnector;

//メインメソッド
public class AccountPageDAO {
	//リスト、例外は投げる
	public List<AccountPageDTO> getMyAccountUserInfo () throws SQLException{

		//データベースと接続するための作成
		DBConnector db = new DBConnector();
		Connection con=db.getConnection();

		//リスト制作
		List<AccountPageDTO> accountPageDTOList=new ArrayList<AccountPageDTO>();

		//ログインユーザーの情報を取得、順番はID順
		String sql="SELECT * FROM login_user_transaction ORDER BY id";
		try{
			//SQL発行
			PreparedStatement ps = con.prepareStatement(sql);
			//オブジェクトを返す
			ResultSet rs=ps.executeQuery();

			while(rs.next()){
				//dtoインスタンスを作りwhileで回して下記情報をsetしていく
				AccountPageDTO dto=new AccountPageDTO();
				dto.setId(rs.getString("id"));
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("updated_date"));
				//最後にDTOListに全てのsetした情報をaddする
				accountPageDTOList.add(dto);
			}
			//ここは例外処理
		}catch(Exception e){
			e.printStackTrace();
			//必ず接続を切る
		}finally{
			con.close();
		}
		return accountPageDTOList;
	}

}
