package com.internousdev.ecsite.action;


import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDetailsDAO;
import com.internousdev.ecsite.dto.AccountPageDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserDetailsAction extends ActionSupport implements SessionAware {
	private String loginId;
	private AccountPageDTO accountPageDTO = new AccountPageDTO();
	private Map<String, Object> session;

	public String execute() throws SQLException {
		UserDetailsDAO userDetailsDAO = new UserDetailsDAO();
		accountPageDTO = userDetailsDAO.getMyAccountUserInfo(loginId);
		if(accountPageDTO.getLoginId() == null) {
			accountPageDTO = null;
		}

		String result = SUCCESS;
		return result;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public AccountPageDTO getAccountPageDTO() {
		return accountPageDTO;
	}
	public void setAccountPageDTO(AccountPageDTO accountPageDTO) {
		this.accountPageDTO = accountPageDTO;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object> getSession() {
		return session;
	}
}
