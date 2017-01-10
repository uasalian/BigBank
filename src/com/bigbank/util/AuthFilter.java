package com.bigbank.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if (isLoggedIn(req)) {
			Logger.log("<AuthFilter>: session cookie found, forwarding...");
			chain.doFilter(request, response);				
		} else {
			Logger.log("<AuthFilter>: session cookie NOT found, login please...");
			resp.sendRedirect(req.getContextPath());
		}		
	}
	
	private boolean isLoggedIn(HttpServletRequest req) {
		try {			
			Cookie cookies[] = req.getCookies();
			if (cookies == null || cookies.length == 0) return false;

			for (int i=0; i < cookies.length; i++) {
				Cookie aCookie = cookies[i];
				if (aCookie.getName().equals(SessionUtil.ATTRIB_SESSION_COOKIE)
						&& aCookie.getValue().startsWith(SessionUtil.SESSIONID_PREFIX)) {
					SessionUtil.setSessionInRequest(req);
					return true;
				}
			}
		} catch (Exception e) {
			Logger.log("<AuthFilter>: Error in AuthFilter:" + e.getMessage());
		}

		return false;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
