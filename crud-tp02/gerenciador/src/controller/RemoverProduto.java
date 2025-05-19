// Bruno Souza e Gabriela Wandenkolk
package controller;

import database.Banco;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/remover")
public class RemoverProduto extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Banco.remover(id);
        resp.sendRedirect("produtos");
    }
}
