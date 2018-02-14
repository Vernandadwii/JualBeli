/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.dao;

import com.vernanda.entity.Barang;
import com.vernanda.utility.DaoService;
import com.vernanda.utility.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Nama : Vernanda dwi (1672001)
 *
 */
public class BarangDaoImpl implements DaoService<Barang> {

    @Override
    public int addData(Barang object) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "INSERT INTO Barang(Kd_barang,Nama_brng,harga,jumlah)"
                        + "VALUES (?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getKd_barang());
                ps.setString(2, object.getNama_brng());
                ps.setDouble(3, object.getJumlah());
                ps.setInt(4, object.getJumlah());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return result;

    }

    @Override
    public int deleteData(Barang object) {
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query = "DELETE FROM barang WHERE id=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getKd_barang());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public int updateData(Barang object) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query = "";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getKd_barang());
                ps.setString(2, object.getNama_brng());
                ps.setInt(3, object.getHarga());
                ps.setInt(4, object.getJumlah());

                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public List<Barang> showAllData() {
        ObservableList<Barang> barangs = FXCollections.observableArrayList();
        try {
            try (Connection connection = Koneksi.createConnection()) {
                String query
                        = "SELECT Kd_Barang, nama_brng, harga, jumlah FROM Barang ";
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Barang cat = new Barang();
                    cat.setKd_barang(rs.getInt("Kd_barang"));
                    cat.setNama_brng(rs.getString("nama_brng"));
                    cat.setHarga(rs.getInt("harga"));
                    cat.setJumlah(rs.getInt("jumlah"));
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return barangs;
    }

    @Override
    public Barang getData(Barang id) {
        try (Connection connection = Koneksi.createConnection()) {
            connection.setAutoCommit(false);
            String querry
                    = "SELECT Kd_barang,nama_brng,harga,jumlah FROM transaksi barang";
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.setInt(1, id.getKd_barang());
            ps.setString(2, id.getNama_brng());
            ps.setInt(3, id.getHarga());
            ps.setInt(4, id.getJumlah());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Barang barang = new Barang();
                barang.setKd_barang(rs.getInt("Kd_barang"));
                barang.setNama_brng(rs.getString("nama_brng"));
                barang.setHarga(rs.getInt("harga"));
                barang.setJumlah(rs.getInt("jumlah"));

                // user.setRole_idRole(rs.get);
                return barang;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
