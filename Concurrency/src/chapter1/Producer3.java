/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 *
 * @author Win7
 */
public class Producer3 implements Runnable{
    private List<String> buffer;
    private final Exchanger<List<String> > exchanger;
    public Producer3(List<String> buffer, Exchanger<List<String>> exhcnager){
        this.buffer=buffer;
        this.exchanger=exhcnager;
    }

    @Override
    public void run() {
        int cycle=1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("Producer: Cycle %d\n",cycle);
            for (int j = 0; j < 10; j++) {
                String message = "Event "+((i*10)+j);
                System.out.printf("Producer: %s\n",message);
                buffer.add(message);
            }
            try {
                buffer=exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Producer: %d\n",buffer.size());
            cycle++;
        }
    }
}
