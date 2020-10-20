package com.jcg.struts2.jsp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sashini Tharuka on 10/19/2020.
 */
public class UserDao {

    SessionFactory sf = SessionFactoryUtil.getSessionFactory();
    Session session = sf.openSession();

    public User validate(String username, String password) throws Exception {
        User validateUser=new User();
        try {
            Session session = sf.openSession();
            String hql = "from User as u where u.username=?1 and u.password=?2";
            Query query = session.createQuery(hql);
            query.setParameter(1, username);
            query.setParameter(2,password);
            List userList = query.list();
            if (userList.size() > 0) {
                validateUser= (User) userList.get(0);
                System.out.println(validateUser.getUser_id());
                System.out.println(validateUser.getName());
                session.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validateUser;
    }

    public User saveUser(User user) {
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

    public boolean deleteUser(int user_id) {
        Transaction tran = session.beginTransaction();
        try {
            User user = (User) session.get(User.class, user_id);
            session.delete(user);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tran.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(User user) {
        Transaction tran = session.beginTransaction();
        try {
            session.update(user);
            tran.commit();
            session.close();
            return true;
        } catch (Exception e) {
            tran.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<User> getAllUsers() {
        List<User> users_list = new ArrayList<User>();
        try {
            users_list = session.createQuery("from User").list();
            System.out.println(users_list.size());
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (ArrayList<User>) users_list;
    }

    public User listUserById(int user_id) {
        User user = null;
        try {
            user = (User) session.get(User.class, user_id);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }


}
