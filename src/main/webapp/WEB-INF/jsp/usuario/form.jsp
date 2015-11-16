<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Usuário</title>
</head>
<body>

	<jsp:include page="/WEB-INF/jsp/layout/topo.jsp" />

	<div class="container">

		<ul class="nav nav-tabs">
			<li><a href="${linkTo[UsuarioController].lista}">Pesquisa</a></li>
			<li class="active"><a href="#">Cadastro</a></li>
		</ul>

		<br />
		<div class="tab-pane" id="form">
			<form role="form" action="${linkTo[UsuarioController].salvar}" method="post">
				<fieldset>
					<legend>Cadastrar Usuário</legend>
					<input type="hidden" name="usuario.id" value="${usuario.id}" />

					<div class="form-group">
						<label> Nome: </label> <input type="text" name="usuario.nome"
							class="form-control" value="${usuario.nome}" />
					</div>

					<div class="form-group">
						<label> Login: </label> <input type="text" name="usuario.login"
							class="form-control" value="${usuario.login}" />
					</div>

					<div class="form-group">
						<label> Senha: </label> <input type="password" name="usuario.senha"
							class="form-control" value="${usuario.senha}" />
					</div>
					
					<br />
					<a href="${linkTo[UsuarioController].lista}" class="btn btn-default" role="button">Voltar</a>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</fieldset>
			</form>
			<br />
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/layout/footer.jsp" />
</body>
</html>