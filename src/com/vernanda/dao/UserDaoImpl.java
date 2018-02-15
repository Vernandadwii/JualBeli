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
                        = "INSERT INTO User(Id_user,nama,username,password,Role_idRole)"
                        + "VALUES (?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getId_user());
                ps.setString(2, object.getNama());
                ps.setInt(3, object.getUsername());
                ps.setString(4, object.getPassword());
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
                String query = "UPDATE user SET Nama=?,Username=?,Password=?,"
                        + "recomended=?,created=?,category_id=? WHERE id=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getId_user());
                ps.setString(2, object.getNama());
                ps.setInt(3, object.getUsername());
                ps.setString(4, object.getPassword());
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
    public List<User> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                user.setId_user(rs.getInt("u.Id_user"));
                user.setPassword(rs.getString("u.Password"));
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
