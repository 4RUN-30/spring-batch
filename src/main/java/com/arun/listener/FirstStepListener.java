package com.arun.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class FirstStepListener implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("Before first step execution");
        System.out.println("Step name : "+stepExecution.getStepName());
        System.out.println("Job Execution Context from step one : "+stepExecution.getJobExecution().getExecutionContext());
        System.out.println("Step execution context from step one : "+stepExecution.getExecutionContext());

        stepExecution.getExecutionContext().put("food","pizza");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("After first step execution");
        System.out.println("Step name : "+stepExecution.getStepName());
        System.out.println("Job Execution Context from step one : "+stepExecution.getJobExecution().getExecutionContext());
        System.out.println("Step execution context from step one : "+stepExecution.getExecutionContext());
        return null;
    }
}
