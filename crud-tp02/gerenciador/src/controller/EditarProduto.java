// Bruno Souza e Gabriela Wandenkolk
package controller;

import model.Produto;
import database.Banco;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/editar")
public class EditarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr != null) {
            try {
                int id = Integer.parseInt(idStr);
                Produto p = Banco.buscarPorId(id);
                if (p != null) {
                    req.setAttribute("produto", p);
                    RequestDispatcher rd = req.getRequestDispatcher("formEditarProduto.jsp");
                    rd.forward(req, resp);
                    return;
                }
            } catch (NumberFormatException e) {
                // ID inválido, você pode registrar o erro ou ignorar
            }
        }
        // Redireciona caso o ID seja inválido ou produto não encontrado
        resp.sendRedirect("produtos");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String nome = req.getParameter("nome");
            int unidade = Integer.parseInt(req.getParameter("unidadeCompra"));
            String descricao = req.getParameter("descricao");
            double qtd = Double.parseDouble(req.getParameter("qtdPrevistoMes"));
            double preco = Double.parseDouble(req.getParameter("precoMaxComprado"));

            Produto p = new Produto();
            p.setId(id);
            p.setNome(nome);
            p.setUnidadeCompra(unidade);
            p.setDescricao(descricao);
            p.setQtdPrevistoMes(qtd);
            p.setPrecoMaxComprado(preco);

            Banco.atualizar(p);
        } catch (NumberFormatException e) {
            // Tratar erro se algum valor não for válido (opcional)
        }

        resp.sendRedirect("produtos");
    }
}
