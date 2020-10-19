package com.jcg.struts2.jsp;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sashini Tharuka on 10/19/2020.
 */
public class UserAction extends ActionSupport{

    private String name,username,user_role,userpass,message;
    private int user_id;

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getMessage() { return message; }

    private User user;
    private ArrayList<User> userList= new ArrayList<User>();
    private UserDao userDAO = new UserDao();


    public String saveUser(){
        user= new User();
        user.setUsername(username);
        user.setPassword(userpass);
        user.setName(name);
        user.setUser_role(user_role);
        if(userDAO.saveUser(user) !=null){
            message="User Successfuly Registerd";
            return "success";
        }else{
            message="Something went wrong.User not Regigistered";
            return "error";
        }
    }
    public String viewUserDetails()
    {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        user = userDAO.listUserById(Integer.parseInt(request.getParameter("user_id")));
        return SUCCESS;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
}
