package com.jpa.book.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PriceScheduling {
	Logger log=LoggerFactory.getLogger(PriceScheduling.class);
	@Async
	@Scheduled(initialDelay=2000,fixedRateString="${price.interval}")
	public void schedule() throws InterruptedException {
		Thread.sleep(4000);
		log.info("price update every : "+LocalDateTime.now());
	}

}
