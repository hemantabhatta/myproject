package com.example.service;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("service2")
public class CustomSchedulerService1 implements ICustomSchedulerService {
	private final AtomicBoolean isRunning = new AtomicBoolean(false);

	@Scheduled(cron = "0 */2 * ? * *")
	public void scheduledTask() {
		if (isRunning.get() ) {
			this.blogic();
		}
	}

	@Override
	public void runSchedulerManually() {

		this.blogic();

	}

	@Override
	public void startScheduler() {
		isRunning.set(true);

	}

	@Override
	public void stopScheduler() {
		isRunning.set(false);

	}
	
	public void blogic() {
		System.out.println("my custom scheduler2 " + LocalDateTime.now());
	}

}
