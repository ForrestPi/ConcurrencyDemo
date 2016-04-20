/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import sun.nio.cs.Surrogate;

/**
 *
 * @author Win7
 */
public class ReportGenerator implements Callable<String>{
    private String sender;
    private String title;
    
    public ReportGenerator(String sender,String title){
        this.sender=sender;
        this.title=title;
    }
    @Override
    public String call() throws Exception{
        try {
            long duration =(long)(Math.random()*10);
            System.out.printf("%s_%s: ReportGenerator:Surrogate.Generating a report during %d seconds\n",this.sender,this.title,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String ret = sender+": "+title;
        return ret;
    }
}
