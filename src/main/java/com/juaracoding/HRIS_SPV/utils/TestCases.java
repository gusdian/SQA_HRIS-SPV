package com.juaracoding.HRIS_SPV.utils;

public enum TestCases {

	T1("Testing Login Upliner Valid"),
	T2("Testing Login Upliner Invalid"),
	T3("Testing SPV Approval Target");
	
	private String testName;
	
	TestCases(String value) {
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
