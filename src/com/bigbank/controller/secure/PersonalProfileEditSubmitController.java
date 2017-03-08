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
		forward(processProfileSubmit(request, response), request, response);
	}
	
	private String processProfileSubmit(HttpServletRequest request, HttpServletResponse response) {
		if(!SessionUtil.isCSRFTokenValid(request, "<PersonalProfileEditSubmit>: ")) return "/secure/csrfInvalid";
		
		HttpSession session = request.getSession();
		PersonalProfileVO ppEdtVO = getEditedVO(request);
		session.setAttribute(SessionUtil.ATTRIB_EDITED_PERSONAL_PROFILE, ppEdtVO);		
		
		if (!ppEdtVO.isValid()) {			
			Logger.log("PersonalProfileEditSubmitController: PP EditVO is not valid, back to edit");
			return "/secure/jsp/personalProfileEdit.jsp";
		} else {
			String config = ConfigController.getConfig(ConfigController.VERYFY_CHANGES_ENABLED);
			if ((config != null) && "yes".equalsIgnoreCase(config)) {
				SessionUtil.setCSRFToken(session);
				return "/secure/jsp/personalProfileVerify.jsp";
			} else {
				return "/secure/personalProfileUpdate";
			}
		}
	}
	
	private PersonalProfileVO getEditedVO(HttpServletRequest request) {
		Address address = new Address();		
		address.setStreet(request.getParameter("street"));
		address.setCity(request.getParameter("city"));
		address.setState(request.getParameter("state"));
		address.setZipCode(request.getParameter("zipCode"));

		PersonalProfileVO ppEdtVO = new PersonalProfileVO();
		ppEdtVO.setAddress(address);
		ppEdtVO.setPhoneNbr(request.getParameter("phoneNbr"));
		ppEdtVO.setEmailAddres(request.getParameter("emailAddress"));
		
		Logger.log("<PersonalProfileEditSubmitController> New Profile :\n" + ppEdtVO);

		return ppEdtVO;
	}
}
