package com.bigbank.util;

import org.owasp.encoder.Encode;

import com.bigbank.controller.ConfigController;

public class MyEncoder {
	
	public static String encode(String s) {
		String config = ConfigController.getConfig(ConfigController.OUTPUT_ENCODING_ENABLED);
		return ((config != null) && "yes".equalsIgnoreCase(config)) ? Encode.forHtml(s) : s;
	}

}
