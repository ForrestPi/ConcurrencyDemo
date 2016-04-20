/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Win7
 */
public class ExecutableTask implements Callable<String>{
    private String name;
    public String getName(){
        return name;
    }
    public ExecutableTask(String name){
        this.name=name;
    }
    @Override
    public String call()throws Exception{
        try {
            long duration = (long)(Math.random()*10);
            System.out.printf("%s: Waiting %d seconds for results\n",this.name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello world. I'm "+name;
    }
}
