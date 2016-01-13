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
		response.setCharacterEncoding("UTF-8");
		// 获取session
		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {
			response.sendRedirect("index.jsp?page=user");
			return;
		}

		String userid = request.getParameter("userid");
		String nc = request.getParameter("nc");
		String zjjf = request.getParameter("zjjf");

		boolean result = MySQLUtil.updateUserJfById(userid,
				Integer.parseInt(zjjf));
		if (result) {
			request.getSession().setAttribute(
					"userjfmessage",
					"用户Id： <strong>" + userid + "</strong> 昵称：<strong>" + nc
							+ "</strong> 成功增加：<strong>" + zjjf
							+ "</strong>  积分！");
			response.sendRedirect("index.jsp?page=user");
		} else {
			request.getSession().setAttribute(
					"userjfmessage",
					"用户Id： <strong>" + userid + "</strong> 昵称：<strong>" + nc
							+ "</strong> 增加积分失败！");
			response.sendRedirect("index.jsp?page=user");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
