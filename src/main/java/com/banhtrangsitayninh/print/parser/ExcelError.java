package com.banhtrangsitayninh.print.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuyenhx on 7/7/16.
 */
public class ExcelError {

    private String cell;
    private List<String> message = new ArrayList<>();

    public ExcelError() {
    }

    public ExcelError(String cell, List<String> message) {
        this.cell = cell;
        this.message = message;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
