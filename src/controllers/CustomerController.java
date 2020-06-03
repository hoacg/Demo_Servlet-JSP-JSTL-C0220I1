package controllers;

import models.CustomerDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/customers")
public class CustomerController extends HttpServlet {

    private CustomerDAO customerDAO = CustomerDAO.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("command");
        doAction(action, req, resp);
    }


    private void doAction(String action, HttpServletRequest req, HttpServletResponse resp) {

        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "list":
                    getList(req, resp);
                    break;
                case "get-form":
                    getForm(req, resp);
                    break;
                case "delete":
                    String idParam = req.getParameter("id");

                    int id = Integer.parseInt(idParam);
                    deleteById(id, req, resp);
                    break;
                default:
                    PrintWriter writer = resp.getWriter();
                    writer.print("Cung cap action truoc khi thuc hien");
            }

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteById(int id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            customerDAO.deleteById(id);
            getList(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("Loi khi xoa khach hang co id la " + id);
        }


    }

    private void getForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("get-form.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void getList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        req.setAttribute("customers", customerDAO.getCustomers());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("customers-list.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerName = req.getParameter("name");
        customerDAO.save(customerName);

        getList(req, resp);
    }
}
