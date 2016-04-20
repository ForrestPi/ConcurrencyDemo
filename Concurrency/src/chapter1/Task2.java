/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.Random;

/**
 *
 * @author Win7
 */
public class Task2 implements Runnable{
    @Override
    public void run(){
        int result;
        Random random = new Random(Thread.currentThread().getId());
        while (true) {            
            result=1000/((int)(random.nextDouble()*1000));
            System.out.printf("Id: %s:%d\n",Thread.currentThread().getId(),result);
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("Id: %d: Interrupted\n",Thread.currentThread().getId());
                return;
            }
        }
    }
}
