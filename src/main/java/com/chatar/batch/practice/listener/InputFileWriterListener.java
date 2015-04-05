package com.chatar.batch.practice.listener;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class InputFileWriterListener implements JobExecutionListener {

	public void beforeJob(JobExecution jobExecution) {
        System.out.println(jobExecution.getJobInstance().getJobName()
                + " is beginning execution");
        
        String fileName = jobExecution.getJobInstance().getJobParameters().getString("inputFile");
        long inputFileSize = jobExecution.getJobInstance().getJobParameters().getLong("inputFileSize");
        File file = new File(fileName);
        System.out.println("file::: "+ file.canWrite());
        
        try {
			FileWriter writer = new FileWriter(file);
			for(int i =0; i < inputFileSize; i++) {
				writer.write("abc ::: "+i);
				writer.write("\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void afterJob(JobExecution jobExecution) {
        System.out.println(jobExecution.getJobInstance()
                                       .getJobName()
                                       + " has completed with the status " +
                                       jobExecution.getStatus());
    }

}
