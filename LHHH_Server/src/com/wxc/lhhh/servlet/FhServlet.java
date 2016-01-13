package com.wxc.lhhh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxc.lhhh.util.MySQLUtil;

public class FhServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		// 取得Session对象
		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		int dhjlid = Integer.parseInt(request.getParameter("dhjlid"));
		boolean result = MySQLUtil.updateFhzt(dhjlid);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(result){
			response.sendRedirect("index.jsp?page=wfhdd");
		}else{
			out.println("操作失败！");
		}
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
