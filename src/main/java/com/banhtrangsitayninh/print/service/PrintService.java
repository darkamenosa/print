package com.banhtrangsitayninh.print.service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tuyenhx on 7/31/16.
 */
public interface PrintService {
    void print(String fileName, InputStream inputStream) throws IOException;
}
