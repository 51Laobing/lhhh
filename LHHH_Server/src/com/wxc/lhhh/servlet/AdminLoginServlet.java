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

public class AdminLoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		String glyyhm = request.getParameter("glyyhm");
		String glymm = request.getParameter("glymm");
		String md5glymm = MD5Util.getMd5(glymm);
		boolean result = MySQLUtil.checkAdminLogin(glyyhm, md5glymm);
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>��½���</TITLE></HEAD>");
		out.println("  <BODY>");
		if (result) {
            //ȡ��Session����
            HttpSession session = request.getSession();
            //����Session����
            session.setAttribute("login", "true");
            session.setAttribute("admin", glyyhm);
            //session.setAttribute("userjfmessage", "");
            //��ת������ҳ��
            response.sendRedirect("index.jsp");
        } else {
            out.println("�û������������");
            out.println("<a href='login.jsp'>���ص�½</a>");
        }
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
