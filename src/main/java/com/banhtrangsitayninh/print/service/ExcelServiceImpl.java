package com.banhtrangsitayninh.print.service;

import com.banhtrangsitayninh.print.domain.Order;
import com.banhtrangsitayninh.print.parser.ExcelError;
import com.banhtrangsitayninh.print.parser.ExcelReader;
import com.banhtrangsitayninh.print.parser.ExcelResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by tuyenhx on 7/31/16.
 */
@Service
public class ExcelServiceImpl implements ExcelService {
    private ExcelReader<Order, ExcelError> reader;

    public ExcelServiceImpl() {
        setUp();
    }

    @Override
    public List<Order> parse(InputStream in) {
        try {

            ExcelResponse<Order, ExcelError> parsed = reader.read(in);
            return parsed
                    .getData()
                    .stream()
                    .filter(item ->
                            !(StringUtils.isEmpty(item.getFullName()) && StringUtils.isEmpty(item.getPhoneNumber())))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }

    private void setUp() {
        reader = ExcelReader.builder(Order.class, ExcelError.class)
                .setStartRow(2)
                .dataConverter(buildDataConverter())
                .errorConverter(buildErrorConverter())
                .build();
    }

    private ExcelReader.RowConverter<Order> buildDataConverter() {
        return (String[] row) -> {
            Order order = new Order();
            order.setFacebook(row[1]);
            order.setFullName(row[2]);
            order.setPhoneNumber(row[3]);
            order.setAddress(row[4]);
            order.setLogisticProvider(row[5]);
            order.setPaymentMethod(row[6]);
            order.setPaymentStatus(row[7]);
            order.setOrderStatus(row[8]);
            order.setDescription(row[9]);
            order.setMe(row[10]);
            order.setMuoiDau(row[11]);
            order.setTronTac(row[12]);
            order.setSateTac(row[13]);
            order.setSateToi(row[14]);
            order.setBo(row[15]);
            order.setDeoCay(row[16]);
            order.setDeoTom(row[17]);
            order.setDeoMe(row[18]);
            order.setMuoiTom(row[19]);
            order.setMuoiChay(row[20]);
            order.setPhoiSuong(row[21]);
            order.setBanhTrangChuoi(row[22]);
            order.setPhoiSuongMan(row[23]);
            order.setTronMuoiOt(row[24]);
            order.setVoMuoiNhuyen(row[25]);
            order.setChaBong(row[26]);
            order.setOngTom(row[27]);
            order.setVoToiOt(row[28]);
            order.setBanhTrangVuong(row[29]);
            order.setBanhTrangVung(row[30]);
            order.setChumRuot(row[31]);
            order.setMutMe(row[32]);
            order.setKhoGa(row[33]);
            order.setAdditionalFee(row[34]);
            order.setShippingFee(row[35]);
            order.setDiscount(row[36]);
            order.setTotal(row[37]);
            order.setDescriptionRight(getValue(row, 38));
            return order;
        };
    }

    private ExcelReader.ErrorConverter<ExcelError> buildErrorConverter() {
        return (Map<String, Exception> errorData) -> {

            if (!errorData.isEmpty()) {
                ExcelError error = new ExcelError();
                for (Map.Entry<String, Exception> entry : errorData.entrySet()) {
                    error.setCell(entry.getKey());
                    error.getMessage().add(entry.getValue().getMessage()); // NullPointerException maybe here
                    entry.getValue().printStackTrace();
                    return error;
                }
            }

            return null;
        };
    }

    private String getValue(String[] array, int index) {
        try {
            return array[index];
        } catch (ArrayIndexOutOfBoundsException ex) {
            return "";
        }
    }
}
