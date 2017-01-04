package com.bigbank.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbank.model.AccountSummaryVO;

public class AuthUtil {
	
	
	public static AccountSummaryVO getAccountSummary(String userName) {
		AccountSummaryVO vo = new AccountSummaryVO();
		vo.setName("BigBankUser");
		vo.setBalance(5215.68f);
		vo.setReqwardsBalance(601.25f);

		return vo;
	}
	
	public static void setLoggedIn(String userName, HttpServletRequest request, HttpServletResponse response) {
		String sessionId = SessionUtil.SESSIONID_PREFIX + java.util.UUID.randomUUID().toString();

		HttpSession session = request.getSession();
		session.setAttribute(SessionUtil.ATTRIB_SESSION_COOKIE, sessionId);		
		session.setAttribute(SessionUtil.ATTRIB_ACCT_SUMMARY, getAccountSummary(userName));
		
		Cookie cookie = new Cookie(SessionUtil.ATTRIB_SESSION_COOKIE, sessionId);
		response.addCookie(cookie);
	}

	public static void setLoggedOut(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		Cookie cookie = new Cookie(SessionUtil.ATTRIB_SESSION_COOKIE, "LoggedOff");
		response.addCookie(cookie);
	}
	

}
