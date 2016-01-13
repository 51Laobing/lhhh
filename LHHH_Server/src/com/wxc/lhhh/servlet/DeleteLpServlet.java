package com.wxc.lhhh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxc.lhhh.util.MySQLUtil;

public class DeleteLpServlet extends HttpServlet {

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
			response.sendRedirect("index.jsp?page=lp");
			return;
		}
		
		String lpbh = request.getParameter("lpbh");
		MySQLUtil.deleteLpById(lpbh);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("删除成功！");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
