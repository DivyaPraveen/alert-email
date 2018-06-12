/*
 * Copyright (c) 2018, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.immigration.employee.batch;

import com.immigration.employee.shared.MessageStatus;
import com.immigration.employee.shared.MessageType;
import com.immigration.employee.shared.StartJobResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Component used to execute the batch job on a schedule.
 *
 * 
 */
@Component
@EnableScheduling
@Profile("!test")
public class BatchScheduler {

    private static final Log LOG = LogFactory.getLog(BatchScheduler.class);

    private final RestTemplate restTemplate;


    protected String startUrl;

    @Autowired
    public BatchScheduler(
            final RestTemplateBuilder builder,
            final @Value("${batch.start-url}") String startUrl,
            final @Value("${batch.start-timeout-ms}") int startTimeoutMs) {

        // see https://docs.spring.io/spring-boot/docs/1.4.0.RELEASE/reference/html/boot-features-restclient.html
        // Do any additional configuration here

        this.restTemplate = builder.setConnectTimeout(startTimeoutMs).build();

        this.startUrl = startUrl;
    }

    @Scheduled(cron = "${processing.schedule.cron}")
    public void runJob() {

        StartJobResponse startJobResponse = requestJobStart();

        String jobId = null;
        MessageStatus startStatus = MessageStatus.NOT_STARTED;

        if (startJobResponse != null && startJobResponse.getStarted()) {

            jobId = startJobResponse.getJobId();
            startStatus = MessageStatus.START_SUCCEEDED;
        }

        System.out.println(MessageType.JOB_STATUS +" "+ startStatus+" "+ jobId);
    }

    private StartJobResponse requestJobStart() {

        System.out.println( MessageType.JOB_STATUS+" "+ MessageStatus.START_REQUESTED+" " +null);

        return this.restTemplate.getForObject(this.startUrl, StartJobResponse.class);
    }
}
