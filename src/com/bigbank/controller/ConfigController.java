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
	public static final String ADD_CSRF_TOKEN_ENABLED = "addCSRFTokenEnabled";
	public static final String SET_CSRF_TOKEN_ENABLED = "setCSRFTokenEnabled";
	public static final String VERIFY_CSRF_TOKEN_ENABLED = "verifyCSRFTokenEnabled";
	public static final String X_FRAME_OPTIONS_ENABLED = "xFrameOptionsEnabled";
	public static final String COOKIE_HTTPONLY_ENABLED = "cookieHttpOnlyEnabled";
	public static final String COOKIE_SECURE_ENABLED = "cookieSecureEnabled";
       
	private static HashMap<String, String> configMap = new HashMap<String, String>();
	
    public ConfigController() {
        super();
    }
    
    static {
        configMap.put(VERYFY_CHANGES_ENABLED, "yes");  // verify profile change by default
    }
    
    public static String getConfig(String s) {
    	return configMap.get(s);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String radioEncodeVal = request.getParameter("radio_encode");
		configMap.put(OUTPUT_ENCODING_ENABLED, radioEncodeVal);
		
		String radioVerifyVal = request.getParameter("radio_verify");
		configMap.put(VERYFY_CHANGES_ENABLED, radioVerifyVal);
		
		String radioAddCSRFTokenVal = request.getParameter("radio_add_csrf_token");
		configMap.put(ADD_CSRF_TOKEN_ENABLED, radioAddCSRFTokenVal);
		
		String radioSetCSRFTokenVal = request.getParameter("radio_set_csrf_token");
		configMap.put(SET_CSRF_TOKEN_ENABLED, radioSetCSRFTokenVal);
		
		String radioVerifyCSRFTokenEnabled = request.getParameter("radio_verify_csrf_token");
		configMap.put(VERIFY_CSRF_TOKEN_ENABLED, radioVerifyCSRFTokenEnabled);
		
		String radioXFrameOptionsEnabled = request.getParameter("radio_x_frame_options");
		configMap.put(X_FRAME_OPTIONS_ENABLED, radioXFrameOptionsEnabled);
		
		String radioCookieHttpOnlyEnabled = request.getParameter("radio_cookie_httpOnly");
		configMap.put(COOKIE_HTTPONLY_ENABLED, radioCookieHttpOnlyEnabled);
		
		String radioCookieSecureEnabled = request.getParameter("radio_cookie_secure");
		configMap.put(COOKIE_SECURE_ENABLED, radioCookieSecureEnabled);
		
		forward("/config.jsp", request, response);
	}
	
	public static boolean isEnabled(String config) {
		String s = configMap.get(config);
		return (s != null) && "yes".equalsIgnoreCase(s);
	}
	
}
