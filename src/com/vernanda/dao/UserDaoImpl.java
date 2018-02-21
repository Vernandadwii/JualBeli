/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vernanda.dao;

import com.vernanda.entity.Role;
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
public class UserDaoImpl implements DaoService<User> {

    @Override
    public int addData(User object) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query
                        = "INSERT INTO User(Id_user,password,nama,j_kelamin,alamat,Role_idRole) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getId_user());
                ps.setString(2, object.getPassword());
                ps.setString(3, object.getNama());
                ps.setInt(4, object.getJ_kelamin());
                ps.setString(5, object.getAlamat());

                ps.setInt(5, object.getRole_idRole().getIdRole());
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
    public int deleteData(User object) {
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query = "DELETE FROM barang WHERE id=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getId_user());
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
    public int updateData(User object) {
        Timestamp t = new Timestamp(System.currentTimeMillis());
        int result = 0;
        try {
            try (Connection connection = Koneksi.createConnection()) {
                connection.setAutoCommit(false);
                String query = "UPDATE user SET Nama=?,Password=?,Username=?,,"
                        + "recomended=?,created=?,category_id=? WHERE id=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getId_user());
                ps.setString(2, object.getPassword());
                ps.setString(3, object.getNama());
                ps.setInt(4, object.getJ_kelamin());
                ps.setString(5, object.getAlamat());
                ps.setInt(6, object.getRole_idRole().getIdRole());
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
    public List<User> showAllData() {
        ObservableList<User> users = FXCollections.observableArrayList();
        try {
            try (Connection connection = Koneksi.createConnection()) {
                String query
                        = "SELECT Id_user,password,nama,j_kelamin, alamat FROM user u JOIN role r  where u.Role_idRole = r.idRole";
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    User cat = new User();
                    cat.setId_user(rs.getInt("Id_user"));
                    cat.setPassword(rs.getString("password"));
                    cat.setNama(rs.getString("nama"));
                    cat.setJ_kelamin(rs.getInt("j_kelamin"));
                    cat.setAlamat(rs.getString("alamat"));

                    users.add(cat);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return users;
    }

    @Override
    public User getData(User id) {
        try (Connection connection = Koneksi.createConnection()) {
            connection.setAutoCommit(false);
            String querry
                    = "SELECT Id_user,password,idRole FROM User u join Role r on u.Role_idRole=r.idRole WHERE u.Id_user=? AND u.password=?";
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.setInt(1, id.getId_user());
            ps.setString(2, id.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setId_user(rs.getInt("Id_user"));
                user.setPassword(rs.getString("password"));
                // user.setRole_idRole(rs.get);
                Role userRole = new Role();
                userRole.setIdRole(rs.getInt("idRole"));

                user.setRole_idRole(userRole);
                return user;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
