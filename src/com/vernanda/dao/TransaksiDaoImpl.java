/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.dao;

import com.vernanda.entity.Transaksi;
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
                        = "INSERT INTO Transaksi(no_transaksi,tgl_transaksi,pembayaran,User_Id_user)"
                        + "VALUES (?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, object.getNo_transaksi());
                ps.setTimestamp(2, object.getTgl_transaksi());
                ps.setInt(3, object.getPembayaran());
                ps.setInt(4, object.getUser_Id_user());
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
    public int deleteData(Transaksi object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Transaksi object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaksi> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @Override
    public Transaksi getData(Transaksi id) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        try (Connection connection = Koneksi.createConnection()) {
            connection.setAutoCommit(false);
            String querry
                    = "SELECT t.no_transaksi,t.tgl_transaksi,t.harga,u.User_Id_user FROM transaksi t join Role r on u.Role_idRole=r.Role_idRole";
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.setString(1, id.getNo_transaksi());
            ps.setTimestamp(2, t);
            ps.setDouble(3, id.getPembayaran());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setNo_transaksi(rs.getString("t.no_transaksi"));

                transaksi.setPembayaran(rs.getInt("t.t.harga"));

                // user.setRole_idRole(rs.get);
                return transaksi;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
