/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Win7
 */
public class FileClock implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n",new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("The FileClock has been interruptted");
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
    
}
