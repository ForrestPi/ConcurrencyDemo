/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Win7
 */
public class Participant implements Runnable{
    private Videoconference conference;
    private String name;
    public Participant(Videoconference conference,String name){
        this.conference=conference;
        this.name=name;
    }
    
    @Override
    public void run(){
        long duration=(long)(Math.random()*10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conference.arrive(name);
    }
}
