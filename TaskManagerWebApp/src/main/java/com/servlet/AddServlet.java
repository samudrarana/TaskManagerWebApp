package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.TaskDAO;
import com.db.DBConnect;
@WebServlet("/add_task")
public class AddServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String task=req.getParameter("task");
		String status=req.getParameter("status");
		
		TaskDAO dao=new TaskDAO(DBConnect.getConn());
		boolean f=dao.addTodo(task, status);
		HttpSession session=req.getSession();
		if(f) {
				session.setAttribute("msg", "Task added successfully");
				resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("failedMsg", "Task not added.");
			resp.sendRedirect("index.jsp");
		}
		
	}

	
	
}
