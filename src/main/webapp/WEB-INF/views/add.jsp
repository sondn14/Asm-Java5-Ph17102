<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Trang chủ</title>

<!-- Google Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Titillium+Web:400,200,300,700,600'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap -->
<link rel="stylesheet" href="/css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="/css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="/css/owl.carousel.css">
<link rel="stylesheet" href="/css/style.css">
<link rel="stylesheet" href="/css/responsive.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.18/dist/sweetalert2.min.css">
</head>

<body>
	<div class="header-area">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="user-menu">
						<ul>
							<li><a href="#"><i class="fa fa-user"></i>Tài khoản</a></li>
							<li><a href="#"><i class="fa fa-heart"></i> Yêu thích</a></li>
							<li><a href="#"><i class="fa fa-user"></i> Giỏ hàng</a></li>
							<c:if test="${userSession == null}">
								<li><a href="checkout.html"><i class="fa fa-user"></i>
										Đăng xuất</a></li>
								<li><a href="/login"><i class="fa fa-user"></i>Đăng
										nhập</a></li>
							</c:if>
							<c:if test="${userSession != null}">
								<li><i class="fa fa-user"></i></li>
								<li class="dropdown dropdown-small"><a
									data-toggle="dropdown" data-hover="dropdown"
									class="dropdown-toggle" href="#">${userSession.userName}</a>
									<ul class="dropdown-menu">
										<li><a href="/logout">Đăng xuất</a></li>
									</ul></li>
							</c:if>
						</ul>
					</div>
				</div>

				<div class="col-md-4">
					<div class="header-right">
						<ul class="list-unstyled list-inline">
							<li class="dropdown dropdown-small"><a
								data-toggle="dropdown" data-hover="dropdown"
								class="dropdown-toggle" href="#"><span class="key">Đơn
										vị :</span><span class="value"> VND </span><b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">USD</a></li>
									<li><a href="#">INR</a></li>
									<li><a href="#">GBP</a></li>
								</ul></li>

							<li class="dropdown dropdown-small"><a
								data-toggle="dropdown" data-hover="dropdown"
								class="dropdown-toggle" href="#"><span class="key">Ngôn
										ngữ :</span><span class="value"> Vietnamses </span><b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">English</a></li>
									<li><a href="#">French</a></li>
									<li><a href="#">German</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End header area -->

	<div class="site-branding-area">
		<div class="container">
			<div class="row">
				<div class="col-sm-6">
					<div class="logo">
						<h1>
							<a href="./"><img alt="" src="/images/logo.png"></a>
						</h1>
					</div>
				</div>

				<div class="col-sm-6">
					<div class="shopping-item">
						<a href="/cart">Giỏ hàng<i class="fa fa-shopping-cart"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End site branding area -->

	<div class="mainmenu-area">
		<div class="container">
			<div class="row">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="/home">Trang chủ</a></li>
						<li><a href="/motobike">Sản phẩm</a></li>
						<li><a href="single-product.html">Thông tin</a></li>
						<li><a href="#">Phản hồi</a></li>
						<li><a href="#">Liên hệ</a></li>
						<c:if test="${userSession.role == 0}">
							<li><a href="/admin">Admin</a></li>
						</c:if>
						<li><a href="/list-order">Đơn hàng của tôi</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End mainmenu area -->
	<div class="container-fluid">
		<div class="product-big-title-area">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="product-bit-title text-center">
							<h2>Admin</h2>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<h3 class="section-title">Thêm sản phẩm mới</h3>
				<form action="/add" method="POST">
					<div class="form-group">
						<label for="exampleInputEmail1">Tên xe</label> <input type="text"
							class="form-control" id="motobikeName" placeholder="tên xe"
							value="${motobike.motobikeName}" name="motobikeName">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Giá xe</label> <input
							type="number" class="form-control" id="exampleInputPassword1"
							placeholder="giá xe" value="${motobike.price }" name="price">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Số lượng</label> <input
							type="number" class="form-control" id="exampleInputPassword1"
							placeholder="số lượng" value="${motobike.quantity}"
							name="quantity">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Kiểu xe</label> <select
							name="motobikeType" class="form-control me-2">
							<c:forEach var="motobikeType" items="${motobikeType }">
								<option value="${motobikeType}">${motobikeType}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Màu xe</label> <select
							name="motobikeColor" class="form-control me-2">
							<c:forEach var="motobikeColor" items="${motobikeColor }">
								<option value="${motobikeColor}">${motobikeColor}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Hãng xe</label> <select
							name="motobikeCompany" class="form-control me-2">
							<c:forEach var="motobikeCompany" items="${motobikeCompany }">
								<option value="${motobikeCompany}">${motobikeCompany}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label for="exampleInputFile">Ảnh</label> <input type="file"
							id="exampleInputFile" name="anh" value="${motobike.anh}">
					</div>
					<button type="submit" class="btn btn-default" id="add">Thêm</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Latest jQuery form server -->
	<script src="https://code.jquery.com/jquery.min.js"></script>

	<!-- Bootstrap JS form CDN -->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<!-- jQuery sticky menu -->
	<script src="/js/owl.carousel.min.js"></script>
	<script src="js/jquery.sticky.js"></script>

	<!-- jQuery easing -->
	<script src="/js/jquery.easing.1.3.min.js"></script>

	<!-- Main Script -->
	<script src="/js/main.js"></script>

	<!-- Slider -->
	<script type="text/javascript" src="/js/bxslider.min.js"></script>
	<script type="text/javascript" src="/js/script.slider.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.18/dist/sweetalert2.all.min.js"></script>
	<script>
        document.getElementById('add').addEventListener('click', (event) => {
            event.preventDefault();
            Swal.fire({
                title: 'Thêm thành công',
                icon: 'success',
            }).then((result) => {
                if (result.isConfirmed) {
                  document.querySelector('form').submit();
                }
            })
        });
    </script>
</body>

</html>