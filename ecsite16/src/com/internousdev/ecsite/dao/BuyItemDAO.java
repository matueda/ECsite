package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	public List<BuyItemDTO> getBuyItemInfo()throws SQLException{
		//DBの設定
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		//アレイリストを作る
		List<BuyItemDTO> buyItemDTOList=new ArrayList<BuyItemDTO>();

		//ID、名前、価格、在庫数をアイテムトランスアクションから取得。ただし在庫数が0より上のもののみ
		String sql = "SELECT id,item_name,item_price, item_stock FROM item_info_transaction where item_stock > 0";
		try {
			//SQL発行
			PreparedStatement ps = con.prepareStatement(sql);
			//オブジェクトを返す
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BuyItemDTO itemList=new BuyItemDTO();
				//itemListインスタンスを作りwhileで回して下記情報をsetしていく
				itemList.setId(rs.getString("id"));
				itemList.setItemName(rs.getString("item_name"));
				itemList.setItemPrice(rs.getString("item_price"));
				itemList.setItemStock(rs.getString("item_stock"));
				//最後にDTOListに全てのsetした情報をaddする
				buyItemDTOList.add(itemList);
			}
			//ここは例外処理
		} catch (Exception e) {
			e.printStackTrace();
			//必ず接続を切る
		}finally{
			con.close();
		}
		return buyItemDTOList;
	}
}
