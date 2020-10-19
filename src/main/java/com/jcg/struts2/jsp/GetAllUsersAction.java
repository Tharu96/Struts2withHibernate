package com.jcg.struts2.jsp;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Sashini Tharuka on 10/14/2020.
 */
public class GetAllUsersAction extends ActionSupport {
    private List<User> users_list;

    public List<User> getUsers_list() {
        return users_list;
    }

    public String execute() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();

        UserDao userDao=new UserDao();
        users_list=userDao.getAllUsers();
        String s = (String) session.getAttribute("login");
        if (s != null && !s.equals("")) {
            return "success";
        } else {
            return "error";
        }

    }
}
