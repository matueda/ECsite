package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class BuyItemCompleteDAO {

	//メインメソッド
public int buyItemDTOList(String item_transaction_id,String total_price,String total_count,String user_master_id,String pay) throws SQLException{

	//DBの設定
		DBConnector db=new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil=new DateUtil();

		//アイテムID、合計金額、合計個数、ユーザーID、支払い方法、購入日の情報を挿入する
String sql = "INSERT INTO user_buy_item_transaction (item_transaction_id,total_price,total_count,user_master_id,pay,insert_date) VALUES(?,?,?,?,?,?)";
int result = 0;

//例外が発生していないか調べる
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, item_transaction_id);
			ps.setString(2, total_price);
			ps.setString(3, total_count);
			ps.setString(4, user_master_id);
			ps.setString(5, pay);
			ps.setString(6, dateUtil.getDate());
			result = ps.executeUpdate();

			//してた場合の処理
		}catch(Exception e){
			e.printStackTrace();
		}finally{
				con.close();
		}
		return result;
}

//メインメソッド
public void changeItemStock(int count, String id) throws SQLException {
	//DBの設定
	DBConnector db = new DBConnector();
	Connection con = db.getConnection();

	//購入した場合、DB上にある該当商品の在庫数を購入数分引き正しい数に合わせる
	String sql = "UPDATE item_info_transaction SET item_stock = item_stock - ? WHERE id = ?";
	try {
//例外が発生していないか調べる
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, count);
		ps.setString(2, id);
		ps.executeUpdate();
		//していた場合の処理
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		con.close();
	}
}
}
