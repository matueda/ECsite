package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemPageDAO;
import com.internousdev.ecsite.dto.ItemPageDTO;
import com.opensymphony.xwork2.ActionSupport;

//メインクラス定義、他のActionとほぼ同じ
public class ItemPageAction extends ActionSupport implements SessionAware{

	private String message;
	private Map<String,Object> session;
	private List<ItemPageDTO> itemPageList=new ArrayList<ItemPageDTO>();



	public String execute() throws SQLException {
		//インスタンス化
		ItemPageDAO itemPageDAO = new ItemPageDAO();
		itemPageList = itemPageDAO.getAllItemInfo();

		//中に何か入っていたらNullをいれる
		if(!(itemPageList.size() > 0)) {
			itemPageList = null;
		}

		String result = SUCCESS;
		return result;
	}

	//ゲッターセッターオーバーライド
	public List<ItemPageDTO> getItemPageList() {
		return this.itemPageList;
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
