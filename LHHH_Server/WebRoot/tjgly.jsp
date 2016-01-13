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
		class="glyph-icon icon-chevron-right"></i> <a>添加管理员</a>
</div>
<div class="mian_content">
	<div id="page_content">
		<center>
			<h3>添加管理员</h3>
		</center>
		<div class="div_from_aoto" style="width: 500px;">
			<form action="tjglyServlet" method="post">
				<div class="control-group">
					<label class="laber_from">用户名</label>
					<div class="controls">
						<input class="input_from" placeholder=" 请输入用户名" type="text"
							name="glyyhm">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from">密码</label>
					<div class="controls">
						<input class="input_from" placeholder=" 请输入密码" type="password"
							name="glymm">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from"></label>
					<div class="controls">
						<input type="submit" value="确认" class="btn btn-success"
							style="width:120px;" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>