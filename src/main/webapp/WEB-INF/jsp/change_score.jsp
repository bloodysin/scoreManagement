<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="css/bootstrap.min.css" rel="stylesheet" />
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	
	<title>修改成绩</title>
	</head>
<body>
	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<c:if test="${not empty message}">
							<div class="alert alert-danger" role="alert">${message}</div>
						</c:if>
						<form:form id="login" method="post" class="bs-example form-horizontal" commandName="score" modelAttribute="score">
							<div class="form-group">
								<label for="scoreInput">修改</label>
								<form:input type="text" class="form-control" path="value" id="scoreInput" placeholder="Enter new score" />
								<button type="submit" class="btn btn-default">修改</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>