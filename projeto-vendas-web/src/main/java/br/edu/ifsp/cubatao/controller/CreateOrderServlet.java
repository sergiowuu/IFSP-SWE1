package br.edu.ifsp.cubatao.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.cubatao.dao.OrderDAO;
import br.edu.ifsp.cubatao.model.Order;

@WebServlet("/cadastrar-pedido")
public class CreateOrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            int ordNo = Integer.parseInt(request.getParameter("ordNo"));
            double purchAmt = Double.parseDouble(request.getParameter("purchAmt"));
            LocalDate ordDate = LocalDate.parse(request.getParameter("ordDate"));
            int customerId = Integer.parseInt(request.getParameter("customerId"));
            int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));

            Order order = new Order();
            order.setOrdNo(ordNo);
            order.setPurchAmt(purchAmt);
            order.setOrdDate(ordDate);
            order.setCustomerId(customerId);
            order.setSalesmanId(salesmanId);

            OrderDAO orderDAO = new OrderDAO();
            orderDAO.save(order);
            
            response.sendRedirect("sucesso.jsp");

        } catch (NumberFormatException | DateTimeParseException e) {
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }
    }
}