package com.springbatch.example.bootbatch.config;

import com.springbatch.example.bootbatch.model.Employee;
import com.springbatch.example.bootbatch.service.CustomoItemProcessor;
import com.springbatch.example.bootbatch.service.JobCompletionNotificationImpl;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.batch.infrastructure.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchClass {
    @Autowired
    JobCompletionNotificationImpl listener;

    @Bean
    public Job jobBean(JobRepository jobRepository, JobCompletionNotificationImpl listener, Step steps){

        return new JobBuilder("jb",jobRepository)
                .listener(listener)
                .start(steps)
                .build();

    }

    @Bean
    public Step steps(JobRepository jobRepository,
                      DataSourceTransactionManager transactionManager,
                      ItemReader<Employee> reader,
                      ItemProcessor<Employee, Employee> itemProcessor,
                      ItemWriter<Employee> writer)

    {
        return new StepBuilder("jobStep", jobRepository)
                .<Employee, Employee>chunk(5)
                .reader(reader)
                .processor(itemProcessor)
                .writer(writer)
                .transactionManager(transactionManager)
                .build();
    }

    @Bean
    public FlatFileItemReader<Employee> reader(){
        return new FlatFileItemReaderBuilder<Employee>()
                .name("itemReader")
                .resource(new ClassPathResource("data.csv"))
                .delimited()
                .names("employeeId","name","department")
                .linesToSkip(1)
                .targetType(Employee.class)
                .build();
    }

    //Processor
    @Bean
    public ItemProcessor<Employee, Employee> itemProcessor(){
        return new CustomoItemProcessor();

    }

    //writer
    @Bean
    public ItemWriter<Employee> itemWriter(){
        return item->{
            for(Employee employee:item.getItems()){
                System.out.println(employee);
            }
        };



    }
}
