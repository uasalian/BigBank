package com.bigbank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigbank.util.AuthUtil;
import com.bigbank.util.Logger;

@WebServlet("/authenticate")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String UID_REGEX = "user[0-9]";
	private static final String PWD_REGEX = "pass[0-9]";
	
    public AuthController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		
		Logger.log("<AuthController>: Authenticating: uid [" + userName + "] pwd [" + passWord + "]");
		
		String contextPah = request.getContextPath();
		
		String nextURL = contextPah;
		if(validCredentials(userName, passWord)) {
			Logger.log("<AuthController>: Authenticated, set logged in state" );
			AuthUtil.setLoggedIn(userName, request, response);
			nextURL += "/secure/achome";
		}
		
		response.sendRedirect(nextURL);
	}
	
	private boolean validCredentials(String uid, String pwd) {
		return ((uid != null) && uid.matches(UID_REGEX)
			&&  (pwd != null) && pwd.matches(PWD_REGEX));
	}
}
