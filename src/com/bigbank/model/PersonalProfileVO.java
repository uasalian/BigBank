package com.bigbank.model;

public class PersonalProfileVO {
	private Address address;
	private String phoneNbr, emailAddres;
	
	public static final String REGEX_PHONE_NBR = "[1-9]\\d{2}-[1-9]\\d{2}-[1-9]\\d{3}";
	public static final String REGEX_EMAIL_ADD = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-za-z0-9]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public String getPhoneNbr() {
		return phoneNbr;
	}

	public void setPhoneNbr(String phoneNbr) {
		this.phoneNbr = phoneNbr;
	}
	
	public boolean isPhoneNbrValid() {
		return (phoneNbr != null) && phoneNbr.matches(REGEX_PHONE_NBR);
	}

	public Address getAddress() {
		return address;
	}

	public String getEmailAddres() {
		return emailAddres;
	}
	
	public void setEmailAddres(String emailAddres) {
		this.emailAddres = emailAddres;
	}
	
	public boolean isEmailAddressValid() {
		return (emailAddres != null) && emailAddres.matches(REGEX_EMAIL_ADD);
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public boolean isAddressValid() {
		return (address != null) && address.isValid();
	}
	
	public boolean isValid() {
		return isAddressValid() && isPhoneNbrValid() && isEmailAddressValid();
	}
	
	public String toString() {
		return  "  Address   : " + address 
			+ "\n  Phone Nbr : " + phoneNbr
			+ "\n  Email Add : " + emailAddres;
	}

	public static void main(String[] args) {
		PersonalProfileVO pp = new PersonalProfileVO();
		//validateEmail(pp);
		validatePhone(pp);
	}
	
	public static void validateEmail(PersonalProfileVO pp) {
		String emails[] = {
				"abc@yahoo.com",
				"abc.yahoo.com",
				"abcyahoo.com",
				"abc@yahoo.c",
				"abc@yahoo.c08",
				"abc", "", null
		};
		for (int i = 0; i<emails.length; i++) {
			pp.setEmailAddres(emails[i]);
			System.out.println(pp.getEmailAddres() + " is valid Email? " + pp.isEmailAddressValid());
		}
	}
	
	public static void validatePhone(PersonalProfileVO pp) {
		String phones[] = {
			"800-900-1000",
			"80-900-1000",
			"8009001000",
			"080-900-1000",
			"abc-900-1000",
			"aa", "", null
		};
		for (int i=0; i<phones.length; i++) {
			pp.setPhoneNbr(phones[i]);
			System.out.println(pp.getPhoneNbr() + " is valid phone? " + pp.isPhoneNbrValid());
		}
	}
}
