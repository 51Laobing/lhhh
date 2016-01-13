<%@page import="java.util.List"%>
<%@page import="com.wxc.lhhh.model.LiPin"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//取得Session对象
	if (session.getAttribute("login") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
	List<LiPin> lpList = MySQLUtil.findAllLiPin();
	int count = 0;
%>
<div class="route_bg">
	<a>主页</a><i class="glyph-icon icon-chevron-right"></i> <a>兑换商城管理</a><i
		class="glyph-icon icon-chevron-right"></i> <a>兑换物品列表</a>
</div>
<div class="mian_content">
	<div id="page_content">
		<center>
			<h3>兑换物品列表</h3>
		</center>
		<table
			class="table table-striped table-bordered table-condensed tbdhwplb">
			<thead>
				<tr>
					<td>物品编号</td>
					<td>图片</td>
					<td>名称</td>
					<td>积分</td>
					<td>剩余库存</td>
					<td>物品总数</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (LiPin lp : lpList) {
						count = 1;
				%>
				<tr class="text-center">
					<td><%=lp.getLpbh()%></td>
					<td><img class="center-block" src="<%=lp.getZplj()%>"
						alt="<%=lp.getLpmc()%>" /></td>
					<td><%=lp.getLpmc()%></td>
					<td><%=lp.getLpdj()%></td>
					<td><%=lp.getKcsl()%></td>
					<td><%=lp.getLpzs()%></td>
					<td>
						<button onclick="editlp('<%=lp.getLpbh()%>')">编辑</button></td>
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