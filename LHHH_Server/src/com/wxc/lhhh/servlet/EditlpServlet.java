package com.wxc.lhhh.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wxc.lhhh.model.LiPin;
import com.wxc.lhhh.util.MySQLUtil;

public class EditlpServlet extends HttpServlet {

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
			response.sendRedirect("index.jsp?page=tjlp");
			return;
		}
		
		String lpbh = request.getParameter("lpbh");
		String lpmc = request.getParameter("lpmc");
		String lpdj = request.getParameter("lpdj");
		String lpzs = request.getParameter("lpzs");
		String kcsl = request.getParameter("kcsl");
		String zplj = request.getParameter("zplj");
		
		LiPin lp = new LiPin();
		lp.setLpbh(lpbh);
		lp.setLpmc(lpmc);
		lp.setLpdj(Integer.parseInt(lpdj));
		lp.setLpzs(Integer.parseInt(lpzs));
		lp.setKcsl(Integer.parseInt(kcsl));
		lp.setZplj(zplj);
		
		// 保存到数据库
		boolean result = MySQLUtil.updateLp(lp);
		
		if(result){
			response.sendRedirect("index.jsp?page=lp");
			
		} else {
			request.getSession().setAttribute("message",
					"<div class='no_img'></div><p>更新失败！</p>");
			response.sendRedirect("message.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
