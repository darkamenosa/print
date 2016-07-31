package com.banhtrangsitayninh.print.domain;


import java.io.Serializable;

/**
 * Created by tuyenhx on 7/31/16.
 */
public class Order implements Serializable {

    // General information
    private String facebook;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String logisticProvider;
    private String paymentMethod;
    private String paymentStatus;
    private String orderStatus;
    private String description;

    // Product quantity
    private String me;
    private String muoiDau;
    private String tronTac;
    private String sateTac;
    private String sateToi;
    private String bo;
    private String deoCay;
    private String deoTom;
    private String deoMe;
    private String muoiTom;
    private String muoiChay;
    private String phoiSuong;
    private String banhTrangChuoi;
    private String phoiSuongMan;
    private String tronMuoiOt;
    private String xauCuon;
    private String chaBong;
    private String ongTom;
    private String voToiOt;
    private String banhTrangVuong;
    private String banhTrangVung;
    private String chumRuot;
    private String mutMe;

    // Fees
    private String additionalFee;
    private String shippingFee;
    private String discount;
    private String total;


    // Getters and setters
    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogisticProvider() {
        return logisticProvider;
    }

    public void setLogisticProvider(String logisticProvider) {
        this.logisticProvider = logisticProvider;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMe() {
        return me;
    }

    public void setMe(String me) {
        this.me = me;
    }

    public String getMuoiDau() {
        return muoiDau;
    }

    public void setMuoiDau(String muoiDau) {
        this.muoiDau = muoiDau;
    }

    public String getTronTac() {
        return tronTac;
    }

    public void setTronTac(String tronTac) {
        this.tronTac = tronTac;
    }

    public String getSateTac() {
        return sateTac;
    }

    public void setSateTac(String sateTac) {
        this.sateTac = sateTac;
    }

    public String getSateToi() {
        return sateToi;
    }

    public void setSateToi(String sateToi) {
        this.sateToi = sateToi;
    }

    public String getBo() {
        return bo;
    }

    public void setBo(String bo) {
        this.bo = bo;
    }

    public String getDeoCay() {
        return deoCay;
    }

    public void setDeoCay(String deoCay) {
        this.deoCay = deoCay;
    }

    public String getDeoTom() {
        return deoTom;
    }

    public void setDeoTom(String deoTom) {
        this.deoTom = deoTom;
    }

    public String getDeoMe() {
        return deoMe;
    }

    public void setDeoMe(String deoMe) {
        this.deoMe = deoMe;
    }

    public String getMuoiTom() {
        return muoiTom;
    }

    public void setMuoiTom(String muoiTom) {
        this.muoiTom = muoiTom;
    }

    public String getMuoiChay() {
        return muoiChay;
    }

    public void setMuoiChay(String muoiChay) {
        this.muoiChay = muoiChay;
    }

    public String getPhoiSuong() {
        return phoiSuong;
    }

    public void setPhoiSuong(String phoiSuong) {
        this.phoiSuong = phoiSuong;
    }

    public String getBanhTrangChuoi() {
        return banhTrangChuoi;
    }

    public void setBanhTrangChuoi(String banhTrangChuoi) {
        this.banhTrangChuoi = banhTrangChuoi;
    }

    public String getPhoiSuongMan() {
        return phoiSuongMan;
    }

    public void setPhoiSuongMan(String phoiSuongMan) {
        this.phoiSuongMan = phoiSuongMan;
    }

    public String getTronMuoiOt() {
        return tronMuoiOt;
    }

    public void setTronMuoiOt(String tronMuoiOt) {
        this.tronMuoiOt = tronMuoiOt;
    }

    public String getXauCuon() {
        return xauCuon;
    }

    public void setXauCuon(String xauCuon) {
        this.xauCuon = xauCuon;
    }

    public String getChaBong() {
        return chaBong;
    }

    public void setChaBong(String chaBong) {
        this.chaBong = chaBong;
    }

    public String getOngTom() {
        return ongTom;
    }

    public void setOngTom(String ongTom) {
        this.ongTom = ongTom;
    }

    public String getVoToiOt() {
        return voToiOt;
    }

    public void setVoToiOt(String voToiOt) {
        this.voToiOt = voToiOt;
    }

    public String getBanhTrangVuong() {
        return banhTrangVuong;
    }

    public void setBanhTrangVuong(String banhTrangVuong) {
        this.banhTrangVuong = banhTrangVuong;
    }

    public String getBanhTrangVung() {
        return banhTrangVung;
    }

    public void setBanhTrangVung(String banhTrangVung) {
        this.banhTrangVung = banhTrangVung;
    }

    public String getChumRuot() {
        return chumRuot;
    }

    public void setChumRuot(String chumRuot) {
        this.chumRuot = chumRuot;
    }

    public String getAdditionalFee() {
        return additionalFee;
    }

    public void setAdditionalFee(String additionalFee) {
        this.additionalFee = additionalFee;
    }

    public String getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(String shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMutMe() {
        return mutMe;
    }

    public Order setMutMe(String mutMe) {
        this.mutMe = mutMe;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "facebook='" + facebook + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", logisticProvider='" + logisticProvider + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", description='" + description + '\'' +
                ", me='" + me + '\'' +
                ", muoiDau='" + muoiDau + '\'' +
                ", tronTac='" + tronTac + '\'' +
                ", sateTac='" + sateTac + '\'' +
                ", sateToi='" + sateToi + '\'' +
                ", bo='" + bo + '\'' +
                ", deoCay='" + deoCay + '\'' +
                ", deoTom='" + deoTom + '\'' +
                ", deoMe='" + deoMe + '\'' +
                ", muoiTom='" + muoiTom + '\'' +
                ", muoiChay='" + muoiChay + '\'' +
                ", phoiSuong='" + phoiSuong + '\'' +
                ", banhTrangChuoi='" + banhTrangChuoi + '\'' +
                ", phoiSuongMan='" + phoiSuongMan + '\'' +
                ", tronMuoiOt='" + tronMuoiOt + '\'' +
                ", xauCuon='" + xauCuon + '\'' +
                ", chaBong='" + chaBong + '\'' +
                ", ongTom='" + ongTom + '\'' +
                ", voToiOt='" + voToiOt + '\'' +
                ", banhTrangVuong='" + banhTrangVuong + '\'' +
                ", banhTrangVung='" + banhTrangVung + '\'' +
                ", chumRuot='" + chumRuot + '\'' +
                ", additionalFee='" + additionalFee + '\'' +
                ", shippingFee='" + shippingFee + '\'' +
                ", discount='" + discount + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
