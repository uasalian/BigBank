package com.bigbank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigbank.util.AuthUtil;
import com.bigbank.util.Logger;


@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LogoutController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger.log("In LogoutController...");
		AuthUtil.setLoggedOut(request, response);
		response.sendRedirect(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
