<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    model.Produto produto = (model.Produto) request.getAttribute("produto");
    if (produto == null) {
        response.sendRedirect("produtos");
        return;
    }
%>
<html>
<head><title>Editar Produto</title></head>
<body>
<h2>Editar Produto</h2>
<form action="editar" method="post">
    <input type="hidden" name="id" value="<%= produto.getId() %>" />
    Nome: <input type="text" name="nome" value="<%= produto.getNome() %>" /><br/>
    Unidade Compra: <input type="number" name="unidadeCompra" value="<%= produto.getUnidadeCompra() %>" /><br/>
    Descrição: <input type="text" name="descricao" value="<%= produto.getDescricao() %>" /><br/>
    Qtd Previsto Mês: <input type="number" step="0.01" name="qtdPrevistoMes" value="<%= produto.getQtdPrevistoMes() %>" /><br/>
    Preço Max Comprado: <input type="number" step="0.01" name="precoMaxComprado" value="<%= produto.getPrecoMaxComprado() %>" /><br/>
    <input type="submit" value="Salvar" />
</form>
<a href="produtos">Voltar</a>
</body>
</html>
