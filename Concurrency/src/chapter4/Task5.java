/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Win7
 */
public class Task5 implements Callable<String>{
    @Override
    public String call()throws Exception{
        while (true) {            
            System.out.printf("Task: Test\n");
            Thread.sleep(100);
        }
    }
    
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        Task5 task5 = new Task5();
        System.out.printf("Main: Executing the Task\n");
        Future<String> result = executor.submit(task5);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main: Canceling the Task\n");
        result.cancel(true);
        System.out.printf("Main: Cancelled:%s\n",result.isCancelled());
        System.out.printf("Main: Done:%s\n",result.isDone());
        executor.shutdown();
        System.out.printf("Main: The executor has finished\n");
    }
}
