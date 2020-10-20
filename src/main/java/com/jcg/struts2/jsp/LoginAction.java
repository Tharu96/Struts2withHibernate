package com.jcg.struts2.jsp;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 * @author Sashini Tharuka on 10/14/2020.
 */
public class LoginAction extends ActionSupport implements SessionAware {

    private String username,password,message;
    private User user;
    SessionMap<String, String> sessionmap;
    private UserDao userDao= new UserDao();

    public String execute() throws Exception{
        try {
            user=userDao.validate(username,password);
            if (user!=null) {
                message="Successfully Login";
            }
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            message="Username or Password Incorrect";
            return "error";
        }
    }

    public String logout() {
        sessionmap.invalidate();
        return "success";
    }

    public void setSession(Map map) {
        sessionmap = (SessionMap) map;
        sessionmap.put("login", "true");
    }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public User getUser() { return user; }

}

