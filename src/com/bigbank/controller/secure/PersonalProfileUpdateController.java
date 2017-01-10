package com.bigbank.controller.secure;

import java.io.IOException;
import com.bigbank.util.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbank.bo.PersonalProfileBO;
import com.bigbank.controller.BasicController;
import com.bigbank.model.PersonalProfileVO;
import com.bigbank.util.SessionUtil;

@WebServlet("/secure/personalProfileUpdate")
public class PersonalProfileUpdateController extends BasicController {
	private static final long serialVersionUID = 1L;
	
    public PersonalProfileUpdateController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute(SessionUtil.ATTRIB_EDITED_PERSONAL_PROFILE);

		if (obj == null) {
			Logger.log("PersonalProfileUpdateController:  Object in session is null");
			forward("/secure/jsp/techDiff.jsp", request, response);
		}
		
		PersonalProfileVO ppEdtVO = (PersonalProfileVO) obj;
				
		PersonalProfileBO.setPersonalProfile(ppEdtVO);
		session.setAttribute(SessionUtil.ATTRIB_PERSONAL_PROFILE, ppEdtVO);
		forward("/secure/personalProfile", request, response);		
	}   
}
