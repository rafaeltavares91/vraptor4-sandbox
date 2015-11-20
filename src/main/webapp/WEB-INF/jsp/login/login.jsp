<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="${ctx}/resources/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/resources/estilo.css" />
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
							<div id="notificacaoErro" <c:out value="${empty mensagemErro ? 'class=invisivel' : '' }"></c:out>>
								<div class="alert alert-block alert-danger fade in">
									<button data-dismiss="alert" class="close close-sm" type="button">
										<i class="fa fa-times"></i>
									</button>
									<h4>
										<i class="icon-ok-sign"></i>
										<strong><fmt:message key="mensagem.erro.titulo"/></strong>
									</h4>
									<div class="notificacoes">
										<c:forEach items="${mensagemErro.notificacoes}" var="notificacao">
											<p>${notificacao}</p>
										</c:forEach>
									</div>
								</div>
							</div>
							<div id="notificacaoAtencao" <c:out value="${empty mensagemAtencao ? 'class=invisivel' : '' }"></c:out>>
								<div class="alert alert-block alert-warning fade in">
									<button data-dismiss="alert" class="close close-sm" type="button">
										<i class="fa fa-times"></i>
									</button>
									<h4>
										<i class="icon-ok-sign"></i>
										<strong><fmt:message key="mensagem.atencao.titulo"/></strong>
									</h4>
									<div class="notificacoes">
										<c:forEach items="${mensagemAtencao.notificacoes}" var="notificacao">
											<p>${notificacao}</p>
										</c:forEach>
									</div>
								</div>
							</div>
							<div id="notificacaoInformacao" <c:out value="${empty mensagemInformacao ? 'class=invisivel' : '' }"></c:out>>
								<div class="alert alert-block alert-info fade in">
									<button data-dismiss="alert" class="close close-sm" type="button">
										<i class="fa fa-times"></i>
									</button>
									<h4>
										<i class="icon-ok-sign"></i>
										<strong><fmt:message key="mensagem.informacao.titulo"/></strong>
									</h4>
									<div class="notificacoes">
										<c:forEach items="${mensagemInformacao.notificacoes}" var="notificacao">
											<p>${notificacao}</p>
										</c:forEach>
									</div>
								</div>
							</div>
							<h3>Login Form</h3>
						</div>
						<form role="form" action="${linkTo[LoginController].logar}" method="post">
							<input type="hidden" name="usuario.id" value="${usuario.id}" />
							<div class="form-group">
								<label>Usuário</label>
								<div class="input-group">
									<span class="input-group-addon">
										<span class="glyphicon glyphicon-user" ></span>
									</span> 
									<input type="text" class="form-control" name="usuario.login" placeholder="Usuário" required="required">
								</div>
							</div>
							<div class="form-group">
								<label>Senha</label>
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
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"/>
	<script src="${ctx}/resources/bootstrap/js/bootstrap.min.js" />
</body>
</html>