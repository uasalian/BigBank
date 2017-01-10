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

@WebServlet("/secure/personalProfileVerify")
public class PersonalProfileVerifyController extends BasicController {
	private static final long serialVersionUID = 1L;
	
    public PersonalProfileVerifyController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if(ConfigController.isEnabled(ConfigController.CSRF_TOKEN_VERIFY_ENABLED)) {
			Object obj = session.getAttribute(SessionUtil.ATTRIB_CSRF_TOKEN);
			String tokenInSession = (obj == null) ? null : obj.toString();
			String tokenFromForm = request.getParameter("csrfToken");
			
			if ((tokenInSession != null) && tokenInSession.equals(tokenFromForm)) {
				Logger.log("<PersonalProfileVerifyController>: CSRF token verified ...");
				session.setAttribute(SessionUtil.ATTRIB_CSRF_TOKEN, null); // remove used token
			} else {
				Logger.log("<PersonalProfileVerifyController>: CSRF token verification failed: In Session [" +
					tokenInSession + "] from form [" + tokenFromForm + "]");
				session.setAttribute(SessionUtil.ATTRIB_EDITED_PERSONAL_PROFILE, null);
				forward("/secure/achome", request, response);
			}
		}
		
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
		
		Logger.log("<PersonalProfileVerifyController> New Profile :\n" + ppEdtVO);

		if (!ppEdtVO.isValid()) {			
			Logger.log("PersonalProfileVerifyController: PP EditVO is not valid, back to edit");
			forward("/secure/jsp/personalProfileEdit.jsp", request, response);
		} else {
			String config = ConfigController.getConfig(ConfigController.VERYFY_CHANGES_ENABLED);
			if ((config != null) && "yes".equalsIgnoreCase(config)) {
				forward("/secure/jsp/personalProfileVerify.jsp", request, response);
			} else {
				forward("/secure/personalProfileUpdate", request, response);
			}
		}
	}
}
