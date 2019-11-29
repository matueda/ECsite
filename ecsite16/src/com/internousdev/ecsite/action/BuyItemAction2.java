package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class BuyItemAction2 extends ActionSupport implements SessionAware{


	//変数・インスタンスを作成
		private String ids;
//		private String itemTransactionId;
		private String itemNames;
		private String itemPrices;
//		private String totalCount;
		private int totalPrice;
		private String itemStocks;
		private int[] checkList;

		private String counts;
//		private String loginUserId;
		private List<String> errorMessageList = new ArrayList<String>();
//		private String userMasterId;

		private String pay;
		private Map<String,Object> session;

		private List<BuyItemDTO> buyItemDTOList=new ArrayList<BuyItemDTO>();
//		private BuyItemDAO buyItemDAO = new BuyItemDAO();

		//メソッド宣言定義
		public String execute()throws SQLException{
			String result = ERROR;

			//ストリング配列にスプリットで分割して格納する
			String[] idList=ids.split(", ", 0);
			String[] countList=counts.split(", ", 0);
			String[] itemPriceList=itemPrices.split(", ", 0);
			String[] itemStockList=itemStocks.split(", ", 0);
			String[] itemNameList=itemNames.split(", ", 0);

			//もし商品にチェックを一つもいれずに購入した場合
			//下記のエラー表記を出してページに留めさせる
			if(checkList == null){
				errorMessageList.add("おっと！何も選択していないようだよ。");
				errorMessageList.add("商品をチェックしてから押してね！");
				BuyItemDAO dao = new BuyItemDAO();
				buyItemDTOList = dao.getBuyItemInfo();

				return ERROR;
			}
			//チェックした商品の数だけfor文で回して
			//上で作ったストリング配列のリストに入っているものを
			//入れてputとsetをする。
			//ここで合計金額なども計算する。
			for(int i=0; i<checkList.length; i++) {
				String id = idList[checkList[i]];
				String count = countList[checkList[i]];
				String itemStock = itemStockList[checkList[i]];
				String itemPrice = itemPriceList[checkList[i]];
				String itemName = itemNameList[checkList[i]];
				int Count=Integer.parseInt(countList[checkList[i]].toString());
				int price=Integer.parseInt(itemPriceList[checkList[i]].toString());
				int subtotal=price * Count;
				totalPrice += subtotal;


				int stock = Integer.parseInt(itemStockList[checkList[i]]);
//				System.out.println(itemNameList[checkList[w]]);
//				System.out.println(checkList.length);
//				System.out.println(errorMessage);


				//ここで購入個数が在庫数を上回った時は
				//在庫が足りないというメッセージを出すために
				//該当する商品の名前を取得してエラーメッセージのリストに格納する。
				if(Count > stock){
					errorMessageList.add("おっと！ごめんね！");
					errorMessageList.add("["+itemNameList[checkList[i]]+"]"+"の在庫がないみたいだ！");


//				System.out.println(Arrays.toString(ErrorMessageList));
//				Arrays.toString(ErrorMessageList);
				}

				//ここでBuyItemDTOクラスを「acquisitionData」という変数名でインスタンス生成(化?)
				BuyItemDTO acquisitionData=new BuyItemDTO();
				acquisitionData.setId(id);
				acquisitionData.setCount(count);
				acquisitionData.setItemStock(itemStock);
				acquisitionData.setItemName(itemName);
				acquisitionData.setItemPrice(itemPrice);
				acquisitionData.setSubtotal(subtotal);
				//上のインスタンス化したものに情報をsetした後
				//BuyItemDTOListクラスにaddする。
				buyItemDTOList.add(acquisitionData);

				// 必要な情報をsessionにputする。
				session.put("id", id);
				session.put("total_price", totalPrice);
				session.put("count", count);
				session.put("checkList", checkList);
				session.put("itemTransactionId", ids);
				session.put("subtotal", subtotal);
				session.put("price", price);
				session.put("idList", idList);
				session.put("countList", countList);
				session.put("itemStockList", itemStockList);
				session.put("itemPriceList", itemPriceList);
				session.put("itemNameList", itemNameList);

				//デバッグ用メッセージログ
System.out.println("ID:" + id);
System.out.println("COUNT:" + count);
System.out.println("ITEMSTOCK:" + itemStock);
System.out.println("ITEMPRICE:" + itemPrice);
System.out.println("ITEMNAME:" + itemName);
System.out.println("PRICE       :"+price);
System.out.println("SUBTOTAL       :"+subtotal);
System.out.println("TOTALPRICE       :"+ totalPrice);
			}
			//もし上の処理の何れかでエラーが発生した場合(エラーメッセージリストがempty(空)でない場合)
			//エラーメッセージをリストから取り出して表示させ、そのページに留めさせる。
			if(!errorMessageList.isEmpty()){
				return ERROR;
			}
			//支払いを現金かクレジットカードを判断して
			//sessionにputする。
			String payment;
			if(pay.equals("1")) {
				payment = "現金";
				session.put("pay", payment);
			} else {
				payment = "クレジットカード";
				session.put("pay", payment);
			}
//			session.put("totalPrice", acquisitionData.setTotalPrice(String.valueOf(total)));
			result=SUCCESS;
					return result;
		}
		//ゲッターセッターの記述
		public String getIds() {
			return ids;
		}

		public void setIds(String ids) {
			this.ids = ids;
		}

		public List<String> getErrorMessageList() {
			return errorMessageList;
		}
		public void setErrorMessageList(List<String> errorMessageList) {
			this.errorMessageList = errorMessageList;
		}
		public int[] getCheckList() {
			return checkList;
		}

		public void setCheckList(int[] checkList) {
			this.checkList = checkList;
		}
//		public String getItemTransactionId() {
//			return itemTransactionId;
//		}
//
//		public void setItemTransactionId(String itemTransactionId) {
//			this.itemTransactionId = itemTransactionId;
//		}
		public String getItemNames() {
			return itemNames;
		}

		public void setItemNames(String itemNames) {
			this.itemNames = itemNames;
		}

		public String getItemPrices() {
			return itemPrices;
		}

		public void setItemPrices(String itemPrices) {
			this.itemPrices = itemPrices;
		}
//
//		public String getTotalCount() {
//			return totalCount;
//		}
//
//		public void setTotalCount(String totalCount) {
//			this.totalCount = totalCount;
//		}
//
		public int getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(int totalPrice) {
			this.totalPrice = totalPrice;
		}
//
		public String getItemStocks() {
			return itemStocks;
		}

		public void setItemStocks(String itemStocks) {
			this.itemStocks = itemStocks;
		}
//
		public String getCounts() {
			return counts;
		}

		public void setCounts(String counts) {
			this.counts = counts;
		}
//
//		public String getLoginUserId() {
//			return loginUserId;
//		}
//
//		public void setLoginUserId(String loginUserId) {
//			this.loginUserId = loginUserId;
//		}
//		public String getUserMasterId() {
//			return userMasterId;
//		}
//
//		public void setUserMasterId(String userMasterId) {
//			this.userMasterId = userMasterId;
//		}
		public String getPay() {
			return pay;
		}

		public void setPay(String pay) {
			this.pay = pay;
		}

		public Map<String, Object> getSession() {
			return session;
		}

		//オーバーライド
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

