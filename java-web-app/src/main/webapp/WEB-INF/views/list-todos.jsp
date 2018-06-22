<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="webjars/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
<title>List of Todo's</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">4Tress</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="/">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="list-todo.do">Todos</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="https://www.in28minutes.com/">in28minutes</a></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li><a class="nav-link" href="logout.do">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">

		<h3>
			Welcome <span style="color: green;">${username}</span>
		</h3>
		<h5>Your List of Todo's</h5>
		<div>
			<ol>
				<c:forEach items="${todos}" var="todo">
					<li>${todo.name}&nbsp;&nbsp; <a
						href="delete-todo.do?todoToDel=${todo.name}">Delete</a></li>
				</c:forEach>
			</ol>
		</div>

		<form action="add-todo.do" method="post">
			<div class="col-md-8 form-group">
				Todo Name <input class="form-control" placeholder="enter todo name"
					type="text" name="todoname" />
			</div>
			<div class="form-group col-md-4">
				<input type="submit" value="Add" />
			</div>
		</form>

	</div>

	<footer class="footer">
		<p>footer content</p>
	</footer>

	<!-- JavaScript plugins -->
	<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>