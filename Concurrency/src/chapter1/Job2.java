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
public class Job2 implements Runnable{
    private PrintQueue2 printQueue2;
    
    public Job2(PrintQueue2 printQueue2){
        this.printQueue2=printQueue2;
    }
    @Override
    public void run(){
        System.out.printf("%s: Going to print a job\n",Thread.currentThread().getName());
        printQueue2.printJob(new Object());
        System.out.printf("%s: The document has been printed\n",Thread.currentThread().getName());
    }
}
