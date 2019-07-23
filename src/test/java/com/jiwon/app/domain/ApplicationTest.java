package com.jiwon.app.domain;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jiwon.app.service.ApplicationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
@ActiveProfiles("dev")
public class ApplicationTest {
	private static final Logger logger = LoggerFactory.getLogger(ApplicationTest.class);

	@Autowired
	private ApplicationDomain appDomain;

	@Autowired
	private ApplicationService appSvc;

	@Test
	public void schedule() throws Exception {
		// @Scheduled는 비동기적으로 실행된다.
		while (true) {
			System.out.println("Hello World");
			Thread.sleep(1000);
		}
	}

	@Test
	public void execute() throws Exception {
		appDomain.execute();
	}

	@Test
	public void select() throws Exception {
		Map<String, Object> map = new HashMap<>();
		appSvc.select(map);
	}
}
