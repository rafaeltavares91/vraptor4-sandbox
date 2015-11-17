<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/resources/datatables/css/dataTables.css" />">
<link rel="stylesheet" href="<c:url value="/resources/datatables/css/dataTables.custom.css" />">
<link rel="stylesheet" href="<c:url value="/resources/datatables/css/DT_bootstrap.css" />">
<link rel="stylesheet" href="<c:url value="/resources/datatables/css/dataTables.fontAwesome.css" />">
<link rel="stylesheet" href="<c:url value="/resources/estilo.css" />">
<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="http://logiquesistemas.com.br/">
					<img src=<c:url value="/resources/imagens/logo.png" /> alt="Logique Sistemas">
				</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="${linkTo[InicioController].index}">Inicio</a></li>
					<li><a href="${linkTo[ProdutoController].lista}">Produto</a></li>
					<li><a href="${linkTo[CategoriaController].lista}">Categoria</a></li>
					<li><a href="${linkTo[UsuarioController].lista}">Usuário</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>
							User Login</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><span class="glyphicon glyphicon-cog"></span>
							<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">Profile</a></li>
							<li><a href="#">Akun</a></li>
							<li><a href="#">About</a></li>
							<li class="divider"></li>
							<li><a href="${linkTo[LoginController].login}">Logout</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<br/><br/><br/><br/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/datatables/js/jquery.dataTables.js"/>"></script>
	<script src="<c:url value="/resources/datatables/js/DT_bootstrap.js"/>"></script>
	<script src="<c:url value="/resources/tabela.js"/>"></script>
</body>
</html>