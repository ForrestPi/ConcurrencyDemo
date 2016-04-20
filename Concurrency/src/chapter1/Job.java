/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

/**
 *
 * @author Win7
 */
public class Job implements Runnable{
    private PrintQueue printQueue;
    public Job(PrintQueue printQueue){
        this.printQueue=printQueue;
    }
    @Override
    public void run(){
        System.out.printf("%s: Going to print a document\n",Thread.currentThread().getName());
        printQueue.printJob(new Object());
        System.out.printf("%s: Going to print a printed\n",Thread.currentThread().getName());
    }
}
