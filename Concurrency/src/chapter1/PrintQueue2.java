/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Win7
 */
public class PrintQueue2 {
    private final Semaphore semaphore;
    private boolean freePrinters[];
    private Lock lockPrinters;
    public PrintQueue2(){
        semaphore=new Semaphore(3);
        freePrinters = new boolean[3];
        for (int i = 0; i < 3; i++) {
            freePrinters[i]=true;
        }
        lockPrinters=new ReentrantLock();
    }
    public void printJob(Object document){
        try {
            semaphore.acquire();
            int assignedPrinter=getPrinter();
            long duration = (long)(Math.random()*10);
            System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n",Thread.currentThread().getName(),assignedPrinter,duration);
            TimeUnit.SECONDS.sleep(duration);
            freePrinters[assignedPrinter]=true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally{
            semaphore.release();
        }
    }
    
    private int getPrinter(){
        int ret =-1;
        try {
            lockPrinters.lock();
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    ret=i;
                    freePrinters[i]=false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            lockPrinters.unlock();
        }
        return ret;
    }
    
    public static void main(String[] args) {
        PrintQueue2 printQueue2 = new PrintQueue2();
        Thread thread[]=new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i]=new Thread(new Job2(printQueue2), "Thread"+i);
        }
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }
}
