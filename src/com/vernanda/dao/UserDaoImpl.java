/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//vernandaDwi(1672001)
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
                        = "INSERT INTO User(id_user,nama,password,j_kelamin,alamat,role_idRole) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdUser());
                ps.setString(2, object.getNama());
                ps.setString(3, object.getPassword());
//                StringProperty p = null;
//                StringProperty l = null;
//                p.setValue("P");
//                l.setValue("L");
//                if (object.getJ_kelamin().equals(p)) {
//                    ps.setInt(3, 1);
//                } else {
//                    ps.setInt(3, 2);
//                }
                ps.setInt(4, object.getjKelamin());
                ps.setString(5, object.getAlamat());
                ps.setInt(6, object.getRole().getIdRole());
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
                String query = "DELETE FROM user WHERE Id_user=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(1, object.getIdUser());
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
                String query
                        = "UPDATE user SET nama=?,password=?,j_kelamin=?,alamat=? role_idRole=? WHERE id_user=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setInt(6, object.getIdUser());
                ps.setString(1, object.getPassword());
                ps.setString(2, object.getNama());
//                StringProperty p = null;
//                StringProperty l = null;
//                p.setValue("P");
//                l.setValue("L");
//                if (object.getJ_kelamin().equals(p)) {
//                    ps.setInt(3, 1);
//                } else {
//                    ps.setInt(3, 2);
//                }
                ps.setInt(3, object.getjKelamin());
                ps.setString(4, object.getAlamat());
                ps.setInt(5, object.getRole().getIdRole());
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
                        = "SELECT u.id_user,u.password,u.nama,u.j_kelamin, u.alamat, u.role_idRole, r.Keterangan FROM user u JOIN role r WHERE u.role_idRole = r.idRole";
                PreparedStatement ps = connection.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setIdUser(rs.getInt("id_user"));
                    user.setNama(rs.getString("nama"));
                    user.setPassword(rs.getString("password"));
//                    StringProperty jenis = null;
//                    if (rs.getInt("j_kelamin") == 1) {
                    user.setjKelamin(rs.getInt("j_kelamin"));
//                        setValue("P");
//                    } else {
//                        jenis.setValue("L");
//                    }
//                    user.setJ_kelamin(jenis);
                    user.setAlamat(rs.getString("alamat"));
                    Role role = new Role();
                    role.setIdRole(rs.getInt("u.Role_idRole"));
                    role.setKeterangan(rs.getString("r.Keterangan"));
                    user.setRole(role);
                    users.add(user);
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
                    = "SELECT Id_user,nama,password,Role_idRole FROM User u join Role r on u.Role_idRole=r.idRole WHERE u.Id_user=? AND u.password=?";
            PreparedStatement ps = connection.prepareStatement(querry);
            ps.setInt(1, id.getIdUser());
            ps.setString(2, id.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt("u.Id_user"));
                user.setNama(rs.getString("u.nama"));
                user.setPassword(rs.getString("u.password"));
                // user.setRole_idRole(rs.get);
                Role userRole = new Role();
                userRole.setIdRole(rs.getInt("u.Role_idRole"));

                user.setRole(userRole);
                return user;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
