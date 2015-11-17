<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Categoria</title>
</head>
<body>

	<jsp:include page="/WEB-INF/jsp/layout/topo.jsp" />

	<div class="container">

		<ul class="nav nav-tabs">
			<li><a href="${linkTo[CategoriaController].lista}">Pesquisa</a></li>
			<li class="active"><a href="#">Cadastro</a></li>
		</ul>

		<br />
		<div class="tab-pane" id="form">
			<form role="form" action="${linkTo[CategoriaController].salvar}" method="post">
				<fieldset>
					<legend>Cadastrar Categoria</legend>
					<input type="hidden" name="categoria.id" value="${categoria.id}" />

					<div class="form-group">
						<label> Nome: </label> <input type="text" name="categoria.nome"
							class="form-control" value="${categoria.nome}" />
					</div>

					<div class="form-group">
						<button type="submit" class="btn btn-primary"> <i class="fa fa-check"> </i> <span>Salvar</span> </button>
						<a href="${linkTo[CategoriaController].lista}" class="btn btn-default" role="button"> <i class="fa fa-reply"> </i> <span>Voltar</span> </a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/layout/footer.jsp" />
	<script>
		function goBack() {
		     window.history.back();
		 }
	</script>
</body>
</html>