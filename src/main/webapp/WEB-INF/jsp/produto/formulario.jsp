<%@ page language="java" contentType="charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../base.css">
<title>Novo Produto</title>
</head>
<body>
	
	<div class="container">
		
		<h1>Adiciona produto</h1>
	
		<!-- boa prática usarmos c:url para caminho relativo -->
		<form action="<c:url value="/produto/adiciona" />" method="post">
		
			<!-- passamos o name para que seja passado como parametro para a request -->
			<!-- produto.nome utilizamos o setNome() do produto, assim a request recebe um objeto produto  -->
			Nome: 
			<input id="nome" class="form-control" type="text" name="produto.nome" value="${produto.nome}"/>
			Valor: 
			<div class="input-group" style="margin-bottom: 10px">
				<span class="input-group-addon">R$</span>
				<input id="real" class="form-control" type="text" name="produto.valor" value="${produto.valor}" />
			</div>
			Quantidade: 
			<input id="quantidade" class="form-control frm_number_only" type="number" name="produto.quantidade" value="${produto.quantidade}"/>
			
			<input type="submit" class="btn btn-primary" value="Adiciona Produto">
		
		</form>
		
		<c:if test="${not empty errors}">
			<div class="alert alert-danger" style="margin-top: 10px">
				<c:forEach items="${errors}" var="erro">
					* ${erro.message}<br/>
				</c:forEach>
			</div>
		</c:if>
		
	</div>
	
	<script src="../js/jquery.js" type="text/javascript"></script> 
	<script src="../js/jquery.maskMoney.min.js" type="text/javascript"></script>
	<script>
	$('#real').each(function(){
		var valor = $('#real').val().replace('.', ',');
		$(this).val('');
		$(this).val(valor);
	})
	//JQuery para limpar caracteres que não sejam numeros dos imputs
	/* $('#quantidade').keyup(function () {
    	if (this.value != this.value.replace(/[^0-9\.]/g, '')) {
   	    	this.value = this.value.replace(/[^0-9\.]/g, '');
  		}
	}); */
	$(function(){
		$("#dolar").maskMoney()
		$("#real").maskMoney({symbol:"R$",decimal:",",thousands:"."})
		$("#euro").maskMoney({symbol:"Euro",decimal:",",thousands:" "})
		$("#precision").maskMoney({decimal:",",thousands:" ",precision:3})
	})
	</script>

</body>
</html>