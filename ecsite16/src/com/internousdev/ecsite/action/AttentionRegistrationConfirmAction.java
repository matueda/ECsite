package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.AttentionRegistrationDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AttentionRegistrationConfirmAction extends ActionSupport implements SessionAware{

		private String loginUserId;
		private String familyName;
		private String firstName;
		private String familyNameKana;
		private String firstNameKana;
		private String streetAddress;
		private String callNumber;
		private int minLength=0;//ここで最小値
		private int maxLength=11;//ここで最大値
		private Map<String, Object> session;

		private int kazu = 0;
		//エラーメッセージ用表記String
		String myouji = "名字";
		String namae ="名前";
		String hurigana ="ふりがな";
		String denwabangou ="電話番号";

		AttentionRegistrationDAO attentionRegistrationDAO=new AttentionRegistrationDAO();

		//エラーメッセージリスト管理
		private List<String> userIdErrorMessageList = new ArrayList<String>();
		private List<String> inputErrorMessageList = new ArrayList<String>();
		private List<String> familyNameErrorMessageList = new ArrayList<String>();
		private List<String> firstNameErrorMessageList = new ArrayList<String>();
		private List<String> streetAddressErrorMessageList = new ArrayList<String>();
		private List<String> callNumberErrorMessageList = new ArrayList<String>();

		//判断
		private List<String> characterTypeList = new ArrayList<String>();
		private List<String> characterTypeList2 = new ArrayList<String>();
		private List<String> characterTypeList3 = new ArrayList<String>();
		private List<String> characterTypeList4 = new ArrayList<String>();

		public String execute() {

			String result = ERROR;

			//条件リスト
			//////////////////////ユーザーID用////////////////////
			boolean availableAlphabeticCharacters=true;
			boolean availableKanji=false;
			boolean availableHiragana=false;
			boolean availableHalfWidthDigit=true;
			boolean availableKatakana=false;
			boolean availableHalfWidthSpace=false;
			//////////////////////姓名用チェック////////////////////
			boolean availableAlphabeticCharacters2=false;
			boolean availableKanji2=true;
			boolean availableHiragana2=true;
			boolean availableHalfWidthDigit2=false;
			boolean availableKatakana2=true;
			boolean availableHalfWidthSpace2=false;
			//////////////////////姓名(ふりがな)用チェック////////////////////
			boolean availableAlphabeticCharacters3=false;
			boolean availableKanji3=false;
			boolean availableHiragana3=true;
			boolean availableHalfWidthDigit3=false;
			boolean availableKatakana3=false;
			boolean availableHalfWidthSpace3=false;
			//////////////////////電話番号用チェック////////////////////
			boolean availableAlphabeticCharacters4=false;
			boolean availableKanji4=false;
			boolean availableHiragana4=false;
			boolean availableHalfWidthDigit4=true;
			boolean availableKatakana4=false;
			boolean availableHalfWidthSpace4=false;
	///////////入力された文字のタイプから何を判別するか決めます//////////
			String regularExpression = "";
			String regularExpression2 = "";
			String regularExpression3 = "";
			String regularExpression4 = "";

			if((availableAlphabeticCharacters || availableKanji || availableHiragana || availableHalfWidthDigit || availableKatakana || availableHalfWidthSpace)||(availableAlphabeticCharacters2 || availableKanji2 || availableHiragana2 || availableHalfWidthDigit2 || availableKatakana2 || availableHalfWidthSpace2)||(availableAlphabeticCharacters3 || availableKanji3 || availableHiragana3 || availableHalfWidthDigit3 || availableKatakana3 || availableHalfWidthSpace3)||(availableAlphabeticCharacters4 || availableKanji4 || availableHiragana4 || availableHalfWidthDigit4 || availableKatakana4 || availableHalfWidthSpace4)){
				regularExpression = "[";
				regularExpression2 = "[";
				regularExpression3 = "[";
				regularExpression4 = "[";
			}

			if(availableAlphabeticCharacters){
				regularExpression +="a-zA-Z";
				characterTypeList.add("半角英字");
			}
			if(availableAlphabeticCharacters2){
				regularExpression2 +="a-zA-Z";
				characterTypeList2.add("半角英字");
			}
			if(availableAlphabeticCharacters3){
				regularExpression3 +="a-zA-Z";
				characterTypeList3.add("半角英字");
			}
			if(availableAlphabeticCharacters4){
				regularExpression4 +="a-zA-Z";
				characterTypeList4.add("半角英字");
			}

			if(availableKanji){
				regularExpression +="一-龠々";
				characterTypeList.add("漢字");
			}
			if(availableKanji2){
				regularExpression2 +="一-龠々";
				characterTypeList2.add("漢字");
			}
			if(availableKanji3){
				regularExpression3 +="一-龠々";
				characterTypeList3.add("漢字");
			}
			if(availableKanji4){
				regularExpression4 +="一-龠々";
				characterTypeList4.add("漢字");
			}

			if(availableHiragana){
				regularExpression +="ぁ-んー";
				characterTypeList.add("ひらがな");
			}
			if(availableHiragana2){
				regularExpression2 +="ぁ-んー";
				characterTypeList2.add("ひらがな");
			}
			if(availableHiragana3){
				regularExpression3 +="ぁ-んー";
				characterTypeList3.add("ひらがな");
			}
			if(availableHiragana4){
				regularExpression4 +="ぁ-んー";
				characterTypeList4.add("ひらがな");
			}

			if(availableHalfWidthDigit){
				regularExpression +="0-9-";
				characterTypeList.add("半角数字");
			}
			if(availableHalfWidthDigit2){
				regularExpression2 +="0-9-";
				characterTypeList2.add("半角数字");
			}
			if(availableHalfWidthDigit3){
				regularExpression3 +="0-9-";
				characterTypeList3.add("半角数字");
			}
			if(availableHalfWidthDigit4){
				regularExpression4 +="0-9-";
				characterTypeList4.add("半角数字");
			}

			if(availableKatakana){
				regularExpression +="ァ-ヺ";
				characterTypeList.add("カタカナ");
			}
			if(availableKatakana2){
				regularExpression2 +="ァ-ヺ";
				characterTypeList2.add("カタカナ");
			}
			if(availableKatakana3){
				regularExpression3 +="ァ-ヺ";
				characterTypeList3.add("カタカナ");
			}
			if(availableKatakana4){
				regularExpression4 +="ァ-ヺ";
				characterTypeList4.add("カタカナ");
			}

			if(availableHalfWidthSpace){
				regularExpression +=" 　";
				characterTypeList.add("スペース");
			}
			if(availableHalfWidthSpace2){
				regularExpression2 +=" 　";
				characterTypeList2.add("スペース");
			}
			if(availableHalfWidthSpace3){
				regularExpression3 +=" 　";
				characterTypeList3.add("スペース");
			}
			if(availableHalfWidthSpace4){
				regularExpression4 +=" 　";
				characterTypeList4.add("スペース");
			}
			if(!StringUtils.isEmpty(regularExpression)){
				regularExpression +="]+";
			}
			if(!StringUtils.isEmpty(regularExpression2)){
				regularExpression2 +="]+";
			}
			if(!StringUtils.isEmpty(regularExpression3)){
				regularExpression3 +="]+";
			}
			if(!StringUtils.isEmpty(regularExpression4)){
				regularExpression4 +="]+";
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
			String characterType2 = "";
			for(int i = 0;i < characterTypeList2.size();i++){
				if(i == 0){
					characterType2 += characterTypeList2.get(i).toString();
				}else{
					characterType2 += "、" + characterTypeList2.get(i).toString();
				}
			}
			String characterType3 = "";
			for(int i = 0;i < characterTypeList3.size();i++){
				if(i == 0){
					characterType3 += characterTypeList3.get(i).toString();
				}else{
					characterType3 += "、" + characterTypeList3.get(i).toString();
				}
			}
			String characterType4 = "";
			for(int i = 0;i < characterTypeList4.size();i++){
				if(i == 0){
					characterType4 += characterTypeList4.get(i).toString();
				}else{
					characterType4 += "、" + characterTypeList4.get(i).toString();
				}
			}
			if(!loginUserId.matches(regularExpression)&&!loginUserId.equals("")){
				userIdErrorMessageList.add("ユーザーID" + "は" + characterType + "で入力してください。");
				userIdErrorMessageList.add("<br>");
			}
			if(!familyName.matches(regularExpression2)&&!familyName.equals("")){
				familyNameErrorMessageList.add(myouji + "は" + characterType2 + "で入力してください。");
				familyNameErrorMessageList.add("<br>");
			}
			if(!firstName.matches(regularExpression2)&&!firstName.equals("")){
				firstNameErrorMessageList.add(namae + "は" + characterType2 + "で入力してください。");
				firstNameErrorMessageList.add("<br>");
			}
			if(!familyNameKana.matches(regularExpression3)&&!familyNameKana.equals("")){
				familyNameErrorMessageList.add(hurigana + "は" + characterType3 + "で入力してください。");
				familyNameErrorMessageList.add("<br>");
			}
			if(!firstNameKana.matches(regularExpression3)&&!firstNameKana.equals("")){
				firstNameErrorMessageList.add(hurigana + "は" + characterType3 + "で入力してください。");
				firstNameErrorMessageList.add("<br>");
			}
			if(!callNumber.matches(regularExpression4)&&!callNumber.equals("")){
				callNumberErrorMessageList.add(denwabangou + "は" + characterType4 + "で入力してください。");
				callNumberErrorMessageList.add("<br>");
			}
////////////////////////////////////////インプットの定義////////////////////////////////////////
			// DBのユーザー情報テーブルに正しくそのユーザーが存在するかチェック
			//パスワードも同時にチェック
			//両方が正しく認識しない場合は下記の警告文を表示
			if((!loginUserId.isEmpty()) && !attentionRegistrationDAO.referenceUserInfo(loginUserId)) {
				inputErrorMessageList.add("該当するユーザーIDが存在しません。");
				inputErrorMessageList.add("<br>");
			}
////////////////////////////////////////ユーザーIDのフォームの定義////////////////////////////////////////
			//現在IDが未入力
			if(session.get("login_user_id") ==null && loginUserId.isEmpty()){
				userIdErrorMessageList.add("ユーザーIDが入力されていません。");
				userIdErrorMessageList.add("変更したいユーザーIDを入力してください。");
				userIdErrorMessageList.add("<br>");
			}
////////////////////////////////////////名字のフォームの定義////////////////////////////////////////
			//名字が未入力
			if(familyName.isEmpty()){
				familyNameErrorMessageList.add("名字が入力されていません。");
				familyNameErrorMessageList.add("登録したい名字を入力してください。");
				familyNameErrorMessageList.add("<br>");
			}
////////////////////////////////////////名字(ふりがな)のフォームの定義////////////////////////////////////////
			//ふりがなが未入力
			if(familyNameKana.isEmpty()){
				familyNameErrorMessageList.add("名字(ふりがな)が入力されていません。");
				familyNameErrorMessageList.add("登録したい名字(ふりがな)を入力してください。");
				familyNameErrorMessageList.add("<br>");
			}
////////////////////////////////////////名前のフォームの定義////////////////////////////////////////
			//名前が未入力
			if(firstName.isEmpty()){
				firstNameErrorMessageList.add("名前が入力されていません。");
				firstNameErrorMessageList.add("登録したい名前を入力してください。");
				firstNameErrorMessageList.add("<br>");
			}
////////////////////////////////////////名前(ふりがな)のフォームの定義////////////////////////////////////////
			//ふりがなが未入力
			if(firstNameKana.isEmpty()){
				familyNameErrorMessageList.add("名前(ふりがな)が入力されていません。");
				familyNameErrorMessageList.add("登録したい名前(ふりがな)を入力してください。");
				familyNameErrorMessageList.add("<br>");
			}
////////////////////////////////////////住所のフォームの定義////////////////////////////////////////
			//住所が未入力
			if(streetAddress.isEmpty()){
				streetAddressErrorMessageList.add("住所が入力されていません。");
				streetAddressErrorMessageList.add("登録したい住所を入力してください。");
				streetAddressErrorMessageList.add("<br>");
			}
////////////////////////////////////////電話番号のフォームの定義////////////////////////////////////////
			//電話番号が未入力
			if(callNumber.isEmpty()){
				callNumberErrorMessageList.add("電話番号が入力されていません。");
				callNumberErrorMessageList.add("登録したい電話番号を入力してください。");
				callNumberErrorMessageList.add("<br>");
			}
			//入力欄が最小文字数以上、最大文字数以下かどうかを検証します
			if(!callNumber.isEmpty()&&(callNumber.length() < minLength || callNumber.length() > maxLength)){
				callNumberErrorMessageList.add(denwabangou + "は" + maxLength + "文字"+"以下で入力してください。");
				callNumberErrorMessageList.add("<br>");
			}

			if((!loginUserId.isEmpty()&&!familyName.isEmpty()&&!familyNameKana.isEmpty()&&!familyNameKana.isEmpty()&&!firstName.isEmpty()&&!firstNameKana.isEmpty()&&!streetAddress.isEmpty()&&!callNumber.isEmpty())
				&& (inputErrorMessageList.size() == 0 && userIdErrorMessageList.size() == 0 && familyNameErrorMessageList.size() == 0 && firstNameErrorMessageList.size() == 0 && firstNameErrorMessageList.size() == 0 && callNumberErrorMessageList.size() == 0)
				&& attentionRegistrationDAO.referenceUserInfo(loginUserId)
					){
				session.put("attentionloginUserId", loginUserId);
				session.put("inputFamilyName", familyName);
				session.put("inputFamilyNameKana", familyNameKana);
				session.put("inputFirstName", firstName);
				session.put("inputFirstNameKana", firstNameKana);
				session.put("inputStreetAddress", streetAddress);
				session.put("inputCallNumber", callNumber);

				System.out.println("|・" + "attentionloginUserId:" + session.get("attentionloginUserId").toString());
				System.out.println("|・" + "FamilyName:" + session.get("inputFamilyName").toString());
				System.out.println("|・" + "inputFamilyNameKana:" + session.get("inputFamilyNameKana").toString());
				System.out.println("|・" + "inputFirstName:" + session.get("inputFirstName").toString());
				System.out.println("|・" + "inputFirstNameKana:" + session.get("inputFirstNameKana").toString());
				System.out.println("|・" + "inputStreetAddress:" + session.get("inputStreetAddress").toString());
				System.out.println("|・" + "inputCallNumber:" + session.get("inputCallNumber").toString());
				result = SUCCESS;
			}
////////////////////////////////////////ここからデバッグ////////////////////////////////////////
			kazu +=1;
System.out.println("【チェック開始！】");
System.out.println("――――――――――――――――――――――――");
System.out.println("|");
System.out.println("|");
System.out.println("|・" + "入力されたID:" + loginUserId);
System.out.println("|・" + "入力された名字:" + familyName);
System.out.println("|・" + "入力されたふりがな:" + familyNameKana);
System.out.println("|・" + "入力された名前:" + firstName);
System.out.println("|・" + "入力されたふりがな:" + familyNameKana);
System.out.println("|・" + "入力された住所:" + streetAddress);
System.out.println("|・" + "入力された電話番号:" + callNumber);
System.out.println("|・" + "リザルト判定:" + result);
System.out.println("|・" + "回転数:" + kazu);
System.out.println("|");
System.out.println("|");
System.out.println("――――――――――――――――――――――――");
System.out.println("【チェックヨシ！】");
return result;
		}

		public String getLoginUserId() {
			return loginUserId;
		}

		public void setLoginUserId(String loginUserId) {
			this.loginUserId = loginUserId;
		}
		public String getFamilyName() {
			return familyName;
		}
		public void setFamilyName(String familyName) {
			this.familyName = familyName;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getFamilyNameKana() {
			return familyNameKana;
		}
		public void setFamilyNameKana(String familyNameKana) {
			this.familyNameKana = familyNameKana;
		}
		public String getFirstNameKana() {
			return firstNameKana;
		}
		public void setFirstNameKana(String firstNameKana) {
			this.firstNameKana = firstNameKana;
		}
		public String getStreetAddress() {
			return streetAddress;
		}
		public void setStreetAddress(String streetAddress) {
			this.streetAddress = streetAddress;
		}
		public String getCallNumber() {
			return callNumber;
		}
		public void setCallNumber(String callNumber) {
			this.callNumber = callNumber;
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
		public List<String> getFamilyNameErrorMessageList() {
			return familyNameErrorMessageList;
		}

		public void setFamilyNameErrorMessageList(List<String> familyNameErrorMessageList) {
			this.familyNameErrorMessageList = familyNameErrorMessageList;
		}

		public List<String> getFirstNameErrorMessageList() {
			return firstNameErrorMessageList;
		}

		public void setFirstNameErrorMessageList(List<String> firstNameErrorMessageList) {
			this.firstNameErrorMessageList = firstNameErrorMessageList;
		}
		public List<String> getStreetAddressErrorMessageList() {
			return streetAddressErrorMessageList;
		}

		public void setStreetAddressErrorMessageList(List<String> streetAddressErrorMessageList) {
			this.streetAddressErrorMessageList = streetAddressErrorMessageList;
		}
		public List<String> getCallNumberErrorMessageList() {
			return callNumberErrorMessageList;
		}

		public void setCallNumberErrorMessageList(List<String> callNumberErrorMessageList) {
			this.callNumberErrorMessageList = callNumberErrorMessageList;
		}



		public Map<String, Object> getSession() {
			return session;
		}

		public void setSession(Map<String, Object> session) {
			this.session = session;
		}
	}
