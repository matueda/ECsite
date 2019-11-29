package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {
	public int deleteItemList()throws SQLException{

		//DB設定
	DBConnector db=new DBConnector();
	Connection con=db.getConnection();

	//アイテム情報の削除
String sql="DELETE FROM item_info_transaction";

	PreparedStatement ps;
	int result = 0;
	try{
		//例外確認
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
