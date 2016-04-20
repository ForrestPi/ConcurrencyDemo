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
public class FileMock {
    private String content[];
    private int index;
    public FileMock(int size,int length){
        content=new String[size];
        for (int i = 0; i < size; i++) {
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int indice = (int)Math.random()*255;
                buffer.append((char)indice);
            }
            content[i]=buffer.toString();
        }
        index=0;
    }
    
    public boolean hasMoreLines(){
        return index<content.length;
    }
    
    public String getLine(){
        if (this.hasMoreLines()) {
            System.out.println("Mock:"+(content.length-index));
            return content[index++];
        }
        return null;
    }
    
    public static void main(String[] args) {
        FileMock mock=new FileMock(100, 10);
        Buffer buffer = new Buffer(20);
        Producer2 producer2 = new Producer2(mock, buffer);
        Thread threadProducer = new Thread(producer2,"Produicer");
        
        Consumer2 consumer2[]=new Consumer2[3];
        Thread threadConsumers[]=new Thread[3];
        for (int i = 0; i < 3; i++) {
            consumer2[i]=new Consumer2(buffer);
            threadConsumers[i]=new Thread(consumer2[i], "Consumer"+i);
        }
        threadProducer.start();
        for (int i = 0; i < 3; i++) {
            threadConsumers[i].start();
        }
    }
}
