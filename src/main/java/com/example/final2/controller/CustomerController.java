package com.example.final2.controller;

import com.example.final2.dao.CustomerDao;
import com.example.final2.entity.Customer;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CustomerController
 */
@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html,charset=UTF-8");
        String url = request.getServletPath();
        switch (url) {
            case "/index":
                this.findAll(request, response);
                request.getRequestDispatcher("/customer.jsp").forward(request, response);
                break;
            case "/search":
                this.find(request, response);
                request.getRequestDispatcher("/customer.jsp").forward(request, response);
            default:
                break;
        }
    }

    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CustomerDao cus = new CustomerDao();
            List<Customer> list = cus.findAll();

            request.setAttribute("cus", list);
        } catch (Exception e) {
            e.getStackTrace();
            request.setAttribute("err", "ERROR: " + e.getMessage());
        }
    }

    protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            CustomerDao cus = new CustomerDao();
            String name = request.getParameter("name");
            List<Customer> list = cus.find(name);
            request.setAttribute("customer_name", name);
            request.setAttribute("cus", list);
        } catch (Exception e) {
            e.getStackTrace();
            request.setAttribute("err", "ERROR: " + e.getMessage());
        }
    }

}
