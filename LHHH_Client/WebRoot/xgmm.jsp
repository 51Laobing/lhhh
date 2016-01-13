<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//取得Session对象
	if (session.getAttribute("login") == null) {
		response.sendRedirect("login.html?page=me");
		return;
	}
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>个人中心</title>
<link href="css/mstyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<style type="text/css">
.row {
	padding-top: 20px;
	padding-bottom: 20px;
	border-bottom: 1px solid #d8d8d8;
}
</style>
</head>
<body class="bodybgs">
	<nav class="nav3 p">
		<i class="btn2"><a href="javascript:history.go(-1)">返回</a> </i> <strong>修改密码</strong>
	</nav>
	<div class="container-fluid">
		<form action="passwordServlet" method="post" class="form-horizontal">
			<div class="form-group">
				<label calss="col-xs-6 col-sm-4">旧密码：</label> <input type="password"
					name="mm" class="form-control" placeholder="请输入旧密码" />
			</div>
			<div class="form-group">
				<label calss="col-xs-6 col-sm-4">新密码：</label> <input
					class="form-control" type="password" name="newmm"
					placeholder="请输入新密码" />
			</div>
			<div class="form-group">
				<label calss="col-xs-6 col-sm-4">确认密码：</label> <input
					class="form-control" type="password" name="qrmm"
					placeholder="请再输一次新密码" />
			</div>
			<div class="form-group">
				<button id="queren" type="submit" class="btn btn-primary btn-block"
					style="width:100%;background-color: #ff9800;border-color: #FF9800;">修&nbsp;&nbsp;改</button>
			</div>
		</form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
