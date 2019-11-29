package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ResetPasswordDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction2 extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String newLoginUserPassword;
	private String reNewLoginUserPassword;
	private int minLength=4;//ここで最小値
	private int maxLength=12;//ここで最大値
	private Map<String, Object> session;

	ResetPasswordDAO resetPasswordDAO=new ResetPasswordDAO();

	//一応エラーメッセージのリストは別ける
	//本当は一括で管理した方が個人的には好き
	private List<String> passwordErrorMessageList = new ArrayList<String>();
	private List<String> userIdErrorMessageList = new ArrayList<String>();
	private List<String> inputErrorMessageList = new ArrayList<String>();
	private List<String> newPasswordErrorMessageList = new ArrayList<String>();
	private List<String> reConfirmationNewPasswordErrorMessageList = new ArrayList<String>();

	private List<String> characterTypeList = new ArrayList<String>();


	public String execute() {
		//valueにデフォルトで入っている数値はどうやら認識してくれないので
		//If文でいれる
		if(session.get("login_user_id") !=null ){
			loginUserId=(String) session.get("login_user_id");
		}


		String result = ERROR;


////////////////////////////////////////ユーザーIDのフォームの定義////////////////////////////////////////
		//条件リスト
		boolean availableAlphabeticCharacters=true;
		boolean availableKanji=false;
		boolean availableHiragana=false;
		boolean availableHalfWidthDigit=true;
		boolean availableKatakana=false;
		boolean availableHalfWidthSpace=false;


		//現在IDが未入力
		if(session.get("login_user_id") ==null && loginUserId.isEmpty()){
			userIdErrorMessageList.add("ユーザーIDが入力されていません。");
			userIdErrorMessageList.add("変更したいユーザーIDを入力してください。");
			userIdErrorMessageList.add("<br>");
		}
		//入力欄が最小文字数以上、最大文字数以下かどうかを検証します
		if(!inputErrorMessageList.isEmpty()&&!loginUserId.isEmpty()&&(loginUserId.length() < minLength || loginUserId.length() > maxLength)){
			userIdErrorMessageList.add("ユーザーID" + "は" + minLength + "文字以上" + maxLength + "文字以下で入力してください。");
			userIdErrorMessageList.add("<br>");
		}
		///////////入力された文字のタイプから何を判別するか決めます//////////
		String regularExpression = "";

		if(availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit || availableKatakana || availableHalfWidthSpace){
			regularExpression = "[";
		}

		if(availableAlphabeticCharacters){
			regularExpression +="a-zA-Z";
			characterTypeList.add("半角英字");
		}

		if(availableKanji){
			regularExpression +="一-龠々";
			characterTypeList.add("漢字");
		}

		if(availableHiragana){
			regularExpression +="ぁ-んー";
			characterTypeList.add("ひらがな");
		}

		if(availableHalfWidthDigit){
			regularExpression +="0-9-";
			characterTypeList.add("半角数字");
		}

		if(availableKatakana){
			regularExpression +="ァ-ヺ";
			characterTypeList.add("カタカナ");
		}

		if(availableHalfWidthSpace){
			regularExpression +=" 　";
			characterTypeList.add("スペース");
		}

		if(!StringUtils.isEmpty(regularExpression)){
			regularExpression +="]+";
		}
		////////////////////////////ここまで///////////////////////////
		//判別した項目に応じてエラーメッセージを返します
		String characterType = "";
		for(int i = 0;i < characterTypeList.size();i++){
			if(i == 0){
				characterType += characterTypeList.get(i).toString();
			}else{
				characterType += "、" + characterTypeList.get(i).toString();
			}
		}

		if(!loginUserId.matches(regularExpression)&&!loginUserId.equals("")){
			userIdErrorMessageList.add("ユーザーID" + "は" + characterType + "で入力してください。");
			userIdErrorMessageList.add("<br>");
		}

////////////////////////////////////////パスワードのフォームの定義////////////////////////////////////////
		//現在パスワードが未入力
		if(loginPassword.isEmpty()){
			passwordErrorMessageList.add("パスワードが入力されていません。");
			passwordErrorMessageList.add("変更したいユーザーIDの現在のパスワードを入力してください。");
			passwordErrorMessageList.add("<br>");
		}
////////////////////////////////////////インプットの定義////////////////////////////////////////
		// DBのユーザー情報テーブルに正しくそのユーザーが存在するかチェック
		//パスワードも同時にチェック
		//両方が正しく認識しない場合は下記の警告文を表示
		if(((session.get("login_user_id") ==null && !loginUserId.isEmpty()) || !loginPassword.isEmpty()) && !resetPasswordDAO.referenceUserInfo(loginUserId, loginPassword)) {
			inputErrorMessageList.add("ユーザーIDまたは現在のパスワードが異なります。");
			inputErrorMessageList.add("<br>");
		}
////////////////////////////////////////新しいパスワード入力チェック////////////////////////////////////////
		//新しいパスワードが未入力
		if(newLoginUserPassword.isEmpty()){
			newPasswordErrorMessageList.add("新しいパスワードが入力されていません。");
			newPasswordErrorMessageList.add("変更したいユーザーIDの新しいパスワードを入力してください。");
			newPasswordErrorMessageList.add("<br>");
		}
		//新しいパスワードが現在パスワードと同じ
		if(!newLoginUserPassword.isEmpty() && (newLoginUserPassword.equals(loginPassword))){
			newPasswordErrorMessageList.add("入力された新しいパスワードが現在パスワードと同じワードです。");
			newPasswordErrorMessageList.add("新しいパスワードは現在パスワードとは違うワードを入力してください。");
			newPasswordErrorMessageList.add("<br>");
		}
		//入力欄が最小文字数以上、最大文字数以下かどうかを検証します
		if(!inputErrorMessageList.isEmpty()&&!newLoginUserPassword.isEmpty()&&(newLoginUserPassword.length() < minLength || newLoginUserPassword.length() > maxLength)){
			newPasswordErrorMessageList.add("新しいパスワード" + "は" + minLength + "文字以上" + maxLength + "文字以下で入力してください。");
			newPasswordErrorMessageList.add("<br>");
		}
		//新しいパスワードの入力されたタイプの判別した項目に応じてエラーメッセージを返します
		if(!newLoginUserPassword.matches(regularExpression)&&!newLoginUserPassword.equals("")){
			newPasswordErrorMessageList.add("新しいパスワード" + "は" + characterType + "で入力してください。");
			newPasswordErrorMessageList.add("<br>");
		}
////////////////////////////////////////再度入力された新しいパスワード入力チェック////////////////////////////////////////
		//新しいパスワードと再度入力パスワードが違う
		if(!newLoginUserPassword.equals(reNewLoginUserPassword)){
			reConfirmationNewPasswordErrorMessageList.add("新しいパスワードと新しいパスワード(再確認)が一致しません。");
			reConfirmationNewPasswordErrorMessageList.add("<br>");
		}
////////////////////////////////////////全てSUCCESS////////////////////////////////////////
if((!loginUserId.isEmpty()&&!loginPassword.isEmpty()&&!newLoginUserPassword.isEmpty()&&!reNewLoginUserPassword.isEmpty())
	&&	(resetPasswordDAO.referenceUserInfo(loginUserId, loginPassword) && newLoginUserPassword.equals(reNewLoginUserPassword))
	&& (!newLoginUserPassword.equals(loginPassword))){
	session.put("chengedLoginUserPassword", newLoginUserPassword);
	session.put("userIdForResetPassword", loginUserId);
	result = SUCCESS;
}
////////////////////////////////////////ここからデバッグ////////////////////////////////////////
		System.out.println("【チェック開始！】");
		System.out.println("――――――――――――――――――――――――");
		System.out.println("|");
		System.out.println("|");
		System.out.println("|・" + "入力されたID:" + loginUserId);
		System.out.println("|・" + "入力された現在パスワード:" + loginPassword);
		System.out.println("|・" + "入力された新しいパスワード:" + newLoginUserPassword);
		System.out.println("|・" + "入力された確認パスワード:" + reNewLoginUserPassword);
		System.out.println("|・" + "リザルト判定:" + result);
		System.out.println("|");
		System.out.println("|");
		System.out.println("――――――――――――――――――――――――");
		System.out.println("【チェックヨシ！】");
		return result;


		/**  言い訳
		 * エラーメッセージは個別のアクションを作ってそっちで一括管理させた方が良い
		 * ただし、今回はそれに気付くのが遅れ、Actionクラスのそれぞれにエラーメッセージが散らばっているので
		 * 今回はそれぞれのアクションで管理させる事とする
		 */
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getNewLoginUserPassword() {
		return newLoginUserPassword;
	}

	public void setNewLoginUserPassword(String newLoginUserPassword) {
		this.newLoginUserPassword = newLoginUserPassword;
	}

	public String getReNewLoginUserPassword() {
		return reNewLoginUserPassword;
	}

	public void setReNewLoginUserPassword(String reNewLoginUserPassword) {
		this.reNewLoginUserPassword = reNewLoginUserPassword;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}
	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public List<String> getUserIdErrorMessageList() {
		return userIdErrorMessageList;
	}
	public void setUserIdErrorMessageList(List<String> userIdErrorMessageList) {
		this.userIdErrorMessageList = userIdErrorMessageList;
	}

	public List<String> getInputErrorMessageList() {
		return inputErrorMessageList;
	}
	public void setInputErrorMessageList(List<String> inputErrorMessageList) {
		this.inputErrorMessageList = inputErrorMessageList;
	}

	public List<String> getNewPasswordErrorMessageList() {
		return newPasswordErrorMessageList;
	}

	public void setNewPasswordErrorMessageList(List<String> newPasswordErrorMessageList) {
		this.newPasswordErrorMessageList = newPasswordErrorMessageList;
	}

	public List<String> getReConfirmationNewPasswordErrorMessageList() {
		return reConfirmationNewPasswordErrorMessageList;
	}

	public void setReConfirmationNewPasswordErrorMessageList(List<String> reConfirmationNewPasswordErrorMessageList) {
		this.reConfirmationNewPasswordErrorMessageList = reConfirmationNewPasswordErrorMessageList;
	}


	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
