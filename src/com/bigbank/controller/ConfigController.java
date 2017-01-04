package com.bigbank.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/setConfig")
public class ConfigController extends BasicController {
	private static final long serialVersionUID = 1L;
	
	public static final String OUTPUT_ENCODING_ENABLED = "outputEncodingEnabled";
	public static final String VERYFY_CHANGES_ENABLED  = "verifyChangesEnabled";
	public static final String SET_CSRF_TOKEN_ENABLED = "setCSRFTokenEnabled";
	public static final String CSRF_TOKEN_VERIFY_ENABLED = "csrfTokenVerifyEnabled";
	public static final String X_FRAME_OPTIONS_ENABLED = "xFrameOptionsEnabled";
       
	private static HashMap<String, String> configMap = new HashMap<String, String>();
	
    public ConfigController() {
        super();
    }
    
    public static String getConfig(String s) {
    	return configMap.get(s);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String radioEncodeVal = request.getParameter("radio_encode");
		configMap.put(OUTPUT_ENCODING_ENABLED, radioEncodeVal);
		
		String radioVerifyVal = request.getParameter("radio_verify");
		configMap.put(VERYFY_CHANGES_ENABLED, radioVerifyVal);
		
		String radioSetCSRFTokenVal = request.getParameter("radio_set_csrf_token");
		configMap.put(SET_CSRF_TOKEN_ENABLED, radioSetCSRFTokenVal);
		
		String radioCSRFTokenVerifyEnabled = request.getParameter("radio_csrf_token_verify");
		configMap.put(CSRF_TOKEN_VERIFY_ENABLED, radioCSRFTokenVerifyEnabled);
		
		String radioXFrameOptionsEnabled = request.getParameter("radio_x_frame_options");
		configMap.put(X_FRAME_OPTIONS_ENABLED, radioXFrameOptionsEnabled);
		
		forward("/config.jsp", request, response);
	}
	
	public static boolean isEnabled(String config) {
		String s = configMap.get(config);
		return (s != null) && "yes".equalsIgnoreCase(s);
	}
	
}
