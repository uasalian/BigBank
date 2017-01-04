package com.bigbank.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

}
