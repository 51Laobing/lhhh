<%@page import="java.util.List"%>
<%@page import="com.wxc.lhhh.model.User"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String admin = "";
	//取得Session对象
	if (session.getAttribute("login") == null) {
		response.sendRedirect("login.jsp?page=user");
		return;
	}
	String userid = request.getParameter("userid");
	if(userid == null){
		userid="";
	}
	List<User> userList = MySQLUtil.findUserById(userid);
	int count = 0;
%>
<div class="route_bg">
	<a>主页</a><i class="glyph-icon icon-chevron-right"></i> <a>角色管理</a><i
		class="glyph-icon icon-chevron-right"></i> <a>用户列表</a><i class="glyph-icon icon-chevron-right"></i> <a>搜索结果</a>
</div>
<div class="mian_content">
	<div id="page_content">
		<div>${userjfmessage}</div>
		<center>
			<h3>用户搜索结果列表</h3>
		</center>
		<form class="form-inline">
			<div class="form-group">
				<label for="suid">输入手机号搜索用户：</label> <input type="text"
					class="form-control" id="suid" placeholder="请输入要搜索的手机号">
			</div>
			<button type="button" id="searchuser" class="btn btn-default">搜索</button>
		</form>
		<script type="text/javascript">
			$("#searchuser").click(function() {
				var suid = $("#suid").val();
				// 页面加载时执行
				htmlobj = $.ajax({
					url : "searchuser.jsp?userid=" + suid,
					async : false
				});
				$("#layout_right_content").html(htmlobj.responseText);
			});
		</script>
		<hr />
		<table class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<td>用户ID（手机号）</td>
					<td>昵称</td>
					<td>积分</td>
					<td>积分操作</td>
				</tr>
			</thead>
			<tbody>
				<%
					for (User user : userList) {
						count = 1;
				%>
				<tr>
					<td><%=user.getId()%></td>
					<td><%=user.getNc()%></td>
					<td><%=user.getJfye()%></td>
					<td>
						<form action="userServlet" method="post" class="form-inline">
							<input type="hidden" name="userid" value="<%=user.getId()%>" />
							<input type="hidden" name="nc" value="<%=user.getNc()%>" />
							<div class="form-group">
								<input type="text" class="form-control" name="zjjf" />
							</div>
							<button type="submit" class="btn btn-primary">增加积分</button>
						</form></td>
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

