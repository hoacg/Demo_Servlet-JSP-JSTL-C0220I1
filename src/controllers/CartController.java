package controllers;

import models.*;
import utils.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/cart")
public class CartController extends HttpServlet {

    private DBConnection dbConnection = DBConnection.getInstance();
    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        productDAO = new ProductDAO(this.dbConnection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getCartList(req, resp);
    }

    private void getCartList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("cart");
        // List<Product> cart;
        Cart cart;
        if (o == null) {
            cart = new Cart();
        } else {
            cart = (Cart) o;
        }

        req.setAttribute("cart", cart.getCartItemList());
        RequestDispatcher dispatcher = req.getRequestDispatcher("products-list.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        Object o = session.getAttribute("cart");

        Cart cart;

        if (o == null) {
            cart = new Cart();
        } else {
            cart = (Cart) o;
        }

        int id = Integer.parseInt(req.getParameter("id"));

        Product product = productDAO.getById(id);

        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(1);

        cart.addItem(item);

        session.setAttribute("cart", cart);

        PrintWriter writer = resp.getWriter();
        writer.write("Them gio hang thanh cong!");

    }
}
