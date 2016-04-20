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
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Class that simulates an initialization operation. It sleeps during six seconds 
 *
 */
public class NetworkConnectionsLoader implements Runnable {


	/**
	 * Main method of the class
	 */
	@Override
	public void run() {
		// Writes a message
		System.out.printf("Begining network connections loading: %s\n",new Date());
		// Sleep six seconds
		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Writes a message
		System.out.printf("Network connections loading has finished: %s\n",new Date());
	}
}
