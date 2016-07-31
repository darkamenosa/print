package com.banhtrangsitayninh.print.service;

import com.banhtrangsitayninh.print.domain.Order;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuyenhx on 7/31/16.
 */
@Service
public class PrintServiceImpl implements PrintService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrintServiceImpl.class);

    // Use default template engine of springboot
    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private ExcelService excelService;

    @Override
    public void print(String fileName, InputStream inputStream) throws IOException {
        // Parse excel
        List<Order> orders = excelService.parse(inputStream);
        String htmlContent = processTemplate(orders);

        // Parse to pdf
        try {
            // step 1
            Document document = new Document();
            // step 2
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("result.pdf"));
            // step 3
            document.open();
            // step 4
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringReader(htmlContent));
            // step 5
            document.close();
        } catch (DocumentException de) {
            LOGGER.debug("{}", de);
        }
    }

    public String processTemplate(List<Order> orders) {
        Context context = new Context();
        context.setVariable("orders", orders);
        String htmlContent = templateEngine.process("print", context);
        return htmlContent;
    }
}
