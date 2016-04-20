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
public class MyThreadGroup extends ThreadGroup{
    public MyThreadGroup(String name){
        super(name);
    }
    @Override
    public void uncaughtException(Thread t,Throwable e){
        System.out.printf("The thread %s has thrown an Exception\n",t.getId());
        e.printStackTrace(System.out);
        System.out.printf("Terminating the rest of the Threads\n");
        interrupt();
    }
  
    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        Task2 task2=new Task2();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(threadGroup,task2);
            t.start();
        }
    }
}
