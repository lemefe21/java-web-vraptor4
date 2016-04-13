<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="../base.css">
<title>Login Usuário</title>
</head>
<body>

	<div class="container">
	
		<form action="<c:url value="/login/autentica" />" method="post"> 
		
			<h2 class="form-signin-heading">Faça login para acessar o VRaptor-Produtos</h2>
		
			<div class="input-group" style="margin-bottom: 10px">
  				<span class="input-group-addon" id="sizing-addon1">Usuário</span>
				<input type="text" class="form-control" name="usuario.nome" />
			</div>
			
			<div class="input-group" style="margin-bottom: 10px">
  				<span class="input-group-addon" style="padding-right: 20px" id="sizing-addon1">Senha</span>
				<input type="password" class="form-control" name="usuario.senha"/>
			</div>
			
			<input type="submit" class="btn btn-primary" value="Login">
		
		</form>
		
		<c:if test="${not empty errors}">
			<div class="alert alert-danger" style="margin-top: 10px">
				<c:forEach items="${errors}" var="erro">
					* ${erro.message}<br/>
				</c:forEach>
			</div>
		</c:if>
		
	</div>

</body>
</html>