<%@page import="com.wxc.lhhh.model.LiPin"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//取得Session对象
	if (session.getAttribute("login") == null) {
		response.sendRedirect("login.html");
		return;
	}
	String lpbh = request.getParameter("lpbh");
	LiPin lp = MySQLUtil.findLiPin(lpbh);
	String serverurl = MySQLUtil.findValueByKey("server_url");
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>兑换商城</title>
<link href="css/mstyle.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="css/style.css" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<body class="bodybgs">
	<nav class="nav3 p">
		<i class="btn2"><a href="javascript:history.go(-1)">返回</a> </i> <strong>兑换商城</strong>
		<i class="btn3"><a href="index.jsp">首页</a> </i>
	</nav>
	<div class="container-fluid text-center">
		<div>
			<img src="<%=serverurl + lp.getZplj()%>" alt=" <%=lp.getLpmc()%>" "/>
		</div>
		<div class="lpmc">
			<h3><%=lp.getLpmc()%></h3>
		</div>
		<div>
			需要积分：<i class="money"><img src="img/money.png" /> </i><%=lp.getLpdj()%>
		</div>
		<div>
			还剩<span id="kcsl"><%=lp.getKcsl()%></span>个
		</div>
		<div>
			<form action="checkout.jsp" class="form-horizontal">
				<input type="hidden" name="lpbh" value="<%=lp.getLpbh()%>">
				<div class="form-group">
					<label for="xfje" class="col-xs-6">兑换数量：</label>
					<div class="input-group" class="col-xs-6" style="width: 130px;">
						<div class="input-group-addon" id="jian">-</div>
						<input type="text" class="form-control" name="dhsl" id="dhsl">
						<div class="input-group-addon" id="jia">+</div>
					</div>
				</div>
				<button type="submit"
					style="width:100%;background-color: #ff9800;border-color: #FF9800;"
					class="btn btn-primary btn-block">确认</button>
			</form>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#dhsl").attr("value", "0");
			$("#jian").click(function() {
				var sl = $("#dhsl").attr("value");
				if (sl === null) {
					$("#dhsl").attr("value", 0);
				} else if (parseInt(sl, 10) > 0) {
					$("#dhsl").attr("value", parseInt(sl, 10) - 1);
				}
			});

			$("#jia").click(function() {
				var sl = $("#dhsl").attr("value");
				var kcsl = $("#kcsl").html();
				if (parseInt(kcsl, 10) >= parseInt(sl, 10)) {
					$("#dhsl").attr("value", parseInt(sl, 10) + 1);
				}
			});
			$("form").submit(function() {
				var sl = $("#dhsl").attr("value");
				var kcsl = $("#kcsl").html();
				if (sl === null) {
					$("#dhsl").attr("value", 0);
				} else if (parseInt(kcsl, 10) < parseInt(sl, 10)) {
					alert("兑换数量不能超过剩余数量！");
					return false;
				} else if (parseInt(sl, 10) === 0) {
					alert("兑换数量不能为0！");
					return false;
				}
			});
		});
	</script>
</body>
</html>
