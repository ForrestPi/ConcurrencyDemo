/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *
 * @author Win7
 */
public class Server {
    private ThreadPoolExecutor executor;
    public Server(){
        //executor=(ThreadPoolExecutor)Executors.newCachedThreadPool();
        executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(5);
    }
    
    public void executeTask(Task task){
        System.out.printf("Server: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("Server: Pool Size: %d\n",executor.getPoolSize());
        System.out.printf("Server: Activate Count: %d\n",executor.getActiveCount());
        System.out.printf("Server: Task Count: %d\n",executor.getTaskCount());
    }
    
    public void endServer(){
        executor.shutdown();
    }
    
    public static void main(String[] args) {
        Server server = new Server();
        for (int i = 0; i < 100; i++) {
            Task task = new Task("Task "+i);
            server.executeTask(task);
        }
        server.endServer();
    }
}
