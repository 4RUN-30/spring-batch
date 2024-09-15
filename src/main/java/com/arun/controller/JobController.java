package com.arun.controller;

import com.arun.request.JobParamRequest;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/batch")
public class JobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Qualifier("firstJob")
    @Autowired
    private Job firstJob;

    @Qualifier("secondJob")
    @Autowired
    private Job secondJob;


    @GetMapping("/start/{jobName}")
    public String start(@PathVariable String jobName, @RequestBody List<JobParamRequest> jobParamRequests) throws Exception{

        Map<String, JobParameter> params = new HashMap<>();
        params.put("currentTime",new JobParameter(System.currentTimeMillis()));

        jobParamRequests.forEach(parameter -> {
            params.put(parameter.getKey(),new JobParameter(parameter.getValue()));
        });

        JobParameters jobParameters = new JobParameters(params);

        if(jobName.equals("FirstJob")){
            jobLauncher.run(firstJob,jobParameters);
        }
        else if(jobName.equals("SecondJob")){
            jobLauncher.run(secondJob,jobParameters);
        }
        return "Job Started";
    }

}
