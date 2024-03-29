package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.internousdev.ecsite.dao.UserCreateCompleteDAO;

//他のアクションと同じ
public class UserCreateCompleteAction extends ActionSupport implements SessionAware{

	//変数・インスタンスを作成
		private String loginUserId;
		private String loginPassword;
		private String userName;
		private Map<String,Object> session;
		private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();


		//execute()を例外処理は投げる
		public String execute() throws SQLException{

			//SUCCESSの段階でID、PASS、ユーザーネームをセッションから取り出す
				userCreateCompleteDAO.createUser(session.get("loginUserId").toString(),
						session.get("loginPassword").toString(),
						session.get("userName").toString());

						String result =SUCCESS;
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
		public Map<String,Object> getSession(){
			return this.session;
		}
		@Override
		public void setSession(Map<String,Object> session){
			this.session=session;
		}

}
