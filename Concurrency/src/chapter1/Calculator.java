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
public class Calculator implements Runnable{
    
    private int number;
    public Calculator(int number){
        this.number=number;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%s: %d * %d = %d\n",Thread.currentThread().getName(),number,i,i*number);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Calculator calucator = new Calculator(i);
            Thread thread = new Thread(calucator);
            thread.start();
        }
    }
    
    
}
