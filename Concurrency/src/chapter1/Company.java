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
public class Company implements Runnable{
    private Account account;
    public Company(Account account){
        this.account=account;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000);
        }
    }
}
