package controllers;

import models.User;
import models.UserDAO;
import utils.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class UserController extends HttpServlet {

    DBConnection dbConnection = DBConnection.getInstance();
    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO(dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userDAO.getByUsername(username);

        if (user.getPassword().equals(password)) {

            HttpSession session = req.getSession();
            session.setAttribute("IS_LOGGINED", true);
            session.setAttribute("ROLE", user.getRole());

            resp.sendRedirect("/customers?command=list");

        } else {

            // thong bao loi dang nhap

            req.setAttribute("message", "Đăng nhập không thành công");
            RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
            dispatcher.forward(req, resp);
        }

    }
}
