package com.smart.test;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmartTestApplicationTests {
	public static final Logger LOGGER = LoggerFactory.getLogger(SmartTestApplicationTests.class);

	@Test
	void contextLoads() {
		LOGGER.info("inside test");
		assert true;
	}

}
