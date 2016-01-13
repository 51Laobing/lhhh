<%@page import="java.util.List"%>
<%@page import="com.wxc.lhhh.model.Dhjl"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String admin = "";
	//取得Session对象
	if (session.getAttribute("login") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
	List<Dhjl> dhList = MySQLUtil.findAllDhjl("n");
	int count = 0;
%>
<div class="route_bg">
	<a>主页</a><i class="glyph-icon icon-chevron-right"></i> <a>兑换商城管理</a><i
		class="glyph-icon icon-chevron-right"></i> <a>未发货订单</a>
</div>
<div class="mian_content">
	<div id="page_content">
		<center>
			<h3>未发货订单</h3>
		</center>
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<td>用户ID</td>
					<td>手机号码</td>
					<td>礼品编号</td>
					<td>兑换数量</td>
					<td>扣除积分</td>
					<td>兑换日期</td>
					<td>发货地址</td>
					<td>发货状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (Dhjl dh : dhList) {
						count = 1;
				%>

				<tr>
					<td><%=dh.getUserid()%></td>
					<td><%=dh.getSjhm()%></td>
					<td><%=dh.getLpbh()%></td>
					<td><%=dh.getDhsl()%></td>
					<td><%=dh.getKcjf()%></td>
					<td><%=dh.getDhrq()%></td>
					<td><%=dh.getFhdz()%></td>
					<td>未发货</td>
					<td>
						<form action="fhServlet" method="post">
							<input type='hidden' name='dhjlid' value='<%=dh.getDhjlid()%>' />
							<input type="submit" value="确认发货" />
						</form>
					</td>
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
