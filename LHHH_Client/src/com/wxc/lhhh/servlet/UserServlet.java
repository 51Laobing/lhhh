package com.wxc.lhhh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxc.lhhh.util.MySQLUtil;

public class UserServlet extends HttpServlet {

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
		String newnc = request.getParameter("newnc");

		boolean result = MySQLUtil.updateUserNcById(id, newnc);
		if (result) {
			session.setAttribute("message",
					"<div class='yes_img'></div><p>昵称修改成功！</p>");
			response.sendRedirect("message.jsp");
			return;
		} else {
			session.setAttribute("message",
					"<div class='no_img'></div><p>昵称修改失败！</p>");
			response.sendRedirect("message.jsp");
			return;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
