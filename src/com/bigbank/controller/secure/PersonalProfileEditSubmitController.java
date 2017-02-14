package com.bigbank.controller.secure;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigbank.controller.BasicController;
import com.bigbank.controller.ConfigController;
import com.bigbank.model.Address;
import com.bigbank.model.PersonalProfileVO;
import com.bigbank.util.Logger;
import com.bigbank.util.SessionUtil;

@WebServlet("/secure/personalProfileEditSubmit")
public class PersonalProfileEditSubmitController extends BasicController {
	private static final long serialVersionUID = 1L;
	
    public PersonalProfileEditSubmitController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(!SessionUtil.isCSRFTokenValid(request)) forward("/secure/achome", request, response);
		
		Address address = new Address();		
		address.setStreet(request.getParameter("street"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setZipCode(request.getParameter("zipCode"));

		PersonalProfileVO ppEdtVO = new PersonalProfileVO();
		ppEdtVO.setAddress(address);
		ppEdtVO.setPhoneNbr(request.getParameter("phoneNbr"));
		ppEdtVO.setEmailAddres(request.getParameter("emailAddress"));
		
		session.setAttribute(SessionUtil.ATTRIB_EDITED_PERSONAL_PROFILE, ppEdtVO);
		
		Logger.log("<PersonalProfileEditSubmitController> New Profile :\n" + ppEdtVO);

		if (!ppEdtVO.isValid()) {			
			Logger.log("PersonalProfileEditSubmitController: PP EditVO is not valid, back to edit");
			forward("/secure/jsp/personalProfileEdit.jsp", request, response);
		} else {
			String config = ConfigController.getConfig(ConfigController.VERYFY_CHANGES_ENABLED);
			if ((config != null) && "yes".equalsIgnoreCase(config)) {
				SessionUtil.setCSRFToken(session);
				forward("/secure/jsp/personalProfileVerify.jsp", request, response);
			} else {
				forward("/secure/personalProfileUpdate", request, response);
			}
		}
	}
}
