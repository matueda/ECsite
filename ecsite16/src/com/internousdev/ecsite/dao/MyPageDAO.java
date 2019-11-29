package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.MyPageDTO;
import com.internousdev.ecsite.util.DBConnector;

public class MyPageDAO {

		public ArrayList<MyPageDTO> getMyPageUserInfo
				(String user_masgter_id) throws SQLException{

				//DB設定
				DBConnector db=new DBConnector();
				Connection con = db.getConnection();
				ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
				//ユーザー購入アイテムからID、合計金額、合計個数、購入方法、挿入日時
				//アイテム情報からアイテム名
				//これらを左外部結合条件をアイテム情報のIDで
				//正しく自分のログインIDと一致しているか確認して参照
				//並び順は更新データ順
				String sql = "SELECT ubit.id,iit.item_name,ubit.total_price,ubit.total_count,ubit.pay,ubit.insert_date FROM user_buy_item_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_transaction_id = iit.id WHERE ubit.user_master_id =? ORDER BY insert_date DESC";
				try{
					//例外検索
						PreparedStatement ps = con.prepareStatement(sql);
						ps.setString(1, user_masgter_id);

						ResultSet rs = ps.executeQuery();


						//dtoにwhileで必要な情報をsetしmypageDTOにadd
						while(rs.next()){
								MyPageDTO dto=new MyPageDTO();
								dto.setId(rs.getString("id"));
								dto.setItemName(rs.getString("item_name"));
								dto.setTotalPrice(rs.getString("total_price"));
								dto.setTotalCount(rs.getString("total_count"));
								dto.setPayment(rs.getString("pay"));
								dto.setInsert_date(rs.getString("insert_date"));
								myPageDTO.add(dto);
						}
						//例外処理
				}catch(Exception e){
					e.printStackTrace();
					//必ず切断
				}finally{
						con.close();
				}
				return myPageDTO;
		}

		//情報削除処理
		public int buyItemHistoryDelete
				(String user_master_id) throws SQLException{

			//DB設定
				DBConnector db=new DBConnector();
				Connection con=db.getConnection();

				//ユーザーの購入情報を削除、ユーザーIDを参照
String sql="DELETE FROM user_buy_item_transaction WHERE user_master_id=?";

				PreparedStatement ps;
				int result = 0;
				try{
					//チェック！
						ps=con.prepareStatement(sql);
						ps.setString(1, user_master_id);
						result = ps.executeUpdate();

						//例外処理
				}catch(SQLException e){
					e.printStackTrace();
					//必ず切断
				}finally{
						con.close();
				}
				return result;
		}

}
