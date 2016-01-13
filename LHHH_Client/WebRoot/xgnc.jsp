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
		<i class="btn2"><a href="javascript:history.go(-1)">返回</a> </i> <strong>修改昵称</strong>
	</nav>
	<div class="container-fluid">
		<form action="userServlet" method="post" class="form-horizontal">
			<div class="form-group">
				<label calss="col-xs-6 col-sm-4">新昵称：</label> <input type="text"
					name="newnc" class="form-control" placeholder="请输入新昵称" />
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
