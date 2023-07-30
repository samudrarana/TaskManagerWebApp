package com.entity;

public class TodoDetails {
	private int id;
	private String todo;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Entity [id=" + id + ", todo=" + todo + ", status=" + status + "]";
	}
	 

}
