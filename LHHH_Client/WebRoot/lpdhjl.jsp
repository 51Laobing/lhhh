<%@page import="com.wxc.lhhh.model.MyDhjl"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//取得Session对象
	if (session.getAttribute("login") == null){
		response.sendRedirect("login.html?page=me");
		return;
	}
	String id = session.getAttribute("id").toString();
	List<MyDhjl> mydhList = MySQLUtil.findAllMyDhjlByUserId(id);
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
		<i class="btn2"><a href="javascript:history.go(-1)">返回</a> </i> <strong>礼品兑换记录</strong>
	</nav>
	<section class="form-group" id="container">
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-4 col-md-4">
					<strong>物品名称</strong>
				</div>
				<div class="col-xs-4 col-md-4">
					<strong>发货状态</strong>
				</div>
				<div class="col-xs-4 col-md-4">
					<strong>扣除积分</strong>
				</div>
			</div>
			<%
				for (MyDhjl mydh : mydhList) {
			%>
			<div class="row">
				<div class="col-xs-4 col-md-4"><%=mydh.getLpmc() + "(" + mydh.getDhsl() + "个)"%></div>
				<div class="col-xs-4 col-md-4">
					<%
						if (mydh.getFhzt().equals("y")) {
								out.print("已发货");
							} else if (mydh.getFhzt().equals("n")) {
								out.print("未发货");
							}
					%>
				</div>
				<div class="col-xs-4 col-md-4">
					<i class="money"><img src="img/money.png" /> </i><%=mydh.getDhsl() * mydh.getLpdj()%></div>
			</div>
			<%
				}
			%>
		</div>
	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>
