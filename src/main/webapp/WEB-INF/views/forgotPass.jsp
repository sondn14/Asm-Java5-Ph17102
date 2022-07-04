<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đăng nhập</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/css.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular-route.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: rgba(255, 1, 1, 0.1)
}

.card {
	border: none;
	border-radius: 0;
	width: 420px !important;
	margin: 0 auto
}

.signup {
	display: flex;
	flex-flow: column;
	justify-content: center;
	padding: 10px 50px
}

a {
	text-decoration: none !important
}

h5 {
	color: #ff0147;
	margin-bottom: 3px;
	font-weight: bold
}

small {
	color: rgba(0, 0, 0, 0.3)
}

input {
	width: 100%;
	display: block;
	margin-bottom: 7px
}

.form-control {
	border: 1px solid #dc354575;
	border-radius: 30px;
	background-color: rgba(0, 0, 0, .075);
	letter-spacing: 1px
}

.form-control:focus {
	border: 0.5px solid #dc354575;
	border-radius: 30px;
	box-shadow: none;
	background-color: rgba(0, 0, 0, .075);
	color: #000;
	letter-spacing: 1px
}

.btn {
	display: block;
	width: 100%;
	border-radius: 30px;
	border: none;
	background: linear-gradient(to right, rgba(249, 0, 104, 1) 0%,
		rgba(247, 117, 24, 1) 100%);
	background: -webkit-linear-gradient(left, rgba(249, 0, 104, 1) 0%,
		rgba(247, 117, 24, 1) 100%)
}

.text-left {
	color: #ff0147;
	font-weight: bold
}

.text-right {
	color: #ff0147;
	font-weight: bold;
	margin-left: 30px;
}

span.text-center {
	color: rgba(0, 0, 0, 0.3)
}

.fab {
	padding: 15px;
	font-size: 23px
}

.fa-facebook {
	color: #0303d9bf
}

.fa-twitter {
	color: #0078fade
}

.fa-linkedin {
	color: #18b1c0
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-6 mx-auto py-4 px-0">
				<div class="card p-0">
					<div class="card-title text-center">
						<h5 class="mt-5">
							Quên mật khẩu
							<h5>
					</div>
					<form class="signup" method="POST" action="/mailer/send">
						<div class="form-group">
							<span class="text-danger">${error}</span>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="tài khoản"
								name="userName">
						</div>
						<div class="form-group">
							<input type="email" class="form-control"
								placeholder="email" name="email">
						</div>
						<button type="submit" class="btn btn-primary">Quên mật khẩu</button>
						<div class="row">
							<div class="col-6 col-sm-6">
							</div>
							<div class="col-6 col-sm-6">
								<a href="#">
									<a class="text-right" href="/signUp" >Đăng ký ngay</a>
								</a>
							</div>
						</div>
						<span class="text-center">Or</span> <span class="text-center pt-3">Quay
							lại trang chủ</span>
						<div class="row">
							<div class="d-flex mx-auto pt-1 pb-3">
								<a href="/home"><svg
										xmlns="http://www.w3.org/2000/svg" width="30" height="30"
										fill="currentColor" class="bi bi-house-fill"
										viewBox="0 0 16 16">
										<path fill-rule="evenodd"
											d="m8 3.293 6 6V13.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5V9.293l6-6zm5-.793V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z" />
										<path fill-rule="evenodd"
											d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z" /></svg></a>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>