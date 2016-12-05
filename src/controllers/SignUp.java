package controllers;

import models.ManageUser;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Hessam! on 05.12.2016.
 */
@WebServlet("/registration")
public class SignUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ManageUser manageUser = new ManageUser((SessionFactory) getServletContext().getAttribute("sessionfactoryobj"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        Integer age = Integer.valueOf(request.getParameter("age"));
        //Insert user to database
        Integer id = manageUser.addUser(username,password,"customer",phone,email,age);
        if (id == 1)
        {

        }
        else {
            System.out.println("Some Error!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
