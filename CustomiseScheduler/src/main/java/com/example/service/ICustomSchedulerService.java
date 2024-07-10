package com.example.service;

import java.util.concurrent.atomic.AtomicBoolean;

public interface ICustomSchedulerService {

 void startScheduler();
 void stopScheduler();
 
 void runSchedulerManually();
//
// void startScheduler();
//  void stopScheduler() ;
// void runSchedulerManually();
 
}
