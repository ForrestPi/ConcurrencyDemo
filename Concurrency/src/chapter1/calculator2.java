/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Win7
 */
public class calculator2 implements Runnable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread threads[] = new Thread[10];
        Thread.State status[] = new Thread.State[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new calculator2(i));
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }
        try (FileWriter file = new FileWriter("./log.txt"); PrintWriter pw = new PrintWriter(file)) {
            for (int i = 0; i < 10; i++) {
                pw.println("Mian: Status of Thread " + i + ":" + threads[i].getName());
                status[i] = threads[i].getState();
            }
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }

        } catch (Exception e) {
            System.err.println("Error!");
        }

    }

    private final int number;

    public calculator2(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
        }
    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main: Id %d -%s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main: Old State: %s\n", state);
        pw.printf("Main : New Sate: %s\n", thread.getState());
        pw.printf("Main : *********************************\n");
    }
}
