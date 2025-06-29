<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Pedido</title>
    <style>
        body { font-family: sans-serif; margin: 40px; }
        form { width: 300px; }
        label, input { display: block; margin-bottom: 10px; width: 100%; }
        input[type="submit"] { margin-top: 10px; background-color: #007bff; color: white; border: none; padding: 10px; cursor: pointer; }
    </style>
</head>
<body>
    <h1>Cadastro de Pedido</h1>
    
    <form action="cadastrar-pedido" method="post">
        <label for="ordNo">Número do Pedido:</label>
        <input type="number" id="ordNo" name="ordNo" required>
        
        <label for="purchAmt">Valor da Compra:</label>
        <input type="number" step="0.01" id="purchAmt" name="purchAmt" required>
        
        <label for="ordDate">Data do Pedido:</label>
        <input type="date" id="ordDate" name="ordDate" required>
        
        <label for="customerId">ID do Cliente:</label>
        <input type="number" id="customerId" name="customerId" required>
        
        <label for="salesmanId">ID do Vendedor:</label>
        <input type="number" id="salesmanId" name="salesmanId" required>
        
        <input type="submit" value="Cadastrar">
    </form>

    <p><a href="index.jsp">Voltar ao Menu</a></p>
</body>
</html>