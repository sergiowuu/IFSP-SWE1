package br.edu.ifsp.cubatao.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.cubatao.dao.CustomerDAO;
import br.edu.ifsp.cubatao.model.Customer;

@WebServlet("/cadastrar-cliente")
public class CreateCustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            String custName = request.getParameter("custName");
            String city = request.getParameter("city");
            int grade = Integer.parseInt(request.getParameter("grade"));
            int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));
            
            Customer customer = new Customer();
            customer.setCustomerId(customerId);
            customer.setCustName(custName);
            customer.setCity(city);
            customer.setGrade(grade);
            customer.setSalesmanId(salesmanId);

            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.save(customer);

            response.sendRedirect("sucesso.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }
    }
}