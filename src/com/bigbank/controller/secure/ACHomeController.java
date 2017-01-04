package com.bigbank.controller.secure;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigbank.controller.BasicController;

@WebServlet("/secure/achome")
public class ACHomeController extends BasicController {
	private static final long serialVersionUID = 1L;
       
    public ACHomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		forward("/secure/jsp/achome.jsp", request, response);
	}
}
