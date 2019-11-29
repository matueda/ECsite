package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import com.internousdev.ecsite.dao.MyPageDAO;
import com.internousdev.ecsite.dto.MyPageDTO;

//他のアクションと同じ
public class MyPageAction extends ActionSupport implements SessionAware{

	//変数・インスタンスを作成
	private Map<String,Object> session;
	private MyPageDAO myPageDAO = new MyPageDAO();
	private ArrayList<MyPageDTO> myPageList=new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;
//	private String itemTransactionId;
//	private String userMasterId;

	//execute汎用処理
	public String execute() throws SQLException{

		//アイテムIDをString配列にセッションから持ってきたものをスプリットで分割していれる
//		String[] itemTransactionId=session.get("itemTransactionId").toString().split(", ", 0);
//		String item_transaction_id=session.get("itemTransactionId").toString();
//		System.out.println(Arrays.toString(itemTransactionId));
//		String[] itemTransactionIdList=itemTransactionId.split(", ", 0);
//		String[] userMasterIdList=userMasterId.split(",",0);
//		System.out.println(itemTransactionIdList);
//		System.out.println(userMasterIdList);
//		for(int i=0; i<1; i++) {
//			String id = loginUserIdList[checkList[i]];
//
//			MyPageDTO mydto=new MyPageDTO();
//			mydto.setId(id);
//			myPageList.add(mydto);
//		}

		//セッションにログインIDがない場合はエラー
		if(!session.containsKey("login_user_id")){
			return ERROR;
		}

		//ユーザーの購入履歴の削除処理のフラグ
		//履歴があれば削除処理へ、なければエラー表示
		if(deleteFlg==null){
//			String item_transaction_id = session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();
			myPageList=myPageDAO.getMyPageUserInfo(user_master_id);
		}else if(deleteFlg.equals("1")){
			delete();
		}
		String result = SUCCESS;
		return result;
	}

	//デリートメソッド、例外はいつもの
	public void delete() throws SQLException{
//		String item_transaction_id=session.get("id").toString();
		String user_master_id=session.get("login_user_id").toString();

		int res = myPageDAO.buyItemHistoryDelete(user_master_id);

		//int resを判断基準にデリートの削除可否メッセージ分岐
		if(res > 0){
				myPageList=null;
				setMessage("商品情報を正しく削除しました。");
		} else if(res == 0){
				setMessage("商品情報の削除に失敗しました。");
		}
	}
//	public int[] getCheckList() {
//		return checkList;
//	}
//
//	public void setCheckList(int[] checkList) {
//		this.checkList = checkList;
//	}
//	public String getLoginUserId() {
//		return loginUserId;
//	}
//
//	public void setLoginUserId(String loginUserId) {
//		this.loginUserId = loginUserId;
//	}


//ゲッターセッターオーバーライド
	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg=deleteFlg;
	}
	public ArrayList<MyPageDTO>getMyPageList(){
		return this.myPageList;
	}
	public String getMessage(){
		return this.message;
	}
	public void setMessage(String message){
		this.message = message;
	}
	public Map<String,Object> getsession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session=session;
	}
}
