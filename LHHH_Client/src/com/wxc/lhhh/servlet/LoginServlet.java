package com.wxc.lhhh.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxc.lhhh.util.MD5Util;
import com.wxc.lhhh.util.MySQLUtil;

public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ȡ��Session����
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		Enumeration<String> em = request.getSession().getAttributeNames();
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString());
		}
		
		String id = request.getParameter("id");
		String mm = request.getParameter("mm");
		String page = request.getParameter("page");

		String md5mm = MD5Util.getMd5(mm);

		boolean result = MySQLUtil.checkUser(id, md5mm);

		if (result) {

			// ����Session����
			session.setAttribute("login", "true");
			session.setAttribute("id", id);

			if (page.equals("me")) {
				// ��ת������ҳ��
				response.sendRedirect("me.jsp");
				return;
			} else if (page.equals("upload")) {
				// ��ת������ҳ��
				response.sendRedirect("upload.jsp");
				return;
			} else {
				// ��ת������ҳ��
				response.sendRedirect("index.jsp");
				return;
			}
		} else {
			session.setAttribute("message",
					"<div class='no_img'></div><p>�û�����������������ԣ�</p>");
			response.sendRedirect("message.jsp");
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
