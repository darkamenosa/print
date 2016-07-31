package com.banhtrangsitayninh.print.parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Excel response class.
 * @param <T> class of data
 * @param <V> class of error
 */
public class ExcelResponse<T, V> {
    protected List<T> data;
    protected List<V> errors;

    public ExcelResponse() {
        this.data = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<V> getErrors() {
        return errors;
    }

    public void setErrors(List<V> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "ExcelResponse{" +
            "data=" + data +
            ", errors=" + errors +
            '}';
    }
}

