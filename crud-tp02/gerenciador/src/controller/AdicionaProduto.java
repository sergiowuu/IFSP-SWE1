
package controller;

import model.Produto;
import database.Banco;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/adicionar")
public class AdicionaProduto extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Produto p = new Produto();
        p.setNome(req.getParameter("nome"));
        p.setDescricao(req.getParameter("descricao"));
        p.setUnidadeCompra(Integer.parseInt(req.getParameter("unidade")));
        p.setQtdPrevistoMes(Double.parseDouble(req.getParameter("qtd")));
        p.setPrecoMaxComprado(Double.parseDouble(req.getParameter("preco")));

        Banco.adicionar(p);
        resp.sendRedirect("produtos");
    }
}
