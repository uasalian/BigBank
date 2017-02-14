package com.bigbank.controller.secure;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbank.controller.BasicController;
import com.bigbank.util.SessionUtil;

@WebServlet("/secure/personalProfileDiscard")
public class PersonalProfileDiscardController extends BasicController {
	private static final long serialVersionUID = 1L;
	
    public PersonalProfileDiscardController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute(SessionUtil.ATTRIB_EDITED_PERSONAL_PROFILE);		
		forward("/secure/personalProfile", request, response);		
	}   
}
