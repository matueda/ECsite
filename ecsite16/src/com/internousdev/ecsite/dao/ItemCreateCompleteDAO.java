package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {

			public void createItem(String itemName,String itemPrice,String itemStock) throws SQLException{

				//DB設定
				DBConnector db=new DBConnector();
				Connection con=db.getConnection();
				DateUtil dateUtil = new DateUtil();
				//アイテムの情報にアイテム名、値段、個数、時間を挿入する
	String sql = "INSERT INTO item_info_transaction (item_name,item_price,item_stock,insert_date) VALUES(?,?,?,?)";
				try{
					//例外が発生していないか調べる
						PreparedStatement ps=con.prepareStatement(sql);
						ps.setString(1, itemName);
						ps.setString(2, itemPrice);
						ps.setString(3, itemStock);
						ps.setString(4, dateUtil.getDate());

						ps.execute();
						//していた場合の処理
				}catch(Exception e){
					e.printStackTrace();
				}finally{
						con.close();
				}
			}
	}

