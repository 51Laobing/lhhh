<%@page import="com.wxc.lhhh.model.LiPin"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//取得Session对象
	if (session.getAttribute("login") == null) {
		response.sendRedirect("login.html");
		return;
	}
	List<LiPin> lpList = MySQLUtil.findAllLiPin();
	String serverurl = MySQLUtil.findValueByKey("server_url");
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>兑换商城</title>

<link rel="stylesheet" href="css/mstyle.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="css/style.css" type="text/css">

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body class="bodybgs">
	<nav class="nav3 p">
		<i class="btn2"><a href="javascript:history.go(-1)">返回</a> </i> <strong>兑换商城</strong>
		<i class="btn3"><a href="me.jsp">我</a> </i>
	</nav>
	<div class="container-fluid">
		<ul>
			<%
				for (LiPin lp : lpList) {
			%>
			<li class="col-xs-6 lp"><a
				href="product.jsp?lpbh=<%=lp.getLpbh()%>">
					<div class="imgdiv box">
						<img alt="<%=lp.getLpmc()%>" src="<%=serverurl + lp.getZplj()%>"
							class="img-rounded" />
					</div>
					<div class="lpinfo">
						<span class="lpmc"><%=lp.getLpmc()%></span><br /> <span
							class="lpdj"><i class="money"><img src="img/money.png" />
						</i><%=lp.getLpdj()%></span><span class="lpsl">还剩<%=lp.getKcsl()%>个</span>
					</div> </a> <a href="product.jsp?lpbh=<%=lp.getLpbh()%>"
				class="btn btn-primary btn-sm active"
				style="width:100%;background-color: #ff9800;border-color: #FF9800;"
				role="button">我要兑换</a></li>
			<%
				}
			%>
			<li class="col-xs-12 lp" style="height:15px;"></li>
		</ul>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
