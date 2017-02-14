package com.bigbank.controller.secure;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigbank.controller.BasicController;
import com.bigbank.util.SessionUtil;

@WebServlet("/secure/personalProfileVerifySubmit")
public class PersonalProfileVerifySubmitController2 extends BasicController {
	private static final long serialVersionUID = 1L;
	
    public PersonalProfileVerifySubmitController2() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!SessionUtil.isCSRFTokenValid(request)) forward("/secure/achome", request, response);
		
		forward("/secure/personalProfileUpdate", request, response);
		
	}
}
