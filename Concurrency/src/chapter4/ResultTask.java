/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Win7
 */
public class ResultTask extends FutureTask<String> {

    private String name;

    public ResultTask(Callable<String> callable) {
        super(callable);
        this.name = ((ExecutableTask) callable).getName();

    }

    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("%s: Has been canceled\n",name);
        }else{
            System.out.printf("%s: Has finished\n",name);
        }
    }
    public static void main(String[] args) throws ExecutionException {
        ExecutorService executor = (ExecutorService)Executors.newCachedThreadPool();
        ResultTask resultTasks[]=new ResultTask[5];
        
        for (int i = 0; i < 5; i++) {
            ExecutableTask executableTasks = new ExecutableTask("Task "+i);
            resultTasks[i]=new ResultTask(executableTasks);
            executor.submit(resultTasks[i]);
        }
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < resultTasks.length; i++) {
            try {
                if (!resultTasks[i].isCancelled()) {
                    System.out.printf("%s\n",resultTasks[i].get());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
