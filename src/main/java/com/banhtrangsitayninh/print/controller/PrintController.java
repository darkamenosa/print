package com.banhtrangsitayninh.print.controller;

import com.banhtrangsitayninh.print.domain.Order;
import com.banhtrangsitayninh.print.service.ExcelService;
import com.banhtrangsitayninh.print.service.PrintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by tuyenhx on 8/1/16.
 */
@Controller
public class PrintController {

    @Autowired
    private ExcelService excelService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file")MultipartFile file, ModelMap modelMap) throws IOException {
        String fileName = file.getOriginalFilename();
        InputStream inputStream = file.getInputStream();
        List<Order> orders = excelService.parse(inputStream);
        for (Order order : orders) {
            System.out.println(order);
        }
        modelMap.addAttribute("orders", orders);
        return "print";
    }
}
