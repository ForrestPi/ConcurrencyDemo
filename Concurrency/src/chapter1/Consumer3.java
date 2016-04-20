/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 *
 * @author Win7
 */
public class Consumer3 implements Runnable{
    private List<String> buffer;
    private final Exchanger<List<String>> exchanger;
    public Consumer3(List<String> buffer, Exchanger<List<String>> exchanger){
        this.buffer=buffer;
        this.exchanger=exchanger;
    }

    @Override
    public void run() {
        int cycle=1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Consumer3: Cycle %d\n",cycle);
            try {
                buffer=exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Consumer: %d\n",buffer.size());
            for (int j = 0; j < 10; j++) {
                String messager=buffer.get(0);
                System.out.printf("Consumer3: %s\n",messager);
                buffer.remove(0);
            }
            cycle++;
        }
    }
    
    public static void main(String[] args) {
        List<String> buffer1=new ArrayList<>();
        List<String> buffer2=new ArrayList<>();
        
        Exchanger<List<String>>exchanger = new Exchanger<>();
        
        Producer3 producer3 = new Producer3(buffer1, exchanger);
        Consumer3 consumer3 = new Consumer3(buffer2, exchanger);
        Thread threadProducer = new Thread(producer3);
        Thread threadConsumer = new Thread(consumer3);
        threadProducer.start();
        threadConsumer.start();
    }
}
