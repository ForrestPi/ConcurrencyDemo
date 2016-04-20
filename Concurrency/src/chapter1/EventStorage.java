/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Win7
 */
public class EventStorage {
    private int maxSize;
    private List<Date> storage;
    public EventStorage(){
        maxSize=10;
        storage = new LinkedList<>();
    }
    
    public synchronized void set(){
        while (storage.size()==maxSize) {            
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.printf("Set: %d\n",storage.size());
        notifyAll();
    }
    
    public synchronized void get(){
        while (storage.size()==0) {            
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d: %s\n",storage.size(),((LinkedList<?>)storage).poll());
        notifyAll();
    }
    
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Thread thread1=new Thread(producer);
        Consumer consumer = new Consumer(storage);
        Thread thread2 = new Thread(consumer);
        
        thread1.start();
        thread2.start();
    }
}
