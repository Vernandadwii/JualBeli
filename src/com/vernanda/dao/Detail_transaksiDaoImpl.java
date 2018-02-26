/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.dao;

import com.vernanda.entity.Detail_transaksi;
import com.vernanda.utility.DaoService;
import com.vernanda.utility.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nama : Vernanda dwi (1672001)
 */
public class Detail_transaksiDaoImpl implements DaoService<Detail_transaksi> {

    @Override
    public int addData(Detail_transaksi object) {

        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "INSERT INTO Detail_transaksi(transaksi_no_transaksi,barang_Kd_barang,jumlah,saling_price)"
                        + "VALUES (?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getTransaksi_No_transaksi().
                        getNo_transaksi());
                ps.setInt(2, object.getBarang_Kd_barang().getKd_barang());
                ps.setInt(3, object.getJumlah());
                ps.setInt(4, object.getSaling_price());
                if (ps.executeUpdate() != 0) {
                    connection.commit();
                    result = 1;
                } else {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Detail_transaksiDaoImpl.class.getName()).
                        log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return result;
    }

    @Override
    public int deleteData(Detail_transaksi object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(Detail_transaksi object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Detail_transaksi> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detail_transaksi getData(Detail_transaksi id) {
//        try (Connection connection = Koneksi.createConnection()) {
//            connection.setAutoCommit(false);
//            String querry
//                    = "SELECT t.transaksi_no_transaksi,b.barang_Kd_barang,d.jumlah,d.saling_price FROM  t join Role r on u.Role_idRole=r.Role_idRole";
//            PreparedStatement ps = connection.prepareStatement(querry);
//            ps.setString(1, id.getTransaksi_No_transaksi());
////            ps.setString(2, id.getBarang_Kd_barang());
//            ps.setInt(3, id.getJumlah());
//            ps.setInt(4, id.getSaling_price());
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                Detail_transaksi detailtrans = new Detail_transaksi();
//                detailtrans.setTransaksi_No_transaksi(rs.getString(
//                        "t.transaksi_no_transaksi"));
//////                //                detailtrans.setBarang_Kd_barang(rs.getString(
//////                "b.barang_Kd_barang"
////                ));
//                detailtrans.setJumlah(rs.getInt("d.jumlah"));
//                detailtrans.setSaling_price(rs.getInt("d.saling_price"));
//
//                // user.setRole_idRole(rs.get);
//                return detailtrans;
//            }
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(UserDaoImpl.class.getName()).
//                    log(Level.SEVERE, null, ex);
//        }
//        return null;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
