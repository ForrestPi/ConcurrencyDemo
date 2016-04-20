/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Win7
 */
public class Task2 implements Callable<Result> {

    private String name;

    public Task2(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.printf("%s: Starting\n", this.name);
        try {
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: Waiting %s seconds for results.\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int value = 0;
        for (int i = 0; i < 5; i++) {
            value += (int) (Math.random() * 100);
        }
        Result result = new Result();
        result.setName(this.name);
        result.setValue(value);
        System.out.printf(this.name+": Ends\n");
        return result;
    }
    
    public static void main(String[] args) {
        ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();
        List<Task2> taskList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Task2 task2 = new Task2("Task_"+i);
            taskList.add(task2);
        }
        List<Future<Result>>resultList = null;
        try {
            resultList=executor.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.printf("Main: Printing the results\n");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Result> future = resultList.get(i);
            try {
                Result result = future.get();
                System.out.println(result.getName()+": "+result.getValue());
            } catch (InterruptedException|ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
