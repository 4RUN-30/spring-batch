package com.arun.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class FirstJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("Before Job Execution");
        System.out.println("Job Name : " + jobExecution.getJobInstance().getJobName());
        System.out.println("Job Params : " + jobExecution.getJobParameters());
        System.out.println("Job Execution Context : " + jobExecution.getExecutionContext());

        jobExecution.getExecutionContext().put("Name","Akshika");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("After Job Execution");
        System.out.println("Job Name : " + jobExecution.getJobInstance().getJobName());
        System.out.println("Job Params : " + jobExecution.getJobParameters());
        System.out.println("Job Execution Context : " + jobExecution.getExecutionContext());
    }
}
