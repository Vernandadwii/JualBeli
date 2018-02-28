/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.dao;

import com.vernanda.entity.Transaksi;
import com.vernanda.entity.User;
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
 */
public class TransaksiDaoImpl implements DaoService<Transaksi> {

    @Override
    public int addData(Transaksi object) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "INSERT INTO Transaksi(no_transaksi,pembayaran,User_Id_user)"
                        + "VALUES (?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getNo_transaksi());
                ps.setInt(2, object.getPembayaran());
                ps.setInt(3, object.getUser_Id_user().getIdUser());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiDaoImpl.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public int deleteData(Transaksi object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Transaksi object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaksi> showAllData() {
        ObservableList<Transaksi> transaksi = FXCollections.
                observableArrayList();
        try {
            try (Connection connection = Koneksi.createConnection()) {
                String query
                        = "SELECT t.no_Transaksi, t.pembayaran,t.tgl_transaksi,t.User_Id_user FROM transaksi t JOIN user u ON t.User_Id_user = u.Id_user";
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Transaksi transaksiObject = new Transaksi();
                    transaksiObject.setNo_transaksi(rs.getInt("t.no_Transaksi"));
                    transaksiObject.setPembayaran(rs.getInt("t.pembayaran"));
                    transaksiObject.setTgl_transaksi(rs.getTimestamp(
                            "tgl_transaksi"));
                    User user = new User();
                    user.setIdUser(rs.getInt("t.User_Id_user"));
                    transaksiObject.setUser_Id_user(user);
                    transaksi.add(transaksiObject);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BarangDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

        return transaksi;

    }

    @Override
    public Transaksi getData(Transaksi id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
