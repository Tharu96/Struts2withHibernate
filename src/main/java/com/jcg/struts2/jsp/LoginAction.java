package com.jcg.struts2.jsp;

import java.sql.ResultSet;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 * @author Sashini Tharuka on 10/14/2020.
 */
public class LoginAction extends ActionSupport implements SessionAware {

    private String username, userpass;
    private User user;
    SessionMap<String, String> sessionmap;
    ResultSet rs = null;


    public User getUser() {
        return user;
    }

    public String execute() throws Exception {
        try {
            rs = UserDao.validate(username, userpass);
            if (rs != null) {
                user = new User();
                user.setUser_id(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
                user.setName(rs.getString(4));
            }
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }


    public void setSession(Map map) {
        sessionmap = (SessionMap) map;
        sessionmap.put("login", "true");
    }

    public String logout() {
        sessionmap.invalidate();
        return "success";
    }


}

