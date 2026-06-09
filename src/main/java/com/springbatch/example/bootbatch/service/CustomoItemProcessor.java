package com.springbatch.example.bootbatch.service;

import com.springbatch.example.bootbatch.model.Employee;
import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomoItemProcessor implements ItemProcessor<Employee, Employee> {

    @Override
    public Employee process(Employee item) throws Exception {
        //logic will be written here
        return item;
    }

}
