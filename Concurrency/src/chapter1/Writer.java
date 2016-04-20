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
public class Writer implements Runnable{
    private PricesInfo pricesInfo;
    public Writer(PricesInfo pricesInfo){
        this.pricesInfo=pricesInfo;
    }
    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {
            System.out.printf("Writer: Attempt to modify the price.\n");
            pricesInfo.setPrices(Math.random()*10, Math.random()*8);
            System.out.printf("Writer: Prices have been modified.\n");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }
    }
}
