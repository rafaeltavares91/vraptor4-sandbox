<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Produto</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/layout/topo.jsp" />

	<div class="container">

		<ul id="tabs" class="nav nav-tabs" >
			<li class="active"><a href="#">Pesquisa</a></li>
			<li><a href="${linkTo[ProdutoController].form}">Cadastro</a></li>
		</ul>

		<br />
		<a href="${linkTo[ProdutoController].form}" class="btn btn-primary">
			<span class="glyphicon glyphicon-plus"></span>Novo Produto
		</a>
		
		<br /> <br /> <br />
			<table id="dataTable" class="table table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Categoria</th>
						<th>Ação</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${produtoList}" var="produto">
						<tr>
							<td>${produto.nome}</td>
							<td>${produto.categoria.nome}</td>
							<td>
								<a href="${linkTo[ProdutoController].editar}?id=${produto.id}"> <span class="glyphicon glyphicon-edit"></span> Editar </a>  
								<a href="${linkTo[ProdutoController].deletar}?id=${produto.id}"> <span class="glyphicon glyphicon-trash"></span> Deletar </a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</div>
	<br/>
	<jsp:include page="/WEB-INF/jsp/layout/footer.jsp" />
</body>
</html>