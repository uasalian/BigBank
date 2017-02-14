package com.bigbank.controller.secure;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbank.bo.PersonalProfileBO;
import com.bigbank.controller.BasicController;
import com.bigbank.model.PersonalProfileVO;
import com.bigbank.util.SessionUtil;


@WebServlet("/secure/personalProfileEdit")
public class PersonalProfileEditController extends BasicController {
	private static final long serialVersionUID = 1L;
       

    public PersonalProfileEditController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		PersonalProfileVO ppVO = null;
		Object obj = session.getAttribute(SessionUtil.ATTRIB_EDITED_PERSONAL_PROFILE);
		
		if (obj != null) ppVO = (PersonalProfileVO) obj;
		else {
			ppVO = PersonalProfileBO.getPersonalProfile("userName");
			session.setAttribute(SessionUtil.ATTRIB_EDITED_PERSONAL_PROFILE, ppVO);
		}
	
		SessionUtil.setCSRFToken(session);
		
		forward("/secure/jsp/personalProfileEdit.jsp", request, response);
	}
	
}
