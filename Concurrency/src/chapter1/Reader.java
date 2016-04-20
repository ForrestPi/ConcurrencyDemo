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
public class Reader implements Runnable{
    private PricesInfo pricesInfo;
    public Reader(PricesInfo pricesInfo){
        this.pricesInfo=pricesInfo;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: Price 1: %f\n",Thread.currentThread().getName(),pricesInfo.getPrice1());
            System.out.printf("%s: Price 2: %f\n",Thread.currentThread().getName(),pricesInfo.getPrice2());
            
        }
    }
}
