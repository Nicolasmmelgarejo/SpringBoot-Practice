package com.practice.springboot.component;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component("taskComponent")
public class TaskComponent {
	private static final Log LOG =LogFactory.getLog(TaskComponent.class);
	
	@Scheduled(fixedDelay = 30000)
	public void doTask() {
		LOG.info("TIME IS: " + new Date());
	}
}
