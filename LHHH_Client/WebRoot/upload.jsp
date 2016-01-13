<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.wxc.lhhh.util.MySQLUtil"%>
<%
	//取得Session对象
	if (session.getAttribute("login") == null) {
		response.sendRedirect("login.html?page=upload");
		return;
	}
	String serverurl = MySQLUtil.findValueByKey("server_url");
	String uploadimgurl = MySQLUtil.findValueByKey("upload_img_url");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>晒发票，抢免单</title>

<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<link href="css/mstyle.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

</head>

<body style="background-color: blanchedalmond;">
	<nav class="nav3 p"> <i class="btn2"><a
		href="javascript:history.go(-1)">返回</a> </i> <strong>上传发票，抢免单</strong> <i
		class="btn3"><a href="index.jsp">首页</a> </i> </nav>
	<div class="container-fluid" style="margin-top: 15px;">
		<!-- <div class="container-fluid">
			<p class="text-primary">上传发票，抢免单的机会来了~</p>
		</div> -->
		<div class="center-block">
			<img src="<%=serverurl + uploadimgurl%>" alt="上传发票，赢取免单"
				class="img-rounded img-responsive">
		</div>
		<form action="uploadHandleServlet" enctype="multipart/form-data"
			method="post" style="margin-top: 10px;">
			<div class="form-group">
				<label for="shmc">商户名称：</label> <input type="text"
					class="form-control" name="shmc" placeholder="商户名称">
			</div>
			<div class="form-group">
				<label for="lxdh">手机号码：</label> <input type="text"
					class="form-control" name="lxdh" placeholder="手机号码">
			</div>
			<div class="form-group">
				<label for="xfje">消费金额：</label>
				<div class="input-group">
					<div class="input-group-addon">&yen;</div>
					<input type="text" class="form-control" name="xfje"
						placeholder="消费金额">
					<div class="input-group-addon">元</div>
				</div>
			</div>
			<!-- <div class="form-group">
				<label for="fpdm">发票代码：</label> <input type="text"
					class="form-control" name="fpdm" placeholder="发票代码">
			</div>
			<div class="form-group">
				<label for="fphm">发票号码：</label> <input type="text"
					class="form-control" name="fphm" placeholder="发票号码">
			</div> -->
			<div class="form-group">
				<label for="fpimg">发票正面清晰照片：</label> <input type="file" name="fpimg">
				<p class="help-block">照片大小不能超过10M.</p>
			</div>
			<button type="submit" class="btn btn-primary btn-block"
				style="width:100%;background-color: #ff9800;border-color: #FF9800;">提交</button>
		</form>
	</div>
	<%@ include file="footer.jsp"%>
	<script type="text/javascript">
		$("form").submit(function() {
			var shmc = $("input[name='shmc']").val();
			var lxdh = $("input[name='lxdh']").val();
			var xfje = $("input[name='xfje']").val();
			//var fpdm = $("input[name='fpdm']").val();
			//var fphm = $("input[name='fphm']").val();
			var fpimg = $("input[name='fpimg']").val();
			if (!$.trim(shmc)) {
				alert("商户名称  不能为空!");
				return false;
			} else if (!$.trim(lxdh)) {
				alert("联系电话 不能为空!");
				return false;
			} else if (!$.trim(xfje)) {
				alert("消费金额  不能为空!");
				return false;
			} else if (!$.trim(fpdm)) {
				//alert("发票代码  不能为空!");
				//return false;
			} else if (!$.trim(fphm)) {
				//alert("发票号码  不能为空!");
				//return false;
			} else if (!$.trim(fpimg)) {
				alert("发票照片 不能为空!");
				return false;
			}
		});
	</script>
</body>
</html>
