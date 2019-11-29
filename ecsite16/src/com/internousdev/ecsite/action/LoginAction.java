package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;


//他のアクションと同じ
public class LoginAction extends ActionSupport implements SessionAware{


	//変数・インスタンスを作成
		private String loginUserId;
		private String loginPassword;
		private Map<String,Object> session;
		private LoginDAO loginDAO = new LoginDAO();
		private LoginDTO loginDTO = new LoginDTO();
		private BuyItemDAO buyItemDAO = new BuyItemDAO();


		//execute汎用処理
		public String execute()throws SQLException{
			//特に例外がなければERROR判定
				String result = ERROR;

				//DTOにDAOで取得したIDとPASSをいれる
				loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
				//セッションにput
				session.put("loginUser", loginDTO);

				//ログインするアカウントが管理者権限を持っていた場合
				//管理画面のTOP画面に飛ばす
				if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
					if((((LoginDTO) session.get("loginUser")).getAdminFlg() != null)
							&& (((LoginDTO) session.get("loginUser")).getAdminFlg().equals("1"))) {
						session.put("login_user_id", loginDTO.getLoginId());
						session.put("login_user_password", loginDTO.getLoginPassword());
						result = "adminPage";

						//そうでないなら普通にSUCCESS
						//通常のログイン後画面へ
					}else{
					result = SUCCESS;

					//購入履歴などをここで処理
					List<BuyItemDTO> buyItemDTOList = buyItemDAO.getBuyItemInfo();

					session.put("login_user_id", loginDTO.getLoginId());
					session.put("login_user_password", loginDTO.getLoginPassword());
					session.put("buyItemDTOList", buyItemDTOList);
				}
				}
				//デバッグ用メッセージログ
				System.out.println((((LoginDTO) session.get("loginUser")).getAdminFlg() != null));
				return result;
		}
		//ゲッターセッターオーバーライド
		public String getLoginUserId(){
			return loginUserId;
		}
		public void setLoginUserId(String loginUserId){
			this.loginUserId=loginUserId;
		}
		public String getLoginPassword(){
			return loginPassword;
		}
		public void setLoginPassword(String loginPassword){
			this.loginPassword=loginPassword;
		}
		public Map<String,Object> getSession(){
			return this.session;
		}
		@Override
		public void setSession(Map<String,Object> session){
			this.session=session;
		}

}
