<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />">
<title>Página de Login</title>
</head>
<body style="background: #eee;">
	<div class="container">
		<br /> <br /> <br />
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="page-header">
							<h3>Login Form</h3>
						</div>
						<form role="form" action="${linkTo[LoginController].logar}" method="post">
							<input type="hidden" name="usuario.id" value="${usuario.id}" />
							<div class="form-group">
								<label for="InputUsuario">Usuário</label>
								<div class="input-group">
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-user" ></span>
									</span> 
									<input type="text" class="form-control" name="usuario.login" placeholder="Usuário" required="required">
								</div>
							</div>
							<div class="form-group">
								<label for="InputPassword">Senha</label>
								<div class="input-group">
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-lock"></span>
									</span> 
									<input type="password" class="form-control" name="usuario.senha" placeholder="Senha" required="required">
								</div>
							</div>
							<hr />
							<button type="submit" class="btn btn-primary btn-block">Entrar</button>
							<br />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</body>
</html>