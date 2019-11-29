package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;

//メインクラス定義
public class HomeAction2 extends ActionSupport implements SessionAware{
	private Map<String,Object> session;

	//execute、例外はSQLExceptionへ
	public String execute()throws SQLException{

		//ログイン
			String result = "login";
			if(session.containsKey("login_user_id")){
				BuyItemDAO buyItemDAO=new BuyItemDAO();
				List<BuyItemDTO> buyItemDTOList = buyItemDAO.getBuyItemInfo();
				session.put("buyItemDTOList", buyItemDTOList);
					result =SUCCESS;
			}
			return result;
	}
	public Map<String,Object> getSession(){
		return this.session;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
