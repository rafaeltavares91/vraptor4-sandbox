<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Usuários</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/layout/topo.jsp" />
	
	<div class="container">

		<ul id="tabs" class="nav nav-tabs">
			<li class="active"><a href="#">Pesquisa</a></li>
			<li><a href="${linkTo[UsuarioController].form}">Cadastro</a></li>
		</ul>
		
		<br />
		<a href="${linkTo[UsuarioController].form}" class="btn btn-primary">
			<span class="glyphicon glyphicon-plus"></span>Novo Usuário
		</a>
		<div class="adv-table">
			<table id="dataTable" class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Login</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${usuarioList}" var="usuario">
						<tr>
							<td>${usuario.nome}</td>
							<td>${usuario.login}</td>
							<td>
								<a href="${linkTo[UsuarioController].editar}?id=${usuario.id}"> <span class="glyphicon glyphicon-edit"></span> Editar </a>
								<a href="${linkTo[UsuarioController].deletar}?id=${usuario.id}"> <span class="glyphicon glyphicon-trash"></span> Deletar </a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<br/>
	<jsp:include page="/WEB-INF/jsp/layout/footer.jsp" />
</body>
</html>