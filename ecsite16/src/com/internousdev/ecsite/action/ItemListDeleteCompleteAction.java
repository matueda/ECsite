package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


//メインクラス定義
public class ItemListDeleteCompleteAction extends ActionSupport{
	private String message;

	//execute、例外処理
	public String execute() throws SQLException{
		String result = ERROR;
		//インスタンス化
		ItemListDeleteCompleteDAO itemDeleteListCompleteDAO = new ItemListDeleteCompleteDAO();
		int res = itemDeleteListCompleteDAO.deleteItemList();


		//分岐
		if(res > 0){
				setMessage("商品を正しく削除しました。");
		} else {
			setMessage("商品の削除に失敗しました。");
		}
		result = SUCCESS;
		return result;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
}
