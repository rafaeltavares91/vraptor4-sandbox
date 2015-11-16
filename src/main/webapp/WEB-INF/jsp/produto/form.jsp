<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Produto</title>
</head>
<body>
	
	<jsp:include page="/WEB-INF/jsp/layout/topo.jsp"/>
	
	<div class="container">

		<ul class="nav nav-tabs">
			<li><a href="${linkTo[ProdutoController].lista}">Pesquisa</a></li>
			<li class="active"><a href="#">Cadastro</a></li>
		</ul>

		<br />
		<div class="tab-pane" id="form">
			<form role="form" action="${linkTo[ProdutoController].salvar}"
				method="post">
				<fieldset>
					<legend>Cadastrar Produto</legend>
					<input type="hidden" name="produto.id" value="${produto.id}" />

					<div class="form-group">
						<label> Nome: </label> <input type="text" class="form-control"
							placeholder="Nome" name="produto.nome" value="${produto.nome}" />
					</div>

					<div class="form-group">
						<label> Categoria: </label> <select id="select1" class="form-control"
							name="produto.categoria.id">
							<c:forEach items="${categoriaList}" var="categoria">
								<option value="${categoria.id}">${categoria.nome}</option>
							</c:forEach>
						</select>
					</div>

					<br />
					<a href="${linkTo[ProdutoController].lista}" class="btn btn-default" role="button">Voltar</a>
					<button type="submit" class="btn btn-primary">Salvar</button>
				</fieldset>
			</form>
			<br />
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/layout/footer.jsp" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script type="text/javascript">
    </script>
</body>
</html>