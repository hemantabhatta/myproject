package com.example.service;

public interface ICustomSchedulerService {
	

	void startScheduler();

	void stopScheduler();

	void runSchedulerManually();

	void updateCronExpression(String cronExpression);

}
