package com.company.mavenproject2;

import Dao.UserDaoInter;
import bean.User;
import com.company.dao.impl.UserDaoImpl;
import java.util.List;

/**
 *
 * @author ITS
 */
public class Main {

    public static void main(String[] args) throws Exception {
        UserDaoInter userDao = new UserDaoImpl();
//        List<User> list = userDao.getAll();
//        userDao.removeUser(1);
//        List<User> list2 = userDao.getAll();
//
//        System.out.println("list=" + list);
//        System.out.println("list2=" + list2);

        User u = userDao.getById(2);
        u.setName("Farid");
        userDao.updateUser(u);


//        u.setId(1);
//        u.setName("AZAT'DELETE FROM USER;SELECT'");
//        userDao.updateUser(u);

    }

}
