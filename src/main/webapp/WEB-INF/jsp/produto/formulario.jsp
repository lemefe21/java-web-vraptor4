<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../base.css">
<title>Novo Produto</title>
</head>
<body>
	
	<div class="container">
		
		<h1>Adiciona produto</h1>
	
		<!-- boa prática usarmos c:url para caminho relativo -->
		<form action="<c:url value="/produto/adiciona" />">
		
			<!-- passamos o name para que seja passado como parametro para a request -->
			<!-- produto.nome utilizamos o setNome() do produto, assim a request recebe um objeto produto  -->
			Nome: <input class="form-control" type="text" name="produto.nome" value="${produto.nome}"/>
			Valor: <input class="form-control" type="text" name="produto.valor" value="${produto.valor}"/>
			Quantidade: <input class="form-control" type="text" name="produto.quantidade" value="${produto.quantidade}"/>
			<input type="submit" class="btn btn-primary" value="Adiciona Produto"> 
		
		</form>

	</div>

</body>
</html>