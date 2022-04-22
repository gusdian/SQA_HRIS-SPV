package com.juaracoding.HRIS_SPV.utils;

public enum TestCases {

	T1("Testing Login Upliner Valid"),
	T2("Testing Login Upliner Invalid"),
	T3("Testing Set Target SPV"),
	T4("Testing SPV Approval Target"),
	T5("Testing SPV Isi Penilaian"),
	T6("Testing SPV Cek Penilaian"),
	T7("Testing SPV PA360");
	
	private String testName;
	
	TestCases(String value) {
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
