package com.banhtrangsitayninh.print.service;

import com.banhtrangsitayninh.print.domain.Order;

import java.io.InputStream;
import java.util.List;

/**
 * Created by tuyenhx on 7/31/16.
 */
public interface ExcelService {

    List<Order> parse(InputStream in);
}
