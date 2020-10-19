package com.jcg.struts2.jsp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sashini Tharuka on 10/19/2020.
 */
public class UserDao {

    SessionFactory sf = new Configuration().configure(
            new File("G:\\maven testing\\New folder\\Struts2Jsp\\src\\main\\resources\\hibernate.cfg.xml"))
            .buildSessionFactory();


    public static ResultSet validate(String username, String userpass) throws Exception {
        boolean status = false;
        try {
            String URL = "jdbc:mysql://localhost/struts";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, "root", "ijse");

            PreparedStatement ps = con.prepareStatement(
                    "select * from User where userName=? and password=?");
            ps.setString(1, username);
            ps.setString(2, userpass);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            System.out.println(status);
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User saveUser(User user) {
        Session session = sf.openSession();
        Transaction tran = session.beginTransaction();
        try {

            session.save(user);
            session.flush();
            tran.commit();
            session.close();
            return user;
        } catch (RuntimeException e) {
            tran.rollback();
            throw e;
        }
    }

    public ArrayList<User> getAllUsers() {
        Session session= sf.openSession();
        List<User> users_list=new ArrayList<User>();
        try {
            users_list=session.createQuery("from User").list();
            System.out.println(users_list.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<User>) users_list;
    }
    public User listUserById(int user_id) {
        Session session= sf.openSession();
        User user = null;
        try {
            user = (User) session.get(User.class, user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


}
