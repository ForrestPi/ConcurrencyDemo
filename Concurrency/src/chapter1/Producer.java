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
public class Producer implements Runnable{
    private EventStorage storage;
    public Producer(EventStorage storage){
        this.storage = storage;
    }
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }
}
