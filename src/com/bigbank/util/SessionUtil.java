package com.bigbank.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bigbank.controller.ConfigController;

public class SessionUtil {

	public static final String ATTRIB_SESSION_COOKIE = "bbSessionId";
	public static final String ATTRIB_ACCT_SUMMARY = "acctSummary";
	public static final String ATTRIB_PERSONAL_PROFILE = "personalProfile";
	public static final String ATTRIB_EDITED_PERSONAL_PROFILE = "editedPersonalProfile";
	public static final String ATTRIB_CSRF_TOKEN = "csrfToken";
		
	public static final String SESSIONID_PREFIX = "auth_";

	public static void setSessionInRequest(HttpServletRequest request) {
		request.setAttribute("authenticated", "true");
		HttpSession session = request.getSession();
		request.setAttribute(ATTRIB_ACCT_SUMMARY, session.getAttribute(ATTRIB_ACCT_SUMMARY));
	}
	
	public static void setCSRFToken(HttpSession session) {
		if (ConfigController.isEnabled(ConfigController.SET_CSRF_TOKEN_ENABLED)) {
			String csrfToken = UUID.randomUUID().toString();
			session.setAttribute(SessionUtil.ATTRIB_CSRF_TOKEN, csrfToken);
		}
	}
	
	public static boolean isCSRFTokenValid(HttpServletRequest request, String methodName) {
		if(ConfigController.isEnabled(ConfigController.VERIFY_CSRF_TOKEN_ENABLED)) {
			HttpSession session = request.getSession();
			Object obj = session.getAttribute(SessionUtil.ATTRIB_CSRF_TOKEN);
			String tokenInSession = (obj == null) ? null : obj.toString();
			String tokenFromForm = request.getParameter("csrfToken");
			
			if ((tokenInSession != null) && tokenInSession.equals(tokenFromForm)) {
				Logger.log(methodName + "CSRF token verified ...");
				session.removeAttribute(SessionUtil.ATTRIB_CSRF_TOKEN); // remove used token
				return true;
			} else {
				Logger.log(methodName + "CSRF token verification failed: In Session [" +
					tokenInSession + "] from form [" + tokenFromForm + "]");
				session.removeAttribute(SessionUtil.ATTRIB_EDITED_PERSONAL_PROFILE);
				return false;
			}
		}
		
		return true;
	}
	
}
