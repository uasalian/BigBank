package com.bigbank.util;

import java.util.Date;

public class Logger {
	
	public static void log(String s) {
		System.out.println(new Date().toString().substring(0, 20) + s);
	}
	
	public static void main(String[] args) {
		log("Testing");
	}
	
}
