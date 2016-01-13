package com.wxc.lhhh.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxc.lhhh.util.MD5Util;
import com.wxc.lhhh.util.MySQLUtil;

public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		Enumeration<String> em = request.getSession().getAttributeNames();
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		
		
		String id = request.getParameter("id");
		String mm = request.getParameter("mm");
		String nc = request.getParameter("nc");
		String md5mm = MD5Util.getMd5(mm);
		boolean result = MySQLUtil.saveUserInfo(id, md5mm, nc);

		if (result) {
			request.getSession().setAttribute("message",
					"<div class='yes_img'></div><p>注册成功！</p>");
			response.sendRedirect("message.jsp");
			return;
		} else {
			request.getSession().setAttribute("message",
					"<div class='no_img'></div><p>注册失败，该手机号已注册！</p>");
			response.sendRedirect("message.jsp");
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
