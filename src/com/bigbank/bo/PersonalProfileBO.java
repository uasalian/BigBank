package com.bigbank.bo;

import com.bigbank.model.Address;
import com.bigbank.model.PersonalProfileVO;

public class PersonalProfileBO {
	
	private static PersonalProfileVO ppVO = null;
	
	static {
		Address address = new Address();
		address.setStreet("25 Residency Ln.");
		address.setCity("Small City");
		address.setState("IL");
		address.setZipCode("54321");

		ppVO = new PersonalProfileVO();
		ppVO.setAddress(address);
		ppVO.setEmailAddres("bbUser@wohoo.com");
		ppVO.setPhoneNbr("800-900-1000");
	}
	
	public static PersonalProfileVO getPersonalProfile(String userName) {
		return ppVO;
	}
	
	public static void setPersonalProfile(PersonalProfileVO vo) throws InvalidInputException {
		if (vo.isValid()) ppVO = vo;
		else throw new InvalidInputException("Invalid Input");
	}
}
