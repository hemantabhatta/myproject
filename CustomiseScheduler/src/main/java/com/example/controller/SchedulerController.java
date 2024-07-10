package com.example.controller;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.CustomSchedulerService;
import com.example.service.CustomSchedulerService1;
import com.example.service.ICustomSchedulerService;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {
//	@Autowired
//	private ICustomSchedulerService schedulerService;
//
//	@GetMapping("/msg")
//	public String getMsg(@RequestParam("cno") Integer no) {
//		return "hello";
//	}
//	@GetMapping("/start")
//	public String startScheduler(@RequestParam(name = "name",required = false,defaultValue = "all") String name) {
//		
//		schedulerService.startScheduler(name);
//
//		return "Scheduler started" + LocalDateTime.now();
//	}
//
//	@GetMapping("/stop")
//	public String stopScheduler(@RequestParam(name = "name",required = false,defaultValue = "all") String name) {
//		schedulerService.stopScheduler(name);
//		return "Scheduler stopped" + LocalDateTime.now();
//	}
//
//	@GetMapping("/run")
//	public String runScheduler(@RequestParam(name = "name",required = false,defaultValue = "all") String name) {
//		schedulerService.runSchedulerManually(name);
//		return "Manual task executed" + LocalDateTime.now();
//	}

	
	private final Map<String, ICustomSchedulerService> schedulers;
	
	@Autowired
	public SchedulerController(Map<String, ICustomSchedulerService> schedulers) {
		
		this.schedulers = schedulers;
	}
	
	
	
	@GetMapping("/start")
	public String startScheduler(@RequestParam(name = "name",required = false,defaultValue = "all") String name) {
		System.err.println("name "+name);
		if("all".equalsIgnoreCase(name)) {
			schedulers.values().forEach(ICustomSchedulerService::startScheduler);
			return "All schedulers started "+LocalDateTime.now();
		}
		
		ICustomSchedulerService scheduler = schedulers.get(name);
		if(scheduler != null) {
			System.out.println(scheduler instanceof CustomSchedulerService);
			System.out.println(scheduler instanceof CustomSchedulerService1);
			scheduler.startScheduler();
			return name + "started "+LocalDateTime.now();
		}
		

		return "unknown Scheduler";
	}

	@GetMapping("/stop")
	public String stopScheduler(@RequestParam(name = "name",required = false,defaultValue = "all") String name) {
		if("all".equalsIgnoreCase(name)) {
			schedulers.values().forEach(ICustomSchedulerService::startScheduler);
			return "All schedulers stopped "+LocalDateTime.now();
		}
		
		ICustomSchedulerService scheduler = schedulers.get(name);
		if(scheduler != null) {
			scheduler.stopScheduler();
			return name + "stopped "+LocalDateTime.now();
		}
		

		return "unknown Scheduler";
	}

	@GetMapping("/run")
	public String runScheduler(@RequestParam(name = "name",required = false,defaultValue = "all") String name) {
		
		if("all".equalsIgnoreCase(name)) {
			schedulers.values().forEach(ICustomSchedulerService::runSchedulerManually);
			return "Manual task for all schedulers "+LocalDateTime.now();
		}
		
		ICustomSchedulerService scheduler = schedulers.get(name);
		if(scheduler != null) {
			scheduler.runSchedulerManually();
			return "Manual task for " +name+" executed" + LocalDateTime.now();
		}
		
		return "unknown Scheduler";
	}

}
