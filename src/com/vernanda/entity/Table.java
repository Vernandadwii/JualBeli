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
public class Table {

    private final IntegerProperty Kd_barang = new SimpleIntegerProperty();
    private final StringProperty nama_brng = new SimpleStringProperty();
    private final IntegerProperty saling_price = new SimpleIntegerProperty();
    private final IntegerProperty jumlah = new SimpleIntegerProperty();

    public Table() {

    }

    public Table(int Kd_barang, String nama_brng, int saling_price, int jumlah) {
        this.setKd_barang(Kd_barang);
        this.setNama_brng(nama_brng);
        this.setSaling_price(saling_price);
        this.setJumlah(jumlah);
    }

    //Kd_barang
    public int getKd_barang() {
        return Kd_barang.get();
    }

    public void setKd_barang(int value) {
        Kd_barang.set(value);
    }

    public IntegerProperty Kd_barangProperty() {
        return Kd_barang;
    }

    //nama_brng
    public String getNama_brng() {
        return nama_brng.get();
    }

    public void setNama_brng(String value) {
        nama_brng.set(value);
    }

    public StringProperty nama_brngProperty() {
        return nama_brng;
    }

    //saling_price
    public int getSaling_price() {
        return saling_price.get();
    }

    public void setSaling_price(int value) {
        saling_price.set(value);
    }

    public IntegerProperty saling_priceProperty() {
        return saling_price;
    }

    //jumlah
    public int getJumlah() {
        return jumlah.get();
    }

    public void setJumlah(int value) {
        jumlah.set(value);
    }

    public IntegerProperty jumlahProperty() {
        return jumlah;
    }

    @Override
    public String toString() {
        return String.valueOf(getKd_barang()) + "-" + getNama_brng();
    }

}
