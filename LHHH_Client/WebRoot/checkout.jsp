<%@page import="com.wxc.lhhh.model.LiPin"%>
<%@page import="com.wxc.lhhh.model.User"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//取得Session对象
	if (session.getAttribute("login") == null) {
		response.sendRedirect("login.html");
		return;
	}
	request.getSession().setAttribute("token", true);
	String lpbh = request.getParameter("lpbh");
	String dhsl = request.getParameter("dhsl");
	LiPin lp = MySQLUtil.findLiPin(lpbh);
	String id = session.getAttribute("id").toString();
	User user1 = MySQLUtil.findUserById(id);
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Utf-8">
<title>兑换商城</title>
<link href="css/mstyle.css" rel="stylesheet" type="text/css" />
<meta name="viewport"
	content="width=device-width,  initial-scale=1.0, user-scalable=0, minimum-scale=1.0,  maximum-scale=1.0" />
<!-- for apple -->
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta content="black" name="apple-mobile-web-app-status-bar-style" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/style.css" type="text/css"
	media="screen">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style type="text/css">
input {
	outline: none;
}
</style>
<body class="bodybgs">
	<nav class="nav3 p">
		<i class="btn2"><a href="javascript:history.go(-1)">返回</a> </i> <strong>结算</strong>
		<i class="btn3"><a href="index.jsp">首页</a> </i>
	</nav>
	<div class="container-fluid">

		<form action="checkoutServlet" method="post" class="form-horizontal">
			<div class="form-group">
				<label calss="col-xs-6 col-sm-6">兑换物品名称：</label><span class="lpmc"
					style="font-size:2em;"><%=lp.getLpmc()%></span>
			</div>
			<div class="form-group">
				<label for="xfje" calss="col-xs-6 col-sm-6">兑换数量：</label><span><%=dhsl%>个</span>
			</div>
			<div class="form-group">
				<label calss="col-xs-6 col-sm-4">需要积分：</label><i class="money"><img
					src="img/money.png" /> </i><span id="jfzs"><%=lp.getLpdj() * Integer.parseInt(dhsl)%></span>
			</div>
			<div class="form-group" id="myjf">
				<label calss="col-xs-6 col-sm-4">我的积分：</label><i class="money"><img
					src="img/money.png" /> </i><span id="wdjf"><%=user1.getJfye()%></span>
				<lable id="jfbz" style="display:none;color:red;">积分不足！</lable>
			</div>
			<div class="form-group">
				<label calss="col-xs-6 col-sm-4">用户昵称：</label><%=user1.getNc()%>
			</div>
			<div class="form-group">
				<label calss="col-xs-6 col-sm-4">联系电话：</label><input type="text"
					name="sjhm" class="form-control" value="<%=user1.getId()%>" />
			</div>
			<div class="form-group">
				<label calss="col-xs-6 col-sm-4">收货地址：</label><input
					class="form-control" type="text" name="fhdz" placeholder="收货地址" />
			</div>
			<input type="hidden" name="lpbh" value="<%=lp.getLpbh()%>"> <input
				type="hidden" name="dhsl" value="<%=dhsl%>">
			<div class="form-group">
				<button id="queren" type="submit" class="btn btn-primary btn-block"
					style="width:100%;background-color: #ff9800;border-color: #FF9800;">确&nbsp;&nbsp;认</button>
			</div>
		</form>
	</div>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
			compjf();
			$("#jian").click(function() {
				var sl = $("#dhsl").attr("value");
				if (sl === null) {
					$("#dhsl").attr("value", "0");
				} else if (parseInt(sl, 10) > 0) {
					$("#dhsl").attr("value", parseInt(sl, 10) - 1);
				}
				compjf();
			});

			$("#jia").click(function() {
				var sl = $("#dhsl").attr("value");
				if (sl === null) {
					$("#dhsl").attr("value", "0");
				} else {
					$("#dhsl").attr("value", parseInt(sl, 10) + 1);
				}
				compjf();
			});

			$("form").submit(function() {
				var sl = $("#dhsl").attr("value");
				var kcsl = $("#kcsl").html();
				if (parseInt(kcsl, 10) < parseInt(sl, 10)) {
					alert("兑换数量不能超过剩余数量！");
					return false;
				} else if (parseInt(sl, 10) === 0) {
					alert("兑换数量不能为0！");
					return false;
				}
			});
		});
		function compjf() {
			var jfzs = $("#jfzs").text();
			var wdjf = $("#wdjf").text();
			if (parseInt(jfzs, 10) > parseInt(wdjf, 10)) {
				$("#queren").attr("disabled", true);
				$("#jfbz").css("display", "block");
			}
		}
	</script>
</body>
</html>
