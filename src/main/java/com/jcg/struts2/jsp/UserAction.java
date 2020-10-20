package com.jcg.struts2.jsp;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sashini Tharuka on 10/19/2020.
 */
public class UserAction extends ActionSupport {

    private String name, username, user_role, password, message;
    private int user_id;
    private User user;
    private List<User> users_list;
    private UserDao userDAO = new UserDao();




    public String saveUser() {
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setUser_role(user_role);
        if (userDAO.saveUser(user) != null) {
            message = "User Successfully Registered";
            return "success";
        } else {
            message = "Something went wrong.User not Registered";
            return "error";
        }
    }

    public String viewUserDetails() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        user = userDAO.listUserById(Integer.parseInt(request.getParameter("user_id")));
        setUser_id(user.getUser_id());
        setUsername(user.getUsername());
        setPassword(user.getPassword());
        setName(user.getName());
        setUser_role(user.getUser_role());
        return "success";
    }

    public String deleteUser() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (userDAO.deleteUser(Integer.parseInt(request.getParameter("user_id")))) {
            message = "User Removed from System Successfully";
        }
        return "success";
    }

    public String updateUser() {
        user = new User();
        user.setUser_id(user_id);
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setUser_role(user_role);

        if (userDAO.updateUser(user)) {
            message = "User Successfully Updated";
        }
        return "success";
    }

    public String getAllUsers() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();

        UserDao userDao = new UserDao();
        users_list = userDao.getAllUsers();
        String s = (String) session.getAttribute("login");
        if (s != null && !s.equals("")) {
            return "success";
        } else {
            return "error";
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUser_id(int user_id) { this.user_id = user_id; }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() { return message; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public List<User> getUsers_list() {
        return users_list;
    }

}
