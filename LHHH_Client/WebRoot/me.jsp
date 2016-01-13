<%@page import="com.wxc.lhhh.model.User"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	if ( session.getAttribute("login") == null) {
		response.sendRedirect("login.html?page=me");
		return;
	}
	String id = session.getAttribute("id").toString();
	User user1 = MySQLUtil.findUserById(id);
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>个人中心</title>
<link href="css/mstyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="css/style.css" type="text/css"/>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<style type="text/css">
	.row{padding-top: 20px;padding-bottom: 20px;border-bottom: 1px solid #d8d8d8;}
</style>
</head>
<body class="bodybgs">
	<nav class="nav3 p">
		<i class="btn2"><a href="javascript:history.go(-1)">返回</a> </i> <strong>个人中心</strong>
		<i class="btn3"><a href="index.jsp">首页</a></i>
	</nav>
	<section class="form-group" id="container">
		<div class="container-fluid">
		
			<div class="row">
				<a href="xgnc.jsp">
					<div class="col-xs-4 col-md-4">昵称：</div>
					<div class="col-xs-8 col-md-8"><%=user1.getNc() %><iframe src="img/right.svg" style="float:right;border:0;width: 20px;height: 28px;"></iframe></div>
				</a>
			</div>
			<div class="row">
				<div class="col-xs-4 col-md-4">手机号码：</div>
				<div class="col-xs-8 col-md-8"><%=user1.getId() %></div>
			</div>
			<div class="row">
				<div class="col-xs-4 col-md-4">我的积分：</div>
				<div class="col-xs-8 col-md-8" style="color:#d9534f;"><i class="money"><img src="img/money.png" /> </i><%=user1.getJfye() %></div>
			</div>
			<div class="row">
				<a href="xgmm.jsp">
					<div class="col-xs-8 col-md-8">修改密码</div>
					<div class="col-xs-4 col-md-4"><iframe src="img/right.svg" style="float:right;border:0;width: 20px;height: 28px;"></iframe></div>
				</a>
			</div>
			<div class="row">
				<a href="fpscjl.jsp">
					<div class="col-xs-8 col-md-8">发票上传记录</div>
					<div class="col-xs-4 col-md-4"><iframe src="img/right.svg" style="float:right;border:0;width: 20px;height: 28px;"></iframe></div>
				</a>
			</div>
			<div class="row">
				<a href="lpdhjl.jsp">
					<div class="col-xs-8 col-md-8">礼品兑换记录</div>
					<div class="col-xs-4 col-md-4"><iframe src="img/right.svg" style="float:right;border:0;width: 20px;height: 28px;"></iframe></div>
				</a>
			</div>
		</div>
	</section>
	<%@ include  file="footer.jsp"%>
	<script type="text/javascript">
		var page = getUrlParam('page');
		function getUrlParam(name) {
			var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
			var r = window.location.search.substr(1).match(reg); //匹配目标参数
			if (r != null)
				return unescape(r[2]);
			return null; //返回参数值
		}
	</script>
</body>
</html>
