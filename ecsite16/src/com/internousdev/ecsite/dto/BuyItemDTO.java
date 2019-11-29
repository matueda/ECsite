package com.internousdev.ecsite.dto;

public class BuyItemDTO {

	private String id;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String itemTransactionId;
	private String count;
	private int subtotal;
	private int checkCount;
	private String totalCount;
	private String userMasterId;
	private String pay;

	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
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
		this.itemPrice = itemPrice;
	}
	public String getItemStock(){
		return itemStock;
	}
	public void setItemStock(String itemStock){
		this.itemStock=itemStock;
	}
	public String getItemTransactionId(){
		return itemTransactionId;
	}
	public void setItemTransactionId(String itemTransactionId){
		this.itemTransactionId=itemTransactionId;
	}
	public String getCount(){
		return count;
	}
	public void setCount(String count){
		this.count=count;
	}
	public int getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	public int getCheckCount() {
		return checkCount;
	}
	public void setCheckCount(int checkCount) {
		this.checkCount = checkCount;
	}
	public String getTotalCount(){
		return totalCount;
	}
	public void setTotalCount(String totalCount){
		this.totalCount=totalCount;
	}
	public String getUserMasterId(){
		return userMasterId;
	}
	public void setUserMasterId(String userMasterId){
		this.userMasterId=userMasterId;
	}
	public String getPay(){
		return pay;
	}
	public void setPay(String pay){
		this.pay=pay;
	}
}
