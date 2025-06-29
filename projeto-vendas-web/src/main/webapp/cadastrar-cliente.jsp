<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Cliente</title>
    <style>
        body { font-family: sans-serif; margin: 40px; }
        form { width: 300px; }
        label, input { display: block; margin-bottom: 10px; width: 100%; }
        input[type="submit"] { margin-top: 10px; background-color: #007bff; color: white; border: none; padding: 10px; cursor: pointer; }
    </style>
</head>
<body>
    <h1>Cadastro de Cliente</h1>
    
    <form action="cadastrar-cliente" method="post">
        <label for="customerId">ID do Cliente:</label>
        <input type="number" id="customerId" name="customerId" required>
        
        <label for="custName">Nome do Cliente:</label>
        <input type="text" id="custName" name="custName" required>
        
        <label for="city">Cidade:</label>
        <input type="text" id="city" name="city">
        
        <label for="grade">Grade:</label>
        <input type="number" id="grade" name="grade">
        
        <label for="salesmanId">ID do Vendedor Associado:</label>
        <input type="number" id="salesmanId" name="salesmanId" required>
        
        <input type="submit" value="Cadastrar">
    </form>
    
    <p><a href="index.jsp">Voltar ao Menu</a></p>
</body>
</html>