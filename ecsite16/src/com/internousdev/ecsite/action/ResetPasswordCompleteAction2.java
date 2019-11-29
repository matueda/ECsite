package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ResetPasswordDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction2 extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;
		ResetPasswordDAO resetPasswordDAO = new ResetPasswordDAO();
		int count = resetPasswordDAO.resetPassword(session.get("userIdForResetPassword").toString(), session.get("chengedLoginUserPassword").toString());

		if (count > 0) {
			result = SUCCESS;
		}
		session.remove("userIdForResetPassword");
		session.remove("newPassword");

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
