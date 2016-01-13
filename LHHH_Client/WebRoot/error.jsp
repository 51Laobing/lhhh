<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>提示信息</title>

<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link href="css/mstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>
<body class="bodybgs">
	<nav class="nav3 p">
		<i class="btn2"><a href="javascript:history.go(-1)">返回</a> </i> <strong>提示信息</strong>
		<i class="btn3"><a href="index.jsp">首页</a> </i>
	</nav>
	<div class="container-fluid">
		<div class="text-center">
			<h3>提示信息</h3>
		</div>
		<div class="container-fluid center-block" style="margin-top:30px;"><div class='no_img'></div><p>出错啦！</p></div>
	</div>
	<%@ include  file="footer.jsp"%>
	<script type="text/javascript">
		$(".no_img")
				.html(
						"<img src='img/no.png' alt='' class='img-circle center-block'/>");
		$(".yes_img")
				.html(
						"<img src='img/yes.png' alt='' class='img-circle center-block'/>");
		$(".dang_img")
				.html(
						"<img src='img/dang.png' alt='' class='img-circle center-block'/>");
		$("p").addClass("text-center").css("margin-top", "40px");
	</script>
</body>
</html>