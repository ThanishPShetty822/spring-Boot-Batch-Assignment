//package com.springbatch.example.bootbatch.services;
//
//import com.springbatch.example.bootbatch.model.Employee;
//import com.springbatch.example.bootbatch.service.CustomoItemProcessor;
//import lombok.SneakyThrows;
//import org.junit.jupiter.api.*;
//import org.mockito.Mock;
//
//public class CustomItemProcessorTest {
//
//
//    @BeforeAll
//    public static void init(){
//        System.out.println("Executes before all the test cases");
//    }
//    @AfterAll
//    public static void cleanup(){
//        System.out.println("Executes before all the test cases");
//    }
//
//    @BeforeEach
//    public void beforeTestCase(){
//        System.out.println("Before Each Test case");
//    }
//
//    @AfterEach
//    public void afterTestCase(){
//        System.out.println("After Each Test case");
//    }
//
//    @SneakyThrows
//    @Test
//    @DisplayName("Giving Custom Test name")
//    public void processTest(){
//        System.out.println("First Test case");
//        int  expected=50;
//        CustomoItemProcessor customoItemProcessor=new CustomoItemProcessor();
//        Employee item=new Employee("Apple",123, "Kashmir",100, 50);
//        Employee object=customoItemProcessor.process(item);
//        int result= object.getDisounted_price();
//        Assertions.assertEquals(expected,result,"The Test case Failed.");
//
//    }
//
//    @SneakyThrows
//    @Test
//    public void processTestTwo(){
//        System.out.println("Second Test Case");
//        int  expected=500;
//        CustomoItemProcessor customoItemProcessor=new CustomoItemProcessor();
//        Employee item=new Employee("Apple",123, "Kashmir",1000, 50);
//        Employee object=customoItemProcessor.process(item);
//        int result= object.getDisounted_price();
//        Assertions.assertEquals(expected,result,"The Test case Failed.");
//
//    }
//}
