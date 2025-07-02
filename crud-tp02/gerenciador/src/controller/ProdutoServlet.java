
package controller;

import model.Produto;
import database.Banco;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.List;

@WebServlet("/produtos")
public class ProdutoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Produto> lista = Banco.getProdutos();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h1>Lista de Produtos</h1>");
        out.println("<a href='formProduto.html'>Adicionar Produto</a><br><br>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Nome</th><th>Unidade</th><th>Descrição</th><th>Qtd/Mês</th><th>Preço</th><th>Ações</th></tr>");

        for (Produto p : lista) {
            out.println("<tr><td>" + p.getId() + "</td><td>" + p.getNome() + "</td><td>" + p.getUnidadeCompra()
                + "</td><td>" + p.getDescricao() + "</td><td>" + p.getQtdPrevistoMes()
                + "</td><td>" + p.getPrecoMaxComprado()
                + "</td><td><a href='editar?id=" + p.getId() + "'>Editar</a> | "
                + "<a href='remover?id=" + p.getId() + "'>Excluir</a></td></tr>");
        }

        out.println("</table>");
    }
}
