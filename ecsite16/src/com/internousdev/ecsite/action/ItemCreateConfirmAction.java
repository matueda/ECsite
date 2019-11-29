package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{

	private String itemName;
	private String itemPrice;
	private String itemStock;
	private Map<String,Object> session;
	private String errorMessage;

	public String execute(){
		String result = SUCCESS;

		//equalsで参照先の値を確認。intではなくStringなので==ではなくequals
		//!がついているので、同じではない時
		if(!(itemName.equals(""))
			&& !(itemPrice.equals(""))
			&& !(itemStock.equals(""))){
			//セッションにput
				session.put("itemName", itemName);
				session.put("itemPrice", itemPrice);
				session.put("itemStock", itemStock);
				try {
					//文字列から数値へ変換
					Integer.parseInt(itemPrice);
					Integer.parseInt(itemStock);

					//例外処理
				}catch (NumberFormatException e) {
					setErrorMessage("値段または在庫に数値以外が入力されています");
					result = ERROR;
				}
				//例外処理2
		}else{
				setErrorMessage("未入力の項目があります。");
				result =ERROR;
		}
		return result;

	}
	//ゲッターセッターオーバーライド
	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName=itemName;
	}
	public String getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(String itemPrice){
		this.itemPrice=itemPrice;
	}
	public String getItemStock(){
		return itemStock;
	}
	public void setItemStock(String itemStock){
		this.itemStock=itemStock;
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
