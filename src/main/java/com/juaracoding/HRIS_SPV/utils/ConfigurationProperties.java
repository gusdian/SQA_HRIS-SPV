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
	
	@Value("${filter1}")
	private String filter1;
	
	@Value("${name}")
	private String name;
	
	@Value("${startDate}")
	private String startDate;
	
	@Value("${endDate}")
	private String endDate;
	
	@Value("${weight1}")
	private String weight1;
	
	@Value("${weight2}")
	private String weight2;
	
	@Value("${param1}")
	private String param1;
	
	@Value("${tar1}")
	private String tar1;
	
	@Value("${filter2}")
	private String filter2;
	
	@Value("${param2}")
	private String param2;
	
	@Value("${tar1}")
	private String tar2;
	
	@Value("${TxtSuccessApprove}")
	private String TxtSuccessApprove;
	
	@Value("${filter3}")
	private String filter3;
	
	@Value("${txtPenilaianPage}")
	private String txtPenilaianPage;
	
	@Value("${filter4}")
	private String filter4;
	
	@Value("${txtPA360Page}")
	private String txtPA360Page;
		
	
	//----------------------Declaration Getter-----------------------------------

	public String getBrowser() {
		return browser;
	}

	public String getFilter1() {
		return filter1;
	}

	public void setFilter1(String filter1) {
		this.filter1 = filter1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getWeight1() {
		return weight1;
	}

	public void setWeight1(String weight1) {
		this.weight1 = weight1;
	}

	public String getWeight2() {
		return weight2;
	}

	public void setWeight2(String weight2) {
		this.weight2 = weight2;
	}

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getTar1() {
		return tar1;
	}

	public void setTar1(String tar1) {
		this.tar1 = tar1;
	}

	public String getFilter2() {
		return filter2;
	}

	public void setFilter2(String filter2) {
		this.filter2 = filter2;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

	public String getTar2() {
		return tar2;
	}

	public void setTar2(String tar2) {
		this.tar2 = tar2;
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

	public String getFilter3() {
		return filter3;
	}

	public void setFilter3(String filter3) {
		this.filter3 = filter3;
	}

	public String getTxtPenilaianPage() {
		return txtPenilaianPage;
	}
	
	public String getFilter4() {
		return filter4;
	}

	public void setFilter4(String filter4) {
		this.filter4 = filter4;
	}
	
	public String getTxtPA360Page() {
		return txtPA360Page;
	}
	
}

