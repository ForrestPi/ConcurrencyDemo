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
public class Results {
    private int data[];
    public Results(int size){
        data=new int[size];
    }
    
    public void setData(int position, int value){
        try {
            data[position]=value;
        } catch (NullPointerException e) {
            System.out.printf("position %d",position);
            e.printStackTrace();
        }
        
    }
    public int[] getData(){
        return data;
    }
}
