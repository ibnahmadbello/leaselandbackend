package com.arab.leaseland.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Converter {
	
	public static String hashTheInput(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			byte[] messageDigest = md.digest(input.getBytes());
			
			// COnvert byte to signum
			BigInteger no = new BigInteger(1, messageDigest);
			
			String hashtext = no.toString(16);
			
			//Add preceding 0s to make it 32bits
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			
			// return the Hashtext
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}		
	}
	
}
