<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>乐活黄海后台管理系统</title>
<style type="text/css">
body {
	background: #0066A8 url(img/login_bg.png) no-repeat center 0px;
}

.tit {
	margin: auto;
	margin-top: 170px;
	text-align: center;
	width: 350px;
	padding-bottom: 20px;
}

.login-wrap {
	width: 220px;
	padding: 30px 50px 0 330px;
	height: 220px;
	background: #fff url(img/loginbg.jpg) no-repeat 30px 40px;
	margin: auto;
	overflow: hidden;
}

.login_input {
	display: block;
	width: 210px;
}

.login_user {
	background: url(img/input_icon_1.png) no-repeat 200px center;
	font-family: "Lucida Sans Unicode", "Lucida Grande", sans-serif
}

.login_password {
	background: url(img/input_icon_2.png) no-repeat 200px center;
	font-family: "Courier New", Courier, monospace
}

.btn-login {
	background: #40454B;
	box-shadow: none;
	text-shadow: none;
	color: #fff;
	border: none;
	height: 35px;
	line-height: 26px;
	font-size: 14px;
	font-family: "microsoft yahei";
}

.btn-login:hover {
	background: #333;
	color: #fff;
}

.copyright {
	margin: auto;
	margin-top: 10px;
	text-align: center;
	width: 370px;
	color: #CCC
}

@media ( max-height : 700px) {
	.tit {
		margin: auto;
		margin-top: 100px;
	}
}

@media ( max-height : 500px) {
	.tit {
		margin: auto;
		margin-top: 50px;
	}
}
</style>
</head>

<body>
	<div class="tit">
		<img src="img/tit.png" alt="" />
	</div>
	<form action="adminLoginServlet" method="post">
		<div class="login-wrap">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="25" valign="bottom">用户名：</td>
				</tr>
				<tr>
					<td><input type="text" class="login_input login_user"
						name="glyyhm" />
					</td>
				</tr>
				<tr>
					<td height="35" valign="bottom">密 码：</td>
				</tr>
				<tr>
					<td><input type="password" class="login_input login_password"
						name="glymm" />
					</td>
				</tr>
				<tr>
					<td height="60" valign="bottom"><input style="width:100%;"" type="submit"
						value="登陆" class="btn btn-block btn-login" />
					</td>
				</tr>

			</table>
		</div>
	</form>
	<div class="copyright">建议使用IE8以上版本或谷歌浏览器</div>
</body>
</html>
