//package com.banhtrangsitayninh.print.service;
//
//import com.banhtrangsitayninh.print.domain.Order;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.IOException;
//import java.util.List;
//
///**
// * Created by tuyenhx on 7/31/16.
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ExcelServiceTest {
//    private final static Logger LOGGER = LoggerFactory.getLogger(ExcelServiceTest.class);
//    @Autowired
//    private ExcelService excelService;
//
////    @Test
////    public void testReadExcel() throws IOException {
////        Resource resource = new ClassPathResource("TestData.xlsx");
////        List<Order> orders = excelService.parse(resource.getInputStream());
////        LOGGER.debug("Order size: {}", orders.size());
////    }
//}
//
