<%@page import="com.DAO.TaskDAO"%>
<%@page import="com.entity.TodoDetails"%>
<%@page import="com.db.DBConnect"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
<%@include file="component/css_codes.jsp"%>
</head>
<body style="background-color: #ECF2FF">
	<%@include file="component/navbar.jsp"%>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h3 class="text-center">Edit Task</h3>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						TaskDAO dao = new TaskDAO(DBConnect.getConn());
						TodoDetails t = dao.getTaskById(id);
						%>


						<form action="update" method="post">
						<input type="hidden" value="<%=t.getId()%>" name="id">
						
							<div class="form-group">
								<label for="exampleInputEmail1">Add Task</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="New Task" name="task"
									value="<%=t.getTodo()%>" />
							</div>
							<div class="form-group">
								<label for="inputState">Status</label> <select id="inputState"
									class="form-control" name="status">
									<%
									if ("Pending".equals(t.getStatus())) {
									%>
									<option value="Pending">Pending</option>
									<option value="Completed">Completed</option>

									<%
									} else {
									%>
										<option value="Completed">Completed</option>
										<option value="Pending">Pending</option>
									<%
									}
									%>

									
									
									
								</select>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Update</button>
							</div>
						</form>
					</div>
				</div>

			</div>

		</div>

	</div>
</body>
</html>