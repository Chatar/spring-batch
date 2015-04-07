package com.chatar.batch.jobs;

import java.util.Date;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class HelloWorld implements Tasklet {

     private String name;

     public RepeatStatus execute( StepContribution arg0, ChunkContext context ) throws Exception {
          Date cob =
                  (Date) context.getStepContext().getJobParameters().get("cob");
              System.out.println( "COB :: "+cob );
              System.out.println("name:: "+name);
          
          return RepeatStatus.FINISHED;
     }
     
     public void setName(String newName) {
         name = newName;
     }

     public String getName() {
         return name;
     }
}