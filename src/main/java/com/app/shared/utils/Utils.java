package com.app.shared.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class Utils {
	
	private final Random RANDUM=new SecureRandom();
	private final String ALPHBET="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//	private final int ITERATIONS=10000;
//	private final int KEYLENGTH=256;
//	
	public String genrateUserId(int length) {
		
		return generateRandomString(length);
	}
	
	public String generateRandomString(int length) {
		
		StringBuilder returnValue=new StringBuilder(length);
		for(int i=0;i<length;i++) {
			returnValue.append(ALPHBET.charAt(RANDUM.nextInt(ALPHBET.length())));
			
		}
		
		return new String();
	}

}
