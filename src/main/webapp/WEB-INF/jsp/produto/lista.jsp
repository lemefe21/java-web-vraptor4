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
		
		<c:choose>
			<c:when test="${not empty mensagem}">
				<div class="alert alert-success alert-dismissible fade in" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
  					<span aria-hidden="true">&times;</span>
				</button>${mensagem}
				</div>
			</c:when>
			<c:when test="${not empty removido}">
				<div class="alert alert-warning alert-dismissible fade in" role="alert">
				 <button type="button" class="close" data-dismiss="alert" aria-label="Close">
  					<span aria-hidden="true">&times;</span>
				</button>${removido}
				</div>
			</c:when>
		</c:choose>
		
		<a href="<c:url value="/produto/formulario"/>">Adicionar mais produtos!</a><br/>
		
		<div class="btn-group" style="margin-top: 15px">
	  		<button class="btn btn-default btn-sm dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	    		Acesse essa lista em <span class="caret"></span>
	  		</button>
	  		<ul class="dropdown-menu">
	   			<li><a href="<c:url value='/produto/listaXML'/>">XML</a></li>
    			<li><a href="<c:url value='/produto/listaJSON'/>">JSON</a></li>
	  		</ul>
		</div>
		
	</div>
	
	<script src="../js/jquery.js" type="text/javascript"></script> 
	<script src="../js/bootstrap.min.js" type="text/javascript"></script>
	
</body>
</html>