<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tags" uri="http://www.ufrn.br/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<tags:layout>
	<jsp:body>
		<tags:tabs link="${linkTo[CategoriaController].form}" isForm="${false}" />

		<tags:btNovoCadastro link="${linkTo[CategoriaController].form}" />

		<tags:tabelaDinamica id="tabela" cabecalho="Nome">
			<c:forEach items="${categoriaList}" var="categoria">
				<tr>
					<td>${categoria.nome}</td>
					<td>
						<tags:btMinEditar link="${linkTo[CategoriaController].editar}?id=${categoria.id}" />
						<tags:btMinDeletar link="${linkTo[CategoriaController].deletar}?id=${categoria.id}" />
					</td>
				</tr>
			</c:forEach>
		</tags:tabelaDinamica>
	</jsp:body>
</tags:layout>