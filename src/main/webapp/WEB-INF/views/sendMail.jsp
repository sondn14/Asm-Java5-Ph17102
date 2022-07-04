<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send mail</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<style type="text/css">
*{
	--formWidth:460px;
	--btnWidth:70px;
	--btnCenter:195px;
}
.formMailer{
	width: var(--formWidth);
	margin: auto;
	margin-top: 4rem;
}
h2{
	color:#0000FF;
}
.btnSend{
	margin-top: 1.5rem;
	margin-left: 195px;
	width: var(--btnWidth);
}
</style>
</head>
<body>
	<form class="formMailer" action="/mailer/send" method="post">
		<h2>Gửi email</h2>
		<div class="form-group">
			<label for="formControlInput">Gửi đến</label> <input
				type="email" class="form-control" id="formControlInput" name="txtTo"
				placeholder="Nhập email người nhận...">
		</div>
		<div class="form-group">
			<label for="formControlInput2">Tiêu đề</label> <input
				type="text" class="form-control" id="formControlInput2" name="txtSubject"
				placeholder="Nhập tiêu đề...">
		</div>
		<div class="form-group">
			<label for="formControlTextarea">Nội dung</label>
			<textarea class="form-control" id="formControlTextarea" name="txtContent"
				rows="4" placeholder="Nhập nội dung..."></textarea>
		</div>
		<button class="btn btn-success btnSend">Gửi</button>
	</form>
</body>
</html>
