package com.immigration.employee.batch;
  
import java.util.Calendar;  
import java.util.Date;  
import org.springframework.batch.core.JobParameters;  
import org.springframework.batch.core.JobParametersBuilder;  
import org.springframework.batch.core.JobParametersIncrementer;  
  
/** 
 * @author nagarajuv 
 * 
 */  
  
public class DynamicJobParameters implements JobParametersIncrementer {  
 Date date = null;  
 public JobParameters getNext(JobParameters parameters) {  
  date = new Date();  
      
  parameters = new JobParametersBuilder().addLong("currentTime", new Long(System.currentTimeMillis())).toJobParameters();  
    
  return parameters;  
 }  
}  