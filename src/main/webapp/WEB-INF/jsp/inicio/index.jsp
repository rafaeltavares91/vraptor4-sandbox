<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bem Vindo!</title>
</head>
<body>
	<jsp:include page="/WEB-INF/jsp/layout/topo.jsp" />

	<div class="container">
		<div class="jumbotron" align="center">
				<h2>Projeto Exemplo!</h2>
				<p class="lead">Nesse projeto estão sendo utilizadas as tecnologias backend: Vraptor 4, CDI, JPA e Hibernate.</p>
		</div>
		<div class="row" id="features" align="center">
			<div class="col-sm-4 feature">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Markup with HTML5</h3>
					</div>
					<div class="panel-body">
						<img src="<c:url value="/resources/bootstrap/imagens/badge_html5.jpg" />"
							alt="HTML5" class="img-circle"> <br /> <br />
						<p>90's authentic single-origin coffee stumptown Pinterest.
							Fap aesthetic dreamcatcher pickled Brooklyn irony.</p>
						<a href="http://www.w3schools.com/html/html5_intro.asp"
							target="_blank" class="btn btn-danger btn-block">Learn to
							code HTML5</a>
					</div>
				</div>
			</div>

			<div class="col-sm-4 feature">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Style with CSS3</h3>
					</div>
					<div class="panel-body">
						<img src="<c:url value="/resources/bootstrap/imagens/badge_css3.jpg" />"
							alt="CSS3" class="img-circle"> <br /> <br />
						<p>90's authentic single-origin coffee stumptown Pinterest.
							Fap aesthetic dreamcatcher pickled Brooklyn irony.</p>
						<a href="http://www.w3schools.com/css/default.asp"
							target="_blank" class="btn btn-info btn-block">Style it up
							with CSS3</a>
					</div>
				</div>
			</div>

			<div class="col-sm-4 feature">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title" align="center">Framework by Bootstrap
							3</h3>
					</div>
					<div class="panel-body">
						<img
							src="<c:url value="/resources/bootstrap/imagens/badge_bootstrap.jpg" />"
							alt="Bootstrap 3" class="img-circle"> <br /> <br />
						<p>90's authentic single-origin coffee stumptown Pinterest.
							Fap aesthetic dreamcatcher pickled Brooklyn irony.</p>
						<a href="http://getbootstrap.com/" target="_blank"
							class="btn btn-warning btn-block">More Bootstrap</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/jsp/layout/footer.jsp" />
</body>
</html>