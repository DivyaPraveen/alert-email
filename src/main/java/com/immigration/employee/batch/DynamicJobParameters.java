package com.immigration.employee.batch;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

import java.util.Date;

/**
 * This class changes the job parameter each time the job is executed. Helps for development
 * Solves error : A job instance already exists and is complete for parameters={run.id=}.
 * If you want to run this job again, change the parameters.
 */

public class DynamicJobParameters implements JobParametersIncrementer {
    Date date = null;

    public JobParameters getNext(JobParameters parameters) {
        date = new Date();

        parameters = new JobParametersBuilder().addLong("currentTime", new Long(System.currentTimeMillis())).toJobParameters();

        return parameters;
    }
}  