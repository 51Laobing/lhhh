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
	String lpbh = request.getParameter("lpbh");
	LiPin lp = MySQLUtil.getLiPinById(lpbh);
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
			<form action="editlpServlet" method="post">
				<div class="control-group">
					<label class="laber_from">物品编号：</label>
					<div class="controls">
						<input class="input_from" placeholder=" 请输入物品编号" type="text"
							value="<%=lp.getLpbh()%>" disabled="disabled"> <input
							type="hidden" name="lpbh" value="<%=lp.getLpbh()%>" />
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from">物品名称：</label>
					<div class="controls">
						<input class="input_from" placeholder=" 请输入物品名称" type="text"
							name="lpmc" value="<%=lp.getLpmc()%>">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from">兑换所需积分：</label>
					<div class="controls">
						<input class="input_from" placeholder=" 请输入积分" type="text"
							name="lpdj" value="<%=lp.getLpdj()%>">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from">物品总数：</label>
					<div class="controls">
						<input class="input_from" placeholder=" 请输入物品总数" type="text"
							name="lpzs" value="<%=lp.getLpzs()%>">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from">剩余库存：</label>
					<div class="controls">
						<input class="input_from" placeholder=" 请输入剩余库存" type="text"
							name="kcsl" value="<%=lp.getKcsl()%>">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from">商品图片：</label>
					<div class="controls">
						<img alt="商品图片" src="<%=lp.getZplj()%>" style="width: 200px;"> <input
							type="hidden" name="zplj" value="<%=lp.getZplj()%>" />
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from"></label>
					<div class="controls">
						<input type="submit" value="编辑" class="btn btn-success"
							style="width:120px;" />
						<input type="button" value="删除" onclick="deletelp('<%=lp.getLpbh()%>')" class="btn btn-success"
							style="width:120px;" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>