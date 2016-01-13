<%@page import="java.util.List"%>
<%@page import="com.wxc.lhhh.model.FaPiao"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String admin = "";
	//取得Session对象
	if (session.getAttribute("login") != null) {
		admin = session.getAttribute("admin").toString();
	} else {
		response.sendRedirect("login.jsp");
		return;
	}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>乐活黄海管理后台</title>
<link rel="stylesheet" href="css/index.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="css/add.css" type="text/css" media="screen">
<link rel="stylesheet" href="css/bootstrap.css" type="text/css"
	media="screen">
<script type="text/javascript" src="js/jquery.js"></script>
<style type="text/css">
.tbdhwplb img {
	height: 150px;
}
</style>
</head>
<body>
	<!--顶部-->
	<div class="layout_top_header">
		<div style="float: left">
			<span
				style="font-size: 16px;line-height: 45px;padding-left: 20px;color: #8d8d8d">乐活黄海管理后台</span>
		</div>
		<div id="ad_setting" class="ad_setting">
			<a class="ad_setting_a" href="javascript:;"> <i
				class="icon-user glyph-icon" style="font-size: 20px"></i> <span><%=admin%></span>
				<i class="icon-chevron-down glyph-icon"></i> </a>
			<ul class="dropdown-menu-uu" style="display: none" id="ad_setting_ul">
				<li class="ad_setting_ul_li"><a href="logoffServlet"><i
						class="icon-signout glyph-icon"></i> <span class="font-bold">退出</span>
				</a></li>
			</ul>
		</div>
	</div>
	<!--顶部结束-->
	<!--菜单-->
	<div class="layout_left_menu">
		<ul class="tendina" id="menu">
			<li class="childUlLi"><a href="#" target="menuFrame"> <i
					class="glyph-icon icon-reorder"></i>发票审核管理</a>
				<ul style="display: none;">
					<li><a id="fpwsh"><i class="glyph-icon icon-chevron-right"></i>未审核</a>
					</li>
					<li><a id="fptg"><i class="glyph-icon icon-chevron-right"></i>审核通过</a>
					</li>
					<li><a id="fpwtg"><i class="glyph-icon icon-chevron-right"></i>审核未通过</a>
					</li>
				</ul></li>
			<li class="childUlLi"><a href="#" target="menuFrame"> <i
					class="glyph-icon icon-reorder"></i>兑换商城管理</a>
				<ul style="display: none;">
					<li><a id="lplb"><i class="glyph-icon icon-chevron-right"></i>兑换物品列表</a>
						<a id="wfhdd"><i class="glyph-icon icon-chevron-right"></i>未发货订单</a>
						<a id="yfhdd"><i class="glyph-icon icon-chevron-right"></i>已发货订单</a>
						<a id="tjlp"><i class="glyph-icon icon-chevron-right"></i>添加商品</a>
					</li>
				</ul></li>
			<li class="childUlLi"><a href="#" target="menuFrame"> <i
					class="glyph-icon icon-reorder"></i>角色管理</a>
				<ul style="display: none;">
					<li><a id="glylb"><i class="glyph-icon icon-chevron-right"></i>管理员列表</a>
						<a id="tjgly"><i class="glyph-icon icon-chevron-right"></i>添加管理员</a>
						<a id="yhlb"><i class="glyph-icon icon-chevron-right"></i>用户列表</a>
					</li>
				</ul></li>
			<li class="childUlLi"><a href="#" target="menuFrame"> <i
					class="glyph-icon icon-reorder"></i>页面设置</a>
				<ul style="display: none;">
					<li><a id="scym"><i class="glyph-icon icon-chevron-right"></i>发票上传页面</a>
					</li>
				</ul></li>
		</ul>
	</div>
	<!--菜单-->
	<div id="layout_right_content" class="layout_right_content"></div>
	<div class="layout_footer">
		<p>Copyright © 2015 乐活黄海</p>
	</div>

	<script type="text/javascript" src="js/tendina.js"></script>
	<script type="text/javascript" src="js/common.js"></script>
</body>
</html>
