package com.immigration.employee.batch;

import com.immigration.employee.entities.User;
import com.immigration.employee.repository.UserRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import javax.mail.internet.MimeMessage;
import java.util.Collections;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    UserRepository userRepository;

    @Value("${spring.mail.username}")
    private String sender;

    @Bean
    public RepositoryItemReader<User> reader() {
        RepositoryItemReader<User> reader = new RepositoryItemReader<>();
        reader.setRepository(userRepository);
        reader.setMethodName("findAll");
        reader.setSort(Collections.singletonMap("id", Sort.Direction.ASC));
        return reader;
    }

    @Bean
    public UserItemProcessor processor() {
        return new UserItemProcessor(sender);
    }

    @Bean
    public MailBatchItemWriter writer() {
        MailBatchItemWriter writer = new MailBatchItemWriter();
        return writer;
    }

    @Bean
    public Job importUserJob(JobExecutionListener listener) {
        return this.jobBuilderFactory.get("importUserJob")
                .incrementer(new DynamicJobParameters())
                .listener(listener)
//                .start(chunkStep())
                .flow(chunkStep())
                .end()
                .build();
    }


    @Bean
    public Step chunkStep() {
        return stepBuilderFactory.get("chunkStep")
                .<User, MimeMessage>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }


}
