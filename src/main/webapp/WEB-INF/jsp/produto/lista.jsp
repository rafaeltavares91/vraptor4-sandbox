<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tags" uri="http://www.ufrn.br/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<tags:layout>
	<jsp:body>
		<tags:tabs link="${linkTo[ProdutoController].form}" isForm="${false}" />

		<tags:btNovoCadastro link="${linkTo[ProdutoController].form}" />

		<tags:tabelaDinamica id="tabela" cabecalho="Nome, Categoria">
			<c:forEach items="${produtoList}" var="produto">
				<tr>
					<td>${produto.nome}</td>
					<td>${produto.categoria.nome}</td>
					<td>
						<tags:btMinEditar link="${linkTo[ProdutoController].editar}?id=${produto.id}" />
						<tags:btMinDeletar link="${linkTo[ProdutoController].deletar}?id=${produto.id}" />
					</td>
				</tr>
			</c:forEach>
		</tags:tabelaDinamica>
	</jsp:body>
</tags:layout>