<%@page import="java.util.List"%>
<%@page import="com.wxc.lhhh.model.FaPiao"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String admin = "";
	//取得Session对象
	if (session.getAttribute("login") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
	List<FaPiao> fpList = MySQLUtil.findAllFaPiao();
	int count = 0;
	String clienturl = MySQLUtil.findValueByKey("client_url");
%>
<div class="route_bg">
	<a>主页</a><i class="glyph-icon icon-chevron-right"></i> <a>发票审核管理</a><i
		class="glyph-icon icon-chevron-right"></i> <a>审核未通过</a>
</div>
<div class="mian_content">
	<div id="page_content">
	<center><h3>发票审核未通过</h3></center>
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<td>用户ID</td>
					<td>商铺名称</td>
					<td>手机号</td>
					<td>消费金额</td>
					<td>图片预览</td>
					<td>审核状态</td>
					<td>积分</td>
					<td>审核日期</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (FaPiao fp : fpList) {
						if (fp.getShzt().equals("f")) {
						count = 1;
				%>
				<tr>
					<td><%=fp.getUserid()%></td>
					<td><%=fp.getShmc()%></td>
					<td><%=fp.getLxdh()%></td>
					<td><%=fp.getXfje()%></td>
					<td><a
						href="<%=clienturl+fp.getZplj()%>"
						target="_blank">查看发票</a>
					</td>
					<td>审核未通过</td>
					<td><%=fp.getJf()%></td>
					<td><%=fp.getShrq()%></td>
					<td></td>
				</tr>
				<%
					}
					}
					if (count == 0) {
				%>
				<tr><h3>暂无数据！</h3></tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</div>