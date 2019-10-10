package com.duzon.nsm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OracleConnectionTest {
	
	// Logger : OracleConnectionTest.class 현재 class를 대상으로 log를 수집하겠다는 의미
	// privaet : 외부에서 로그를 가로채지 못하게 하기 위해서
	// static final : 로그 내용이 바뀌지 않으므로
	private static final Logger logger = LoggerFactory.getLogger(OracleConnectionTest.class);
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	

}
