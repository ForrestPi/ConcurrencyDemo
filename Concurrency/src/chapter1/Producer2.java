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
public class Producer2 implements Runnable{
    private FileMock mock;
    private Buffer buffer;
    public Producer2(FileMock mock,Buffer buffer){
        this.mock=mock;
        this.buffer=buffer;
    }
    @Override
    public void run(){
        buffer.setPendingLines(true);
        while (mock.hasMoreLines()) {            
            String line = mock.getLine();
            buffer.inset(line);
        }
        buffer.setPendingLines(false);
    }
}
