package com.icss.hr.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.hr.admin.service.AdminService;
import com.icss.hr.admin.service.impl.AdminServiceImpl;
import com.icss.hr.admin.vo.Admin;

public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService service = new AdminServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			request.setCharacterEncoding("utf-8");
			//2.获得参数
			String adminName = request.getParameter("adminname");
			String adminPwd = request.getParameter("adminpwd");
			String adminLevel = request.getParameter("adminlevel");
			
			Admin uiAdmin = new Admin(adminName,adminPwd,Integer.parseInt(adminLevel));
			//获得service结果
			
			int res = service.queryLogin(uiAdmin);
			response.setContentType("text/html;charset=utf-8");
			
			if(res>0){
				//存储cookie信息
				Cookie cookie = new Cookie("admin", uiAdmin.getAdminName());
				cookie.setMaxAge(60*60*24*3);
				response.addCookie(cookie);
				HttpSession session = request.getSession();
				session.setAttribute("admin", uiAdmin);
				//登录成功,使用重定向
				response.sendRedirect(request.getContextPath()+"/main.jsp");
			}else{
				if(res==-1){
					request.setAttribute("inputmsg", "您输入的用户名不存在");
				}else if(res==-2){
					request.setAttribute("inputmsg", "您输入的密码不正确");
				}else{
					request.setAttribute("inputmsg", "您选择的权限不正确");
				}
				//验证不通过,使用请求转发，一次请求
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			//出现异常跳转,请求转发
			request.setAttribute("errormsg", ex.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
}
