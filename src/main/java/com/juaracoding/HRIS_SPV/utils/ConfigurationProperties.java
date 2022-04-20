package com.juaracoding.HRIS_SPV.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {
	
	@Value("${browser}")
	private String browser;
	
	@Value("${emailku}")
	private String emailku;
	
	@Value("${passwordd}")
	private String passwordd;
	
	@Value("${txtInvalidLogin}")
	private String txtInvalidLogin;
	
	@Value("${email}")
	private String email;
	
	@Value("${password}")
	private String password;
	
	@Value("${txtWelcome}")
	private String txtWelcome;

	public String getBrowser() {
		return browser;
	}

	public String getEmailku() {
		return emailku;
	}

	public String getPasswordd() {
		return passwordd;
	}

	public String getTxtInvalidLogin() {
		return txtInvalidLogin;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getTxtWelcome() {
		return txtWelcome;
	}

	


	
}

