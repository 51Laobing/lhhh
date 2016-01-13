package com.wxc.lhhh.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxc.lhhh.util.MD5Util;
import com.wxc.lhhh.util.MySQLUtil;

public class PasswordServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");

		// 取得Session对象
		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {
			response.sendRedirect("login.html?page=me");
			return;
		}
		String id = session.getAttribute("id").toString();
		String mm = request.getParameter("mm");
		String newmm = request.getParameter("newmm");
		
		String md5mm = MD5Util.getMd5(mm);
		
		boolean hasuser = MySQLUtil.checkUser(id, md5mm);
		if (hasuser) {
			String md5newmm = MD5Util.getMd5(newmm);
			boolean result = MySQLUtil.updateUserMM(id, md5newmm);
			if (result) {
				session.setAttribute("message",
						"<div class='yes_img'></div><p>修改密码成功！</p>");
				response.sendRedirect("message.jsp");
				return;
			} else {
				session.setAttribute("message",
						"<div class='no_img'></div><p>修改密码失败！</p>");
				response.sendRedirect("message.jsp");
				return;
			}
		} else {
			session.setAttribute("message",
					"<div class='no_img'></div><p>旧密码错误！</p>");
			response.sendRedirect("message.jsp");
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
