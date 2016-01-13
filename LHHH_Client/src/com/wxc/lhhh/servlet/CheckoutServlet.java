package com.wxc.lhhh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxc.lhhh.util.MySQLUtil;

public class CheckoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		// 取得Session对象
		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {
			response.sendRedirect("login.html");
			return;
		}
		if (null != session.getAttribute("token")) {
			request.getSession().removeAttribute("token");
			String userid = session.getAttribute("id").toString();
			String lpbh = request.getParameter("lpbh");
			int dhsl = Integer.parseInt(request.getParameter("dhsl"));
			String sjhm = request.getParameter("sjhm");
			String fhdz = request.getParameter("fhdz");
			boolean result = MySQLUtil.saveDhjl(userid, sjhm, lpbh, dhsl, fhdz);
			if (result) {
				session.setAttribute("message",
						"<div class='yes_img'></div><p>兑换成功！</p>");
				response.sendRedirect("message.jsp");
				return;
			} else {
				session.setAttribute("message",
						"<div class='no_img'></div><p>兑换失败！</p>");
				response.sendRedirect("message.jsp");
				return;
			}
		} else {
			session.setAttribute("message",
					"<div class='dang_img'></div><p>请勿重复提交！</p>");
			response.sendRedirect("message.jsp");
			return;
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		doGet(request, response);
	}

}
