/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import bean.User;
import java.util.List;

/**
 *
 * @author ITS
 */
public interface UserDaoInter {
    
    public List<User>getAll();
    public User getById(int id);

     public boolean  updateUser(User u);
     
     
     public boolean removeUser(int id);
}
            