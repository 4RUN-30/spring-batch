package com.arun.service;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Service;

@Service
public class FirstTasklet implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {
        System.out.println("This is the first step : tasklet step");
        System.out.println("Trying to get the name from Job Execution Context " + chunkContext.getStepContext().getJobExecutionContext().get("Name"));
        return RepeatStatus.FINISHED;
    }
}
