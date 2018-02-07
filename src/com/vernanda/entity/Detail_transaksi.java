/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.entity;

/**
 *
 * @author AsusPC
 */
public class Detail_transaksi {

    String Transaksi_No_trnsaksi;
    String Barang_Kd_barang;
    int Jumlah;
    Double HargaJual;

    public String getTransaksi_No_trnsaksi() {
        return Transaksi_No_trnsaksi;
    }

    public String getBarang_Kd_barang() {
        return Barang_Kd_barang;
    }

    public int getJumlah() {
        return Jumlah;
    }

    public Double getHargaJual() {
        return HargaJual;
    }

    public void setTransaksi_No_trnsaksi(String Transaksi_No_trnsaksi) {
        this.Transaksi_No_trnsaksi = Transaksi_No_trnsaksi;
    }

    public void setBarang_Kd_barang(String Barang_Kd_barang) {
        this.Barang_Kd_barang = Barang_Kd_barang;
    }

    public void setJumlah(int Jumlah) {
        this.Jumlah = Jumlah;
    }

    public void setHargaJual(Double HargaJual) {
        this.HargaJual = HargaJual;
    }

}
