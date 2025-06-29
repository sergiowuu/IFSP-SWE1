<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Vendedor</title>
    <style>
        body { font-family: sans-serif; margin: 40px; }
        form { width: 300px; }
        label, input { display: block; margin-bottom: 10px; width: 100%; }
        input[type="submit"] { margin-top: 10px; background-color: #007bff; color: white; border: none; padding: 10px; cursor: pointer; }
    </style>
</head>
<body>
    <h1>Cadastro de Vendedor</h1>
    
    <form action="cadastrar-vendedor" method="post">
        <label for="salesmanId">ID do Vendedor:</label>
        <input type="number" id="salesmanId" name="salesmanId" required>
        
        <label for="name">Nome:</label>
        <input type="text" id="name" name="name" required>
        
        <label for="city">Cidade:</label>
        <input type="text" id="city" name="city">
        
        <label for="commission">Comissão (ex: 0.15):</label>
        <input type="number" step="0.01" id="commission" name="commission" required>
        
        <input type="submit" value="Cadastrar">
    </form>

    <p><a href="index.jsp">Voltar ao Menu</a></p>
</body>
</html>