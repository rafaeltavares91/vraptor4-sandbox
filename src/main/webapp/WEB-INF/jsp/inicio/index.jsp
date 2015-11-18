<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="tags" uri="http://www.ufrn.br/tags" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<tags:layout>
	<jsp:body>
		<div class="jumbotron" align="center">
			<h2>Projeto de teste VRaptor 4</h2>
			<p class="lead">Nesse projeto estão sendo utilizadas as tecnologias backend: Vraptor 4, CDI, JPA e Hibernate.</p>
		</div>
		<div class="row" id="features" align="center">
			<div class="col-sm-4 feature">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Markup with HTML5</h3>
					</div>
					<div class="panel-body">
						<img src="${ctx}/resources/bootstrap/imagens/badge_html5.jpg" alt="HTML5" class="img-circle">
						<br /><br />
						<p>90's authentic single-origin coffee stumptown Pinterest. Fap aesthetic dreamcatcher pickled Brooklyn irony.</p>
						<a href="http://www.w3schools.com/html/html5_intro.asp" target="_blank" class="btn btn-danger btn-block">
							Learn to code HTML5
						</a>
					</div>
				</div>
			</div>

			<div class="col-sm-4 feature">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Style with CSS3</h3>
					</div>
					<div class="panel-body">
						<img src="${ctx}/resources/bootstrap/imagens/badge_css3.jpg" alt="CSS3" class="img-circle">
						<br /><br />
						<p>90's authentic single-origin coffee stumptown Pinterest. Fap aesthetic dreamcatcher pickled Brooklyn irony.</p>
						<a href="http://www.w3schools.com/css/default.asp" target="_blank" class="btn btn-info btn-block">
							Style it up with CSS3
						</a>
					</div>
				</div>
			</div>

			<div class="col-sm-4 feature">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Framework by Bootstrap 3</h3>
					</div>
					<div class="panel-body">
						<img src="${ctx}/resources/bootstrap/imagens/badge_bootstrap.jpg" alt="Bootstrap 3" class="img-circle">
						<br /><br />
						<p>90's authentic single-origin coffee stumptown Pinterest. Fap aesthetic dreamcatcher pickled Brooklyn irony.</p>
						<a href="http://getbootstrap.com/" target="_blank" class="btn btn-warning btn-block">
							More Bootstrap
						</a>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</tags:layout>