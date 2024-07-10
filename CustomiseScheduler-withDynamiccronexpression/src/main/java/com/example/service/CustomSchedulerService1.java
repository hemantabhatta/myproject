package com.example.service;

import java.time.LocalDateTime;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

@Service("service2")
public class CustomSchedulerService1 implements ICustomSchedulerService,SchedulingConfigurer {
	private final AtomicBoolean isRunning = new AtomicBoolean(false);
	private String cronExpression = "0/50 * * * * *";

	private final TaskScheduler taskScheduler;
	private ScheduledFuture<?> scheduledFuture;
	
	public CustomSchedulerService1(TaskScheduler taskScheduler) {
		 this.taskScheduler = taskScheduler;
	}
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskScheduler);
		this.scheduleTask();
	}
	
	private void scheduleTask() {
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        scheduledFuture = taskScheduler.schedule(this::scheduledTask, new CronTrigger(cronExpression));
    }
	
//	@Scheduled(cron = "0 */2 * ? * *")
	public void scheduledTask() {
		if (isRunning.get()) {
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

	@Override
	public void updateCronExpression(String cronExpression) {
		 this.cronExpression = cronExpression;
	        scheduleTask();
	}

	

}
