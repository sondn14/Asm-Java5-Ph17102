<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Chi tiết sản phẩm</title>

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
							<li><a href="checkout.html"><i class="fa fa-user"></i>
									Đăng xuất</a></li>
							<li><a href="#"><i class="fa fa-user"></i> Đăng nhập</a></li>
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
				<div class="col-md-4">
					<div class="single-sidebar">
						<h2 class="sidebar-title">Search Products</h2>
						<form action="">
							<input type="text" placeholder="Search products..."> <input
								type="submit" value="Search">
						</form>
					</div>

					<div class="single-sidebar"></div>

					<div class="single-sidebar"></div>
				</div>

				<div class="col-md-8">
					<div class="product-content-right">
						<div class="product-breadcroumb">
							<a href="/home">Home</a> <a href="">motobike</a> <a href="">
								motobike-detail</a>
						</div>

						<c:forEach var="sp" items="${sp}">
								<div class="row">
									<div class="col-sm-6">
										<div class="product-images">
											<div class="product-main-img">
												<img height="120%" width="150%" class="img-fluid"
													src="/images/${sp.anh}" alt="">
											</div>

											<div class="product-gallery"></div>
										</div>
									</div>

									<div class="col-sm-6">
										<div class="product-inner">
											<h2 class="product-name text-danger">${sp.motobikeName}</h2>
											<div class="product-inner-price">
												<ins class="giaTien">Giá xe: ${sp.price} VND</ins>
											</div>
											<form action="/add-to-cart/${sp.motobikeId}" class="cart">
												<!-- <div class="quantity">
												<input type="number" size="4" class="input-text qty text"
													title="Qty" value="1" name="quantity" min="1" step="1">
											</div> -->
												<button class="add_to_cart_button" type="submit">Mua
													ngay</button>
											</form>
											<div role="tabpanel">
												<ul class="product-tab" role="tablist">
													<li role="presentation" class="active"><a href="#home"
														aria-controls="home" role="tab" data-toggle="tab">Thông
															tin</a></li>
													<li role="presentation"><a href="#profile"
														aria-controls="profile" role="tab" data-toggle="tab">Reviews</a></li>
												</ul>
												<div class="tab-content">
													<div role="tabpanel"
														class="tab-pane fade in active pl-5 ml-5" id="home">
														<h4>
															<strong> Nhà sản xuất: </strong><span
																class="label label-info">${sp.motobikeCompany}</span>
														</h4>
														<h4>
															<strong> Màu sắc: </strong><span
																class="label label-primary ">${sp.motobikeColor}</span>
														</h4>
														<h4>
															<strong> Kiểu xe: </strong><span
																class="label label-danger">${sp.motobikeType}</span>
														</h4>
														<h4>
															<strong> Số lượng: </strong><span
																class="label label-warning">${sp.quantity}</span>
														</h4>
														<h4>
															<strong> Ngày nhập: </strong>${sp.createdate}</h4>
													</div>
													<div role="tabpanel" class="tab-pane fade" id="profile">
														<h2>Reviews</h2>
														<div class="submit-review">
															<p>
																<label for="name">Name</label> <input name="name"
																	type="text">
															</p>
															<p>
																<label for="email">Email</label> <input name="email"
																	type="email">
															</p>
															<div class="rating-chooser">
																<p>Your rating</p>

																<div class="rating-wrap-post">
																	<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																		class="fa fa-star"></i> <i class="fa fa-star"></i> <i
																		class="fa fa-star"></i>
																</div>
															</div>
															<p>
																<label for="review">Your review</label>
																<textarea name="review" id="" cols="30" rows="10"></textarea>
															</p>
															<p>
																<input type="submit" value="Submit">
															</p>
														</div>
													</div>
												</div>
											</div>

										</div>
									</div>
								</div>
						</c:forEach>


						<div class="related-products-wrapper">
							<h2 class="related-products-title">Xem thêm sản phẩm</h2>
							<div class="related-products-carousel">
								<c:forEach var="sp" items="${listXe}">
									<div class="single-product">
										<div class="product-f-image">
											<img src="/images/${sp.anh}" alt="">
											<div class="product-hover">
												<a href="" class="add-to-cart-link"><i
													class="fa fa-shopping-cart"></i>Mua ngay</a> <a
													href="/motobike/detail/${sp.motobikeId}"
													class="view-details-link"><i class="fa fa-link"></i>Xem
													thêm</a>
											</div>
										</div>

										<h2>
											<a href="/motobike/detail/${sp.motobikeId}">${sp.motobikeName}</a>
										</h2>

										<div class="product-carousel-price">
											<ins>${sp.price}</ins>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
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
	<script src="/js/owl.carousel.min.js"></script>
	<script src="/js/jquery.sticky.js"></script>

	<!-- jQuery easing -->
	<script src="/js/jquery.easing.1.3.min.js"></script>

	<!-- Main Script -->
	<script src="/js/main.js"></script>
</body>
</html>