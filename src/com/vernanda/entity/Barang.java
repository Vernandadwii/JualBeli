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
public class Barang {

    private final IntegerProperty Kd_barang = new SimpleIntegerProperty();

    public int getKd_barang() {
        return Kd_barang.get();
    }

    public void setKd_barang(int value) {
        Kd_barang.set(value);
    }

    public IntegerProperty Kd_barangProperty() {
        return Kd_barang;
    }
    private final IntegerProperty harga = new SimpleIntegerProperty();

    public int getHarga() {
        return harga.get();
    }

    public void setHarga(int value) {
        harga.set(value);
    }

    public IntegerProperty hargaProperty() {
        return harga;
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

//    int Kd_barang;
//    String nama_brng;
//    int harga;
//    int jumlah;
//
//    public int getKd_barang() {
//        return Kd_barang;
//    }
//
//    public String getNama_brng() {
//        return nama_brng;
//    }
//
//    public int getHarga() {
//        return harga;
//    }
//
//    public int getJumlah() {
//        return jumlah;
//    }
//
//    public void setKd_barang(int Kd_barang) {
//        this.Kd_barang = Kd_barang;
//    }
//
//    public void setNama_brng(String nama_brng) {
//        this.nama_brng = nama_brng;
//    }
//
//    public void setHarga(int harga) {
//        this.harga = harga;
//    }
//
//    public void setJumlah(int jumlah) {
//        this.jumlah = jumlah;
//    }
//
//    public boolean isRecommended() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public Object getCategory() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    private final StringProperty nama_brng = new SimpleStringProperty();

    public String getNama_brng() {
        return nama_brng.get();
    }

    public void setNama_brng(String value) {
        nama_brng.set(value);
    }

    public StringProperty nama_brngProperty() {
        return nama_brng;
    }
}
