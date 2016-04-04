<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../base.css">
<title>Listagem Produtos</title>
</head>
<body>

	<div class="container">
	
		<h1>Listagem de produtos</h1>
		
		<table class="table table-stripped table-hover table-bordered">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Valor</th>
					<th>Quantidade</th>
					<th>Remover</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtoList}" var="produto">
				<tr>
					<td>${produto.nome}</td>
					<td>${produto.valor}</td>
					<td>${produto.quantidade}</td>
					<td>
						<form action="<c:url value='/produto/remove'/>" method="post">
    						<input type="hidden" name="_method" value="DELETE">
        					<input type="hidden" name="produto.id" value="${produto.id}">
        					<input type="submit" class="btn btn-danger" value="Remover">
						</form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<a href="<c:url value="/produto/formulario"/>">Adicionar mais produtos!</a>
		
	</div>
	
</body>
</html>