package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

//メインクラス定義
public class UserListDeleteCompleteAction extends ActionSupport{
	private String message;
	//execute、例外処理
	public String execute() throws SQLException{
		//インスタンス化
		String result = ERROR;
		UserListDeleteCompleteDAO userDeleteListCompleteDAO = new UserListDeleteCompleteDAO();
		int res = userDeleteListCompleteDAO.deleteUserList();


		//分岐
		if(res > 0){
				setMessage("ユーザー情報を正しく削除しました。");
		} else {
			setMessage("ユーザー情報の削除に失敗しました。");
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
