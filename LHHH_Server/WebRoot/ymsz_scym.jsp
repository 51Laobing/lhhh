<%@page import="java.util.List"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	//取得Session对象
	if (session.getAttribute("login") == null) {
		response.sendRedirect("login.jsp");
		return;
	}
	String serverurl = MySQLUtil.findValueByKey("server_url");
	String uploadimgurl = MySQLUtil.findValueByKey("upload_img_url");
%>
<div class="route_bg">
	<a>主页</a><i class="glyph-icon icon-chevron-right"></i> <a>页面设置</a><i
		class="glyph-icon icon-chevron-right"></i> <a>发票上传页面</a>
</div>
<div class="mian_content">
	<div id="page_content">
		<center>
			<h3>发票上传页面图片设置</h3>
		</center>
		<div class="div_from_aoto" style="width: 500px;">
			<div class="center-block">
				<img src="<%=serverurl + uploadimgurl%>" alt="上传发票，赢取免单"
					class="img-rounded img-responsive">
			</div>
			<br/>
			<form action="scymServlet" method="post"
				enctype="multipart/form-data">
				<div class="control-group">
					<label class="laber_from">上传图片：</label>
					<div class="controls">
						<input class="input_from" type="file" name="lpimg">
						<p class="help-block"></p>
					</div>
				</div>
				<div class="control-group">
					<label class="laber_from"></label>
					<div class="controls">
						<input type="submit" value="上传" class="btn btn-success"
							style="width:120px;" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
