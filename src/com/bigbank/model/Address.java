package com.bigbank.model;

import com.bigbank.util.Logger;

public class Address {

	public static final String REGEX_STREET = "[1-9]\\d{0,4}\\s[a-zA-Z]([a-zA-Z]*|\\.|\\s)+";
	public static final String REGEX_CITY = "[a-zA-Z]+(\\.|\\s)*[a-zA-Z]+";
	public static final String STATES = "IL,IN,WI,MI,FL,NY,TX";
	public static final String REGEX_ZIP = "[1-9]\\d{4}";

	private String street, city, state, zipCode;

	public String getStreet() {
		return street;
	}
	public void setStreet(String s) {
		this.street = s;
	}
	public boolean isStreetValid() {
		return validateWithRegEx(street, REGEX_STREET);
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isCityValid() {
		return validateWithRegEx(city, REGEX_CITY);
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isStateValid() {
		return (state != null) && (state.length()==2) && STATES.contains(state.toUpperCase());
	}
	
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public boolean isZipCodeValid() {
		return validateWithRegEx(zipCode, REGEX_ZIP);
	}
	
	public boolean isValid(){
		return isStreetValid() && isCityValid() && isStateValid() && isZipCodeValid();
	}
	
	public String toString() {
		return street + "," + city + " " + state + " " + zipCode;
	}
	
	public static boolean validateWithRegEx(String s, String regEx) {
		return (s!=null) && s.matches(regEx);
	}

	public static void main(String[] args) {
		Address add = new Address();
		//validateStreet(add);
		//validateCity(add);
		//validateState(add);
		validateZip(add);
	}
	public static void validateStreet(Address add) {
		String streets[] = {
				"1 Lane", "10 Lane", "01 Lane", "15389 Lane", "100", "Park Rd",
				"10 Park way", "10 Park Ln.", "125 W. Swim Ln.", "125 W Swim Ln",
				"10Park way", "123456 Lane", "125 25 Swim Ln.", "125 Swim 25 Ln.",
				"", "a", null
		};
		for (int i = 0; i<streets.length; i++) {
			add.setStreet(streets[i]);
			Logger.log(add.getStreet() + " is street? " + add.isStreetValid());
		}
	}
	public static void validateCity(Address add) {
		String cities[] = {"DeerField", "Buffalo Grove", "St. Loius", 
				"9City", "Ac1ty", " City", ".City", "City.", "a", "10a", "", null};
		for (int i = 0; i<cities.length; i++) {
			add.setCity(cities[i]);
			System.out.println(add.getCity() + " is city? " + add.isCityValid());
		}
	}
	public static void validateState(Address add) {
		String states[] = {"IL", "il", "iln", "I", "Il3", "13", "", null };
		for (int i=0; i<states.length; i++) {
			add.setState(states[i]);
			System.out.println(add.getState() + " is state? " + add.isStateValid() );
		}
		
	}
	public static void validateZip(Address add) {
		String[] zips = {"01234", "12345", "10345", "10340", "1234",
				"1234 ", "123456", "12e45", "aa", "", null};
		for (int i = 0; i<zips.length; i++) {
			add.setZipCode(zips[i]);
			System.out.println(add.getZipCode() + " is zip? " + add.isZipCodeValid());
		}
	}	
}
