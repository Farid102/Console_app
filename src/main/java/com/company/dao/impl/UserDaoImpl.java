/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;

import Dao.UserDaoInter;
import Dao.interDAO;
import bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ITS
 */
public class UserDaoImpl extends interDAO implements UserDaoInter {

    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect();) {

            Statement stmt = c.createStatement();
            stmt.execute("SELECT * FROM user1");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");

                result.add(new User(id, name, surname, phone, email));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    @Override

    public boolean updateUser(User u) {
        try (Connection c = connect();) {
            PreparedStatement stmt = c.prepareStatement("UPDATE USER SET NAME=?, SURNAME=?, PHONE=?, EMAIL=? WHERE id=?");
            stmt.setString(1, u.getName());
            stmt.setString(2, u.getSurname());
            stmt.setString(3, u.getPhone());
            stmt.setString(4, u.getEmail());
            stmt.setInt(5, u.getId());
            return stmt.executeUpdate()>0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
public boolean removeUser(int id) {
    try (Connection c = connect();) {
        PreparedStatement stmt = c.prepareStatement("DELETE FROM user WHERE id=?");
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
    } catch (Exception ex) {
        ex.printStackTrace();
        return false;
    }
}


   @Override
public User getById(int userId) {
    User result = new User();
    try (Connection c = connect();) {
        PreparedStatement stmt = c.prepareStatement("SELECT * FROM user WHERE id=?");
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String surname = rs.getString("surname");
            String email = rs.getString("email");
            String phone = rs.getString("phone");

            result = new User(id, name, surname, phone, email);
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
    return result;
}

}
