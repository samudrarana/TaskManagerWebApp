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
import com.entity.TodoDetails;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String task=req.getParameter("task");
		String status=req.getParameter("status");
		
		TaskDAO dao=new TaskDAO(DBConnect.getConn());
		TodoDetails t=new TodoDetails();
		t.setId(id);
		t.setTodo(task);
		t.setStatus(status);
		
		
		boolean f=dao.updateTask(t);
		HttpSession session=req.getSession();
		if(f) {
			session.setAttribute("msg", "Task updated successfully");
			resp.sendRedirect("index.jsp");
		}else {
			session.setAttribute("failedMsg", "Error-Task not updated.");
			resp.sendRedirect("index.jsp");
		}
		
	}
	

}
