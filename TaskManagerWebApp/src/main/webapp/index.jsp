<%@page import="com.entity.TodoDetails"%>
<%@page import="com.DAO.TaskDAO"%>
<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Manager</title>
<%@include file="component/css_codes.jsp"%>
</head>
<body >
	<%@include file="component/navbar.jsp"%>


	<h1 class="text-center">Manage Your Task</h1>
	<%--For showing the successful msg. --%>
	<%
	String msg = (String) session.getAttribute("msg");
	if (msg != null) {
	%>
	<div class="alert alert-success" role="alert"><%=msg%>
	</div>

	<%
	session.removeAttribute("msg");
	}
	%>
	<%--For showing error msg. --%>
	<%
	String failedMsg = (String) session.getAttribute("failedMsg");
	if (failedMsg != null) {
	%>
	<div class="alert alert-danger" role="alert"><%=failedMsg%>
	</div>

	<%
	session.removeAttribute("msg");
	}
	%>

	<div class="container">
		<table class="table table-striped" border="1">
			<thead class="custom-table" style="background-color: #98EECC;">
				<tr>
					
					<th scope="col">Task</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				TaskDAO dao = new TaskDAO(DBConnect.getConn());
				List<TodoDetails> todo = dao.getTodo();
				for (TodoDetails t : todo) {
				%>
				<tr>
					
					<td><%=t.getTodo() %></td>
					<td><%=t.getStatus() %></td>
					
					
					<td>
						<a href="edit.jsp?id=<%=t.getId()%>" class="btn btn-sm btn-success">Edit</a> 
						<a href="delete?id=<%=t.getId()%>" class="btn btn-sm btn-danger">Delete</a>
					</td>
				</tr>

				<%
				}
				%>




			</tbody>
		</table>
	</div>
</body>
</html>