/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.entity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author AsusPC
 */
public class Detail_transaksi {

    private final StringProperty transaksi_No_transaksi
            = new SimpleStringProperty();

    public String getTransaksi_No_transaksi() {
        return transaksi_No_transaksi.get();
    }

    public void setTransaksi_No_transaksi(String value) {
        transaksi_No_transaksi.set(value);
    }

    public StringProperty transaksi_No_transaksiProperty() {
        return transaksi_No_transaksi;
    }
    private final IntegerProperty jumlah = new SimpleIntegerProperty();

    public int getJumlah() {
        return jumlah.get();
    }

    public void setJumlah(int value) {
        jumlah.set(value);
    }

    public IntegerProperty jumlahProperty() {
        return jumlah;
    }
    private final IntegerProperty saling_price = new SimpleIntegerProperty();

    public int getSaling_price() {
        return saling_price.get();
    }

    public void setSaling_price(int value) {
        saling_price.set(value);
    }

    public IntegerProperty saling_priceProperty() {
        return saling_price;
    }

//    String transaksi_No_trnsaksi;
//    String barang_Kd_barang;
//    int jumlah;
//    int saling_price;
//
//    public String getTransaksi_No_trnsaksi() {
//        return transaksi_No_trnsaksi;
//    }
//
//    public String getBarang_Kd_barang() {
//        return barang_Kd_barang;
//    }
//
//    public int getJumlah() {
//        return jumlah;
//    }
//
//    public int getSaling_price() {
//        return saling_price;
//    }
//
//    public void setTransaksi_No_trnsaksi(String Transaksi_No_trnsaksi) {
//        this.transaksi_No_trnsaksi = Transaksi_No_trnsaksi;
//    }
//
//    public void setBarang_Kd_barang(String Barang_Kd_barang) {
//        this.barang_Kd_barang = Barang_Kd_barang;
//    }
//
//    public void setJumlah(int Jumlah) {
//        this.jumlah = Jumlah;
//    }
//
//    public void setSaling_price(int saling_price) {
//        this.saling_price = saling_price;
//    }
    private final StringProperty barang_Kd_barang = new SimpleStringProperty();

    public String getBarang_Kd_barang() {
        return barang_Kd_barang.get();
    }

    public void setBarang_Kd_barang(String value) {
        barang_Kd_barang.set(value);
    }

    public StringProperty barang_Kd_barangProperty() {
        return barang_Kd_barang;
    }

}
