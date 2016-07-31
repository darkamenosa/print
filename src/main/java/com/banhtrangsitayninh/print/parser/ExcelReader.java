package com.banhtrangsitayninh.print.parser;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by tuyenhx on 7/7/16.
 */
public class ExcelReader<T, V> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private static final char CSV_DELIMITER = ';';

    public interface RowConverter<T> {
        T convert(String[] row);
    }

    public interface ErrorConverter<V> {
        V convert(Map<String, Exception> data);
    }

    public static class Builder<T, V> {
        private RowConverter<T> dataConverter;
        private ErrorConverter<V> errorConverter;
        private int sheet;
        private char delimiter;
        private int startRow;

        public Builder() {
            // Initial default value
            this.sheet = 0;
            this.startRow = 0;
            this.delimiter = CSV_DELIMITER;
        }

        public Builder<T, V> dataConverter(RowConverter<T> converter) {
            this.dataConverter = converter;
            return this;
        }

        public Builder<T, V> errorConverter(ErrorConverter<V> converter) {
            this.errorConverter = converter;
            return this;
        }

        // zero base sheet number
        public Builder<T, V> sheet(int sheetNumber) {
            if (sheetNumber < 0) throw new RuntimeException("sheet number must be greater than 0");
            this.sheet = sheetNumber;
            return this;
        }

        public Builder<T, V> delimiter(char delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        public Builder<T, V> setStartRow(int startRow) {
            this.startRow = startRow;
            return this;
        }

        public ExcelReader<T, V> build() {
            return new ExcelReader<>(this);
        }
    }

    public static <T, V> Builder<T, V> builder(Class<T> dataClass, Class<V> errorClass) {
        return new Builder<>();
    }

    // Fields
    private Builder<T, V> info;

    // Constructor
    private ExcelReader(Builder<T, V> info) {
        this.info = info;
    }

    // Methods
    public ExcelResponse<T, V> read(String fileName) throws InvalidFormatException, IOException {
        ExcelResponse<T, V> result;
        try (InputStream is = new FileInputStream(fileName);) {
            result = read(is);
        }
        return result;
    }

    public ExcelResponse<T, V> read(InputStream is) throws IOException, InvalidFormatException {
        ExcelResponse<T, V> result;
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(is)) {
            if (isExcel(bufferedInputStream)) {
                result = readExcel(bufferedInputStream);
            } else {
                result = readCSV(bufferedInputStream);
            }
        }
        return result;
    }

    protected ExcelResponse<T, V> readExcel(InputStream is) throws IOException, InvalidFormatException {
        Workbook workbook = WorkbookFactory.create(is);
        Sheet sheet = workbook.getSheetAt(info.sheet);
        ExcelResponse<T, V> result = new ExcelResponse<>();
        extractSheet(sheet, result);
        return result;
    }

    protected ExcelResponse<T, V> readCSV(InputStream is) {
        // TODO: Implement later
        throw new RuntimeException("Read CSV is not implemented. Pls try later");
    }

    protected void extractSheet(Sheet sheet, ExcelResponse<T, V> result) {
        Iterator<Row> rowIterator = sheet.rowIterator();

        if (info.startRow > 0) {
            for(int i = 0; i < info.startRow; i++) {
                if (rowIterator.hasNext()) {
                    rowIterator.next();
                }
            }
        }

        // Read data
        while (rowIterator.hasNext()) {
            extractRow(rowIterator, result.getData(), result.getErrors());
        }
    }

    protected void extractRow(Iterator<Row> rowIterator, List<T> data, List<V> errors) {
        Row row = rowIterator.next();
        Iterator<Cell> cellIterator = row.iterator();
        String[] rowData = new String[row.getLastCellNum()];
        Map<String, Exception> rowErrors = new HashMap<>(row.getLastCellNum());

        while (cellIterator.hasNext()) {
            Cell cell = cellIterator.next();
            try {
                rowData[cell.getColumnIndex()] = getValue(cell);
            } catch (Exception ex) {
                String cellAddress = cell.getAddress().formatAsString();
                rowErrors.put(cellAddress, ex);
            }
        }

        try {
            T val = info.dataConverter.convert(rowData);
            if (val != null) {
                data.add(val);
            }
        } catch (Exception ex) {
            LOGGER.warn("Exception", ex);
            String cellAddress = String.valueOf(row.getRowNum() + 1);
            rowErrors.put(cellAddress, ex);
        }

        V error = info.errorConverter.convert(rowErrors);
        if (error != null) {
            errors.add(error);
        }
    }

    private String getValue(Cell cell) {
        cell.setCellType(Cell.CELL_TYPE_STRING);
        String value = cell.getStringCellValue();
//        switch (cell.getCellType()) {
//            case Cell.CELL_TYPE_STRING:
//                value = cell.getStringCellValue();
//                break;
//            case Cell.CELL_TYPE_NUMERIC:
//                value = String.valueOf(cell.getNumericCellValue());
//                break;
//            default:
//                throw new RuntimeException("Un-handle excel type");
//        }
        return value;
    }

    private boolean isExcel(InputStream is) throws IOException {
        return POIXMLDocument.hasOOXMLHeader(is)   // .xlxs
            || POIFSFileSystem.hasPOIFSHeader(is); // .xls
    }
}
