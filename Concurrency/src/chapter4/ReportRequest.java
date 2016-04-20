/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter4;

import java.util.concurrent.CompletionService;

/**
 *
 * @author Win7
 */
public class ReportRequest implements Runnable{
    private String name;
    private CompletionService<String> service;
    public ReportRequest(String name,CompletionService<String> service){
        this.name=name;
        this.service=service;
    }
    @Override
    public void run(){
        ReportGenerator reportGenerator = new ReportGenerator(name, "Report");
        service.submit(reportGenerator);
    }
}
