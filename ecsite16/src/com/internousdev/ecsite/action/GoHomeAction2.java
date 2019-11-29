package com.internousdev.ecsite.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

//メインクラス定義
public class GoHomeAction2 extends ActionSupport implements SessionAware{
		private Map<String,Object> session;

		//無条件でSUCCESS
		public String execute(){
				return SUCCESS;
		}

		//ゲット&オーバーライド
		public Map<String,Object> getSession(){
			return this.session;
		}
		@Override
		public void setSession(Map<String,Object> session){
			this.session=session;
		}

}
