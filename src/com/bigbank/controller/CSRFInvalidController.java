package com.bigbank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigbank.util.AuthUtil;
import com.bigbank.util.Logger;


@WebServlet("/secure/csrfInvalid")
public class CSRFInvalidController extends BasicController {
	private static final long serialVersionUID = 1L;
       
    public CSRFInvalidController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger.log("In CSRFInvalidController...");
		//AuthUtil.setLoggedOut(request, response);  
		forward("/invalidCSRF.jsp", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
