package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
//import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
//import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Collection;
import java.util.List;
import java.util.Map;


//メインクラスの定義
public class BuyItemConfirmAction2 extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private List<BuyItemDTO> buyItemDTOList=new ArrayList<BuyItemDTO>();


//クラスの定義、例外はSQLExceptionへ
	public String execute() throws SQLException {
//		String transactionId = ((LoginDTO) session.get("login_user_id")).getLoginId().toString();
		BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

		//変数・インスタンスを作成
		int[] checkList=(int[]) session.get("checkList");
		String[] idList=(String[]) session.get("idList");
		String[] countList=(String[]) session.get("countList");
		String[] itemPriceList=(String[]) session.get("itemPriceList");
		String[] itemStockList=(String[]) session.get("itemStockList");
		String[] itemNameList=(String[]) session.get("itemNameList");
		int totalPrice = 0;

		//for文でBuyItemActionと同様に参照させて
		//購入するアイテムに差異がないかチェック
		for(int i=0; i<checkList.length; i++) {
			String id = idList[checkList[i]];
			String counts = countList[checkList[i]];
			String itemStock = itemStockList[checkList[i]];
			String itemPrice = itemPriceList[checkList[i]];
			String itemName = itemNameList[checkList[i]];

			int Count=Integer.parseInt(countList[checkList[i]].toString());
			int price=Integer.parseInt(itemPriceList[checkList[i]].toString());
			int subtotal=price * Count;
			totalPrice += subtotal;

			//デバッグ用メッセージログ
		System.out.println("チェック開始！");
		System.out.println("ID:" + id);
		System.out.println("COUNT:" + counts);
		System.out.println("ITEMSTOCK:" + itemStock);
		System.out.println("ITEMPRICE:" + itemPrice);
		System.out.println("ITEMNAME:" + itemName);
		System.out.println("PRICE       :"+price);
		System.out.println("SUBTOTAL       :"+subtotal);
		System.out.println("TOTALPRICE       :"+ totalPrice);
		System.out.println("チェックヨシ！");

		//チェックした必要な情報をsessionにputする。
		session.put("id", id);
		session.put("total_price", totalPrice);
		session.put("counts", counts);

		//画面上に表示させる購入画面の処理を飛ばす
		int count = buyItemCompleteDAO.buyItemDTOList(
				session.get("id").toString(),
				session.get("subtotal").toString(),
				session.get("counts").toString(),
				session.get("login_user_id").toString(),
				session.get("pay").toString());
			if (count > 0) {
				buyItemCompleteDAO.changeItemStock(Integer.parseInt(session.get("counts").toString()), session.get("id").toString());
			}
		}
	String result = SUCCESS;
	return result;
}

	//ゲッターセッターオーバーライド
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public List<BuyItemDTO> getBuyItemDTOList() {
		return buyItemDTOList;
	}

	public void setBuyItemDTOList(List<BuyItemDTO> buyItemDTOList) {
		this.buyItemDTOList = buyItemDTOList;
	}
}
//	private String id;
//	private String itemTransactionId;
//	private String itemName;
//	private String itemPrice;
//	private String totalCount;
//	private String totalPrice;
//	private String itemStock;
//	private Collection<String> checkList;
//
//	private String count;
//	private String loginUserId;
//	private String userMasterId;
//	private String errorMessage;
//
//	private String pay;
//	private Map<String,Object> session;
//	public String execute()throws SQLException{
//		String result = ERROR;
//		System.out.println("------BuyItemAction");
//
//		System.out.println("ID : "+id);
//		System.out.println("ITEMNAME : "+ itemName);
//		System.out.println("ITEMPRICE : "+itemPrice);
//		System.out.println("ITEMSTOCK : "+itemStock);
//		System.out.println("COUNT : "+count);
//		System.out.println("PAY : "+pay);
//		System.out.println("CHECKLIST  : " + checkList);
//		System.out.println("LOGINUSERID  : " + loginUserId);
//		System.out.println("USERMASTERID : " + userMasterId);
//
//		String[] idList=id.split(", ", 0);
//		String[] itemNameList=itemName.split(", ",0);
//		String[] itemPriceList=itemPrice.split(", ", 0);
//		String[] itemStockList=itemStock.split(", ", 0);
//		String[] countList=count.split(", ", 0);
//
//		if((userMasterId.indexOf(",")) > 0){
//			String[] userMasterIdList=userMasterId.split(", ", 0);
//			userMasterId= String.valueOf(userMasterIdList[0]);
//		}
//		if(checkList==null){
//			errorMessage="商品が選択されていません。";
//			BuyItemDAO dao = new BuyItemDAO();
//			buyItemDTOList = dao.getBuyItemInfo();
//			return ERROR;
//	}
//
//		System.out.println("ID数--------->" + idList.length);
//		for(int i=0; i<idList.length; i++) {
//			for(String check : checkList){
//				System.out.println("CHECKED ID-------->" + check);
//				if(check.equals(String.valueOf(idList[i]))) {
////					int checkId = Integer.parseInt(check);
//					BuyItemDTO dto = new BuyItemDTO();
//					dto.setId(idList[i].toString());
//					dto.setItemTransactionId(idList[i].toString());
//					dto.setItemName(itemNameList[i].toString());
//					dto.setItemPrice(itemPriceList[i].toString());
//					dto.setItemStock(itemStockList[i].toString());
//					dto.setCount(countList[i].toString());
//
//					int totalCount=Integer.parseInt(countList[i].toString());
//					int price=Integer.parseInt(itemPriceList[i].toString());
//					int total=price * totalCount;
//					dto.setTotalPrice(String.valueOf(total));
//					dto.setTotalCount(String.valueOf(countList[i].toString()));
//					dto.setUserMasterId(userMasterId);
//					dto.setPay(pay);
//
//					System.out.println("---カート情報["+(i)+"]---");
//					System.out.println("ID               :"+dto.getId());
//					System.out.println("ITEMTRANSACTIONID:"+dto.getItemTransactionId());
//					System.out.println("ITEMNAME         :"+dto.getItemName());
//					System.out.println("ITEMPRICE        :"+dto.getItemPrice());
//					System.out.println("ITEMSTOCK        :"+dto.getItemStock());
//					System.out.println("COUNT            :"+dto.getCount());
//					System.out.println("TOTALPRICE       :"+dto.getTotalPrice());
//					System.out.println("TOTALCOUNT       :"+dto.getTotalCount());
//					System.out.println("USERMASTERID     :"+dto.getUserMasterId());
//					System.out.println("PAY              :"+dto.getPay());
//					System.out.println("------------------");
//
//					buyItemDTOList.add(dto);
//				}
//			}
//		}
//				result=SUCCESS;
//				return result;
//	}
//public String getId() {
//return id;
//}
//
//public void setId(String id) {
//this.id = id;
//}
//
//
//
//public String getErrorMessage() {
//return errorMessage;
//}
//
//public void setErrorMessage(String errorMessage) {
//this.errorMessage = errorMessage;
//}
//
//
//
//public Collection<String> getCheckList() {
//return checkList;
//}
//
//public void setCheckList(Collection<String> checkList) {
//this.checkList = checkList;
//}
//
//public String getItemTransactionId() {
//return itemTransactionId;
//}
//
//public void setItemTransactionId(String itemTransactionId) {
//this.itemTransactionId = itemTransactionId;
//}
//
//public String getItemName() {
//return itemName;
//}
//
//public void setItemName(String itemName) {
//this.itemName = itemName;
//}
//
//public String getItemPrice() {
//return itemPrice;
//}
//
//public void setItemPrice(String itemPrice) {
//this.itemPrice = itemPrice;
//}
//
//public String getTotalCount() {
//return totalCount;
//}
//
//public void setTotalCount(String totalCount) {
//this.totalCount = totalCount;
//}
//
//public String getTotalPrice() {
//return totalPrice;
//}
//
//public void setTotalPrice(String totalPrice) {
//this.totalPrice = totalPrice;
//}
//
//public String getItemStock() {
//return itemStock;
//}
//
//public void setItemStock(String itemStock) {
//this.itemStock = itemStock;
//}
//
//public String getCount() {
//return count;
//}
//
//public void setCount(String count) {
//this.count = count;
//}
//
//public String getLoginUserId() {
//return loginUserId;
//}
//
//public void setLoginUserId(String loginUserId) {
//this.loginUserId = loginUserId;
//}
//
//public String getUserMasterId() {
//return userMasterId;
//}
//
//public void setUserMasterId(String userMasterId) {
//this.userMasterId = userMasterId;
//}
//
//public String getPay() {
//return pay;
//}
//
//public void setPay(String pay) {
//this.pay = pay;
//}
//
//public Map<String, Object> getSession() {
//return session;
//}
//
//public void setSession(Map<String, Object> session) {
//this.session = session;
//}
//
//public List<BuyItemDTO> getBuyItemDTOList() {
//return buyItemDTOList;
//}
//
//public void setBuyItemDTOList(List<BuyItemDTO> buyItemDTOList) {
//this.buyItemDTOList = buyItemDTOList;
//}
//}


//import com.opensymphony.xwork2.ActionSupport;
//import org.apache.struts2.interceptor.SessionAware;
//import com.internousdev.ecsite.dao.BuyItemCompleteDAO;
//
//import java.sql.SQLException;
//import java.util.Map;
//
//public class BuyItemConfirmAction extends ActionSupport implements SessionAware{
//
//		private Map<String,Object>	session;
//		private BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();
//
//		public String execute() throws SQLException{
//			int count = buyItemCompleteDAO.buyItemInfo(
//								session.get("id").toString(),
//								session.get("total_price").toString(),
//								session.get("count").toString(),
//								session.get("login_user_id").toString(),
//								session.get("pay").toString());
//				if (count > 0) {
//					buyItemCompleteDAO.changeItemStock(Integer.parseInt(session.get("count").toString()), session.get("id").toString());
//				}
//
//				String result = SUCCESS;
//				return result;
//		}
//		public Map<String,Object> getSession(){
//			return this.session;
//		}
//		@Override
//		public void setSession(Map<String,Object> session){
//			this.session=session;
//		}
//}