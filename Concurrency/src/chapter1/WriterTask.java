/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Win7
 */
public class WriterTask implements Runnable{
    private Deque<Event> deque;
    public WriterTask(Deque<Event> deque){
        this.deque=deque;
    }
    @Override
    public void run(){
        for (int i = 1; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread %s has generated an event", Thread.currentThread().getId()));
            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
