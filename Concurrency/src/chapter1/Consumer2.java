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
public class Consumer2 implements Runnable{
    private Buffer buffer;
    public Consumer2 (Buffer buffer){
        this.buffer = buffer;
    }
    @Override
    public void run(){
        while (buffer.hasPendingLines()) {            
            String line=buffer.get();
            processLine(line);
        }
    }
    
    private void processLine(String line){
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
