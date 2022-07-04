<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Shop Page- Ustora Demo</title>

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
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- Font Awesome -->
<link rel="stylesheet" href="css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="css/owl.carousel.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/responsive.css">
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
						<li><a href="/home">Trang chủ</a></li>
						<li class="active"><a href="/motobike">Sản phẩm</a></li>
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

	<div class="product-big-title-area">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="product-bit-title text-center">
						<h2>Shop</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="single-product-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<c:forEach items="${listXe}" var="sp">
					<c:if test="${sp.quantity > 0}">
						<div class="col-md-3 col-sm-6">
							<div class="single-shop-product text-center">
								<div class="product-upper">
									<img src="images/${sp.anh}" alt="">
								</div>
								<h2>
									<a href="/motobike/detail/${sp.motobikeId}">${sp.motobikeName}</a>
								</h2>
								<div class="product-carousel-price">
									<ins>${sp.price} VND</ins>
								</div>

								<div class="product-option-shop">
									<a class="add_to_cart_button" data-quantity="1"
										data-product_sku="" data-product_id="70" rel="nofollow"
										href="/canvas/shop/?add-to-cart=70">Thêm giỏ hàng</a>
								</div>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="product-pagination text-center">
						<nav>
							<ul class="pagination">
								<li><a href="#" aria-label="Previous"> <span
										aria-hidden="true">&laquo;</span>
								</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#" aria-label="Next"> <span
										aria-hidden="true">&raquo;</span>
								</a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="footer-top-area">
		<div class="zigzag-bottom"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-3 col-sm-6">
					<div class="footer-about-us">
						<h2>
							u<span>Stora</span>
						</h2>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
							Perferendis sunt id doloribus vero quam laborum quas alias
							dolores blanditiis iusto consequatur, modi aliquid eveniet
							eligendi iure eaque ipsam iste, pariatur omnis sint! Suscipit,
							debitis, quisquam. Laborum commodi veritatis magni at?</p>
						<div class="footer-social">
							<a href="#" target="_blank"><i class="fa fa-facebook"></i></a> <a
								href="#" target="_blank"><i class="fa fa-twitter"></i></a> <a
								href="#" target="_blank"><i class="fa fa-youtube"></i></a> <a
								href="#" target="_blank"><i class="fa fa-linkedin"></i></a>
						</div>
					</div>
				</div>

				<div class="col-md-3 col-sm-6">
					<div class="footer-menu">
						<h2 class="footer-wid-title">User Navigation</h2>
						<ul>
							<li><a href="">My account</a></li>
							<li><a href="">Order history</a></li>
							<li><a href="">Wishlist</a></li>
							<li><a href="">Vendor contact</a></li>
							<li><a href="">Front page</a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-3 col-sm-6">
					<div class="footer-menu">
						<h2 class="footer-wid-title">Categories</h2>
						<ul>
							<li><a href="">Mobile Phone</a></li>
							<li><a href="">Home accesseries</a></li>
							<li><a href="">LED TV</a></li>
							<li><a href="">Computer</a></li>
							<li><a href="">Gadets</a></li>
						</ul>
					</div>
				</div>

				<div class="col-md-3 col-sm-6">
					<div class="footer-newsletter">
						<h2 class="footer-wid-title">Newsletter</h2>
						<p>Sign up to our newsletter and get exclusive deals you wont
							find anywhere else straight to your inbox!</p>
						<div class="newsletter-form">
							<input type="email" placeholder="Type your email"> <input
								type="submit" value="Subscribe">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer-bottom-area">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<div class="copyright">
						<p>
							&copy; 2015 uCommerce. All Rights Reserved. <a
								href="http://www.freshdesignweb.com" target="_blank">freshDesignweb.com</a>
						</p>
					</div>
				</div>

				<div class="col-md-4">
					<div class="footer-card-icon">
						<i class="fa fa-cc-discover"></i> <i class="fa fa-cc-mastercard"></i>
						<i class="fa fa-cc-paypal"></i> <i class="fa fa-cc-visa"></i>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Latest jQuery form server -->
	<script src="https://code.jquery.com/jquery.min.js"></script>

	<!-- Bootstrap JS form CDN -->
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<!-- jQuery sticky menu -->
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.sticky.js"></script>

	<!-- jQuery easing -->
	<script src="js/jquery.easing.1.3.min.js"></script>

	<!-- Main Script -->
	<script src="js/main.js"></script>
</body>
</html>