<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>提示信息</title>

<script type="text/javascript" src="js/jquery.js"></script>

</head>
<body class="bodybgs">
	<div class="container-fluid">
		<div class="text-center">
			<h3>提示信息</h3>
		</div>
		<div class="container-fluid center-block" style="margin-top:30px;"><%=session.getAttribute("message") %></div>
	</div>
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