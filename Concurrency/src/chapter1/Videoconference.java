/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Win7
 */
public class Videoconference implements Runnable{
    private final CountDownLatch controller;
    public Videoconference(int number){
        controller=new CountDownLatch(number);
    }
    public void arrive(String name){
        System.out.printf("%s has arrived.\n",name);
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n",controller.getCount());
    }
    @Override
    public void run(){
        System.out.printf("VideoConference: Initalization: %d participants.\n",controller.getCount());
        try {
            controller.await();
            System.out.printf("VideoConference: All the participants have come\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Videoconference conference = new Videoconference(10);
        Thread threadConference = new Thread(conference);
        threadConference.start();
        for (int i = 0; i < 10; i++) {
            Participant p =new Participant(conference, "Paricipant "+i);
            Thread t =new Thread(p);
            t.start();
        }
    }
}
