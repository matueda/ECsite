package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemPageDAO {
	public List<ItemPageDTO> getAllItemInfo () throws SQLException{
		//db設定とリスト
		DBConnector db = new DBConnector();
		Connection con=db.getConnection();
		List<ItemPageDTO> itemPageDTOList=new ArrayList<ItemPageDTO>();

		//id順でアイテム情報を取得
		String sql ="SELECT * FROM item_info_transaction ORDER BY id";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			//dtoにwhileで情報セットしてdtoListにadd
			while(rs.next()){
				ItemPageDTO dto=new ItemPageDTO();
				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				dto.setInsert_date(rs.getString("insert_date"));
				dto.setUpdate_date(rs.getString("update_date"));
				itemPageDTOList.add(dto);
			}
			//例外処理と接続解除
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return itemPageDTOList;
	}

}
