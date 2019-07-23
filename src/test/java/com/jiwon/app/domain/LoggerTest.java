package com.jiwon.app.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
@ActiveProfiles("dev")
public class LoggerTest {
	private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

	@Test
	public void log() throws Exception {
		logger.info("logging info level");
		logger.debug("logging debug level");
	}
}
