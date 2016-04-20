/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * @author Win7
 */
public class PricesInfo {
    private double price1;
    private double price2;
    private ReadWriteLock lock;
    
    public PricesInfo(){
        price1=1.0;
        price2=2.0;
        lock=new ReentrantReadWriteLock();
    }
    public double getPrice1(){
        lock.readLock().lock();
        double value = price1;
        lock.readLock().unlock();
        return value;
    }
    
    public double getPrice2(){
        lock.readLock().lock();
        double value = price2;
        lock.readLock().unlock();
        return value;
    }
    
    public void setPrices(double price1,double price2){
        lock.writeLock().lock();
        this.price1=price1;
        this.price2=price2;
        lock.writeLock().unlock();
    }
    
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        Reader readers[] = new Reader[5];
        Thread threadsReader[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
            readers[i]=new Reader(pricesInfo);
            threadsReader[i] = new Thread(readers[i]);
        }
        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);
        
        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }
        threadWriter.start();
    }
}
