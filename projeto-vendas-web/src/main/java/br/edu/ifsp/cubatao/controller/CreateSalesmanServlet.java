package br.edu.ifsp.cubatao.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.cubatao.dao.SalesmanDAO;
import br.edu.ifsp.cubatao.model.Salesman;

@WebServlet("/cadastrar-vendedor")
public class CreateSalesmanServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            int salesmanId = Integer.parseInt(request.getParameter("salesmanId"));
            String name = request.getParameter("name");
            String city = request.getParameter("city");
            double commission = Double.parseDouble(request.getParameter("commission"));
            
            Salesman salesman = new Salesman();
            salesman.setSalesmanId(salesmanId);
            salesman.setName(name);
            salesman.setCity(city);
            salesman.setCommission(commission);

            SalesmanDAO salesmanDAO = new SalesmanDAO();
            salesmanDAO.save(salesman);

            response.sendRedirect("sucesso.jsp");

        } catch (NumberFormatException e) {

            e.printStackTrace();
            response.sendRedirect("erro.jsp"); 
        } catch (Exception e) {
            // Outros erros
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }
    }
}