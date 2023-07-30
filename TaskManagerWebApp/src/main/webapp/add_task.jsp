<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Task</title>
<%@include file="component/css_codes.jsp"%>
</head>
<body style="background-color:#F4F4F4">
	<%@include file="component/navbar.jsp"%>
	<div class="container">
		<div class="row p-5">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center">Add Task</h3>
						<form action="add_task" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Add Task</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="New Task" name="task"/>
							</div>
							<div class="form-group">
								<label for="inputState">Status</label> <select id="inputState"
									class="form-control" name="status">
									<option selected>Select</option>
									<option value="Pending">Pending</option>
									<option value="Completed">Completed</option>
								</select>
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Add</button>
							</div>
						</form>
					</div>
				</div>

			</div>

		</div>

	</div>
</body>
</html>