package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.AccountPageDAO;
import com.internousdev.ecsite.dto.AccountPageDTO;
import com.opensymphony.xwork2.ActionSupport;

//AccountPageActionにActionSupportを継承しSessionAwareを実装
public class AccountPageAction extends ActionSupport implements SessionAware{

	private String message;
	private Map<String,Object> session;
	private List<AccountPageDTO> userPageList=new ArrayList<AccountPageDTO>();


	//executeメソッドで例外はSQLExceptionに投げる
	public String execute() throws SQLException {
		AccountPageDAO accountPageDAO = new AccountPageDAO();
		userPageList = accountPageDAO.getMyAccountUserInfo();
		if(!(userPageList.size() > 0)) {
			userPageList = null;
		}

		String result = SUCCESS;
		return result;
	}
//ゲッターセッター
	public List<AccountPageDTO> getUserPageList() {
		return this.userPageList;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return this.session;
	}
}
