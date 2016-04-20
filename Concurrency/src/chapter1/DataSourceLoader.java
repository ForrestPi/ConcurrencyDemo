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
public class DataSourceLoader implements Runnable{

    @Override
    public void run(){
        System.out.printf("Beijing data sources loading: %s\n",new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Data source loading has fininshed: %s\n", new Date());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSourceLoader dsLoader = new DataSourceLoader();
        Thread thread1 = new Thread(dsLoader,"DataSourceThread");
        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread thread2=new Thread(ncLoader,"NetworkConnectionLaoder");
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Main : Configuration has been loaded: %s\n",new Date());
    }
    
}
