package com.app.ws.security;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


public class AppProperties {

	private Environment env;
	
	public String getTokenSecret() {
		
		return env.getProperty("tokenSecret");
	}
	
	
	
}
