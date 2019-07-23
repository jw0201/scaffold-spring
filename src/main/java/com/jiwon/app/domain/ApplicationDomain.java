package com.jiwon.app.domain;

import java.time.LocalDateTime;

import com.jiwon.app.service.ApplicationService;
import com.jiwon.app.service.ElasticSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ApplicationDomain {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationDomain.class);

	@Autowired
	private ApplicationService appSvc;

	@Autowired
	private ElasticSearchService esSvc;

	@Scheduled(cron = "* * * * * ?")
	public void schedule() throws InterruptedException {
		logger.info("schedule() job is execute {}", LocalDateTime.now());

		int count = 0;

		while (true) {
			logger.info("This is loop message");
			Thread.sleep(1000);

			if (count++ > 20)
				break;
			
		}
	}

	// 같은 어플리케이션 안의 모든 스케쥴링 작업들은 one thread로 실행된다. 첫번째 메소드의 실행이 끝나면 이미 스케쥴링 된 작업들이 순차적으로 실행된다.
	@Scheduled(cron = "0 * * * * ?")
	public void execute() throws InterruptedException {
		logger.info("execute() job is execute {}", LocalDateTime.now());
		int count = 0;

		while (true) {
			logger.info("This is loop message2");
			Thread.sleep(5000);
			
			if (count++ > 20) break;
		}
	}
}