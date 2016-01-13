package com.wxc.lhhh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxc.lhhh.util.MD5Util;
import com.wxc.lhhh.util.MySQLUtil;

public class TjglyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 取得Session对象
		HttpSession session = request.getSession();
		if (session.getAttribute("login") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		response.setContentType("text/html");
		
		String glyyhm = request.getParameter("glyyhm");
		String glymm = request.getParameter("glymm");
		String md5glymm = MD5Util.getMd5(glymm);
		boolean result = MySQLUtil.saveAdmin(glyyhm, md5glymm);
		PrintWriter out = response.getWriter();
		if(result){
			response.sendRedirect("index.jsp?page=glylb");
			return;
		}else{
			out.println("系统错误！添加失败！");
		}
		out.flush();
		out.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
