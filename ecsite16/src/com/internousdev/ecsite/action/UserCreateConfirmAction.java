package com.internousdev.ecsite.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{
	//変数・インスタンスを作成
		private String loginUserId;
		private String loginPassword;
		private String userName;
		private Map<String,Object> session;
		private String errorMessage;

		public String execute(){
			String result = SUCCESS;

			//equalsで参照先の値を確認。intではなくStringなので==ではなくequals
			//!がついているので、同じではない時
			if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))){
				UserCreateConfirmDAO userCreateConfirmDAO = new UserCreateConfirmDAO();
				if(!userCreateConfirmDAO.isExistUser(loginUserId)) {
					session.put("loginUserId", loginUserId);
					session.put("loginPassword", loginPassword);
					session.put("userName", userName);

					//同じだった場合はエラーメッセージを出す
				} else {
					setErrorMessage("すでに登録されているログインIDです。");
					result = ERROR;
				}
				//上のパターンに該当しないエラーメッセージの場合はこちら
			}else{
					setErrorMessage("未入力の項目があります。");
					result =ERROR;
			}
			return result;

		}
		//ゲッターセッターオーバーライド
		public String getLoginUserId(){
			return loginUserId;
		}
		public void setLoginUserId(String loginUserId){
			this.loginUserId=loginUserId;
		}
		public String getLoginPassword(){
			return loginPassword;
		}
		public void setLoginPassword(String loginPassword){
			this.loginPassword=loginPassword;
		}
		public String getUserName(){
			return userName;
		}
		public void setUserName(String userName){
			this.userName=userName;
		}
		public String getErrorMessage(){
			return errorMessage;
		}
		public void setErrorMessage(String errorMessage){
			this.errorMessage=errorMessage;
		}
		public Map<String,Object>getSession(){
			return this.session;
		}
		@Override
		public void setSession(Map<String,Object> session){
			this.session=session;
		}
}
