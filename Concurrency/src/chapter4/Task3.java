/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Win7
 */
public class Task3 implements Callable<String>{
    private String name;
    public Task3(String name){
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        System.out.printf("%s: Starting at: %s\n",name,new Date());
        return "Hello,World";
    }
    public static void main(String[] args) {
        ScheduledExecutorService executor = (ScheduledExecutorService)Executors.newScheduledThreadPool(1);
        System.out.printf("Main: Starting at:\n",new Date());
        for (int i = 0; i < 5; i++) {
            Task3 task3 = new Task3("Task_"+i);
            executor.schedule(task3, i+1, TimeUnit.SECONDS);
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Ends at: %s\n",new Date());
    }
}
