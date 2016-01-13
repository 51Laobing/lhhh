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
	String serverurl = MySQLUtil.findValueByKey("server_url");
%>
<div class="route_bg">
	<a>主页</a><i class="glyph-icon icon-chevron-right"></i> <a>兑换商城管理</a><i
		class="glyph-icon icon-chevron-right"></i> <a>添加商品</a>
</div>
<div class="mian_content">
	<div id="page_content">
		<center>
			<h3>添加商品</h3>
		</center>
		<div class="div_from_aoto" style="width: 500px;">
			<form action="tjlpServlet" method="post" enctype="multipart/form-data">
				<div class="control-group">
					<label class="laber_from">物品编号：</label>
					<div class="controls">
						<input class="input_from" placeholder=" 请输入物品编号" type="text"
							name="lpbh">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from">物品名称：</label>
					<div class="controls">
						<input class="input_from" placeholder=" 请输入物品名称" type="text"
							name="lpmc">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from">兑换所需积分：</label>
					<div class="controls">
						<input class="input_from" placeholder=" 请输入积分" type="text"
							name="lpdj">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from">物品总数：</label>
					<div class="controls">
						<input class="input_from" placeholder=" 请输入物品总数" type="text"
							name="lpzs">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from">剩余库存：</label>
					<div class="controls">
						<input class="input_from" placeholder=" 请输入剩余库存" type="text"
							name="kcsl">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from">上传图片：</label>
					<div class="controls">
						<input class="input_from" type="file"
							name="lpimg">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from"></label>
					<div class="controls">
						<input type="submit" value="添加" class="btn btn-success"
							style="width:120px;" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>