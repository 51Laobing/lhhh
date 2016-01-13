<%@page import="java.util.List"%>
<%@page import="com.wxc.lhhh.model.Admin"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//取得Session对象
	if (session.getAttribute("login") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
	List<Admin> glyList = MySQLUtil.findAllAdmin();
	int count = 0;
%>
<div class="route_bg">
	<a>主页</a><i class="glyph-icon icon-chevron-right"></i> <a>角色管理</a><i
		class="glyph-icon icon-chevron-right"></i> <a>管理员列表</a>
</div>
<div class="mian_content">
	<div id="page_content">
		<center>
			<h3>管理员列表</h3>
		</center>
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<td>管理员ID</td>
					<td>管理员用户名</td>
					<td>管理员密码</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (Admin gly : glyList) {
						count = 1;
				%>
				<tr>
					<td><%=gly.getGlyid()%></td>
					<td><%=gly.getGlyyhm()%></td>
					<td>**********</td>
					<td></td>
				</tr>
				<%
					}
					if (count == 0) {
				%>
				<tr>
					<h3>暂无数据！</h3>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</div>