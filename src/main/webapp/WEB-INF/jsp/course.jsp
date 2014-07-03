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
	
	<title>成绩查看</title>
</head>
<body>

	<div class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="teacher_dashboard.do?user_id=${id}">首页</a></li>
				<li><a href="course.do?user_id=${id}">课程管理</a></li>
				<li class="active"><a href="login.do">登出</a></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>
	
	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">
						<div class="table-responsive">
							<table class="table"> 	
								<thead>
									<tr>
										<th>课程名称</th>
										<th> </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="course">
										<tr>
											<td>${course.courseName}</td>
											<td><a href="score.do?user_id=${id}&c_id=${course.courseId}">查看学生成绩</a></td>
										</tr>
								    </c:forEach>
							    </tbody>
							</table>
						</div>
						<span class="glyphicon glyphicon-plus"></span><a href="add_course.do?user_id=${id}">添加课程</a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>