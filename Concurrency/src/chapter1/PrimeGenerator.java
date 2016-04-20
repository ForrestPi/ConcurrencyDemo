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
public class PrimeGenerator extends Thread{
    @Override
    public void run(){
        long number=1L;
        while (true) {            
            if (isPrime(number)) {
                System.out.printf("Number %d is Prime\n",number);
            }
            if (isInterrupted()) {
                System.out.printf("The Prime Generator has been Interrupted");
                return;
            }
            number++;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        task.interrupt();
    }

    private boolean isPrime(long number) {
        if (number<=2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i)==0) {
                return false;
            }
        }
        return false;
    }
    
}
