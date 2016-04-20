/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1;

import java.util.concurrent.Phaser;

/**
 *
 * @author Win7
 */
public class MyPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                return studentsArrived();
            case 1:
                return finishFirstExercise();
            case 2:
                return finishExam();
            default:
                return true;
        }
    }

    private boolean studentsArrived() {
        System.out.printf("Phaser: The exam are going to start. The students are ready.\n");
        System.out.printf("Phaser: we have %d students.\n",getRegisteredParties());
        return false;
    }

    private boolean finishFirstExercise() {
        System.out.printf("Phaser;All the students have finished the first exercise.\n");
        System.out.printf("Phaser: It's time for the second one.\n");
        return false;
    }

    private boolean finishExam() {
        System.out.printf("Phaser:All the students have finished the exam.\n");
        System.out.printf("Phaser: Thank you for your time.\n");
        return true;
        
    }  
    
     public static void main(String[] args) {
        MyPhaser phaser = new MyPhaser();
        Student students[] = new Student[5];
        for (int i = 0; i < 5; i++) {
            students[i]=new Student(phaser);
            phaser.register();
        }
        Thread threads[]=new Thread[students.length];
        for (int i = 0; i < students.length; i++) {
            threads[i]=new Thread(students[i], "Student_"+i);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Main: The phaser has finished: %s.\n",phaser.isTerminated());
    }
     
}
