package com.DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.entity.TodoDetails;
import com.mysql.cj.jdbc.ServerPreparedStatement;

public class TaskDAO {
	
	private Connection conn;

	public TaskDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addTodo(String todo,String status) {
		boolean f=false;
		try {
			String sql="insert into task(todo,status) values(?,?)";
			
			PreparedStatement ps= conn.prepareStatement(sql);
			ps.setString(1,todo);
			ps.setString(2,status);
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public List<TodoDetails> getTodo(){
		List<TodoDetails> list=new ArrayList<TodoDetails>();
		TodoDetails t=null;
		
		try {
			String sql="select * from task";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				t=new TodoDetails();
				/* Id has column no=1
				 * Todo has column no=2
				 * Status has column no=3*/
				t.setId(rs.getInt(1));
				t.setTodo(rs.getString(2));
				t.setStatus(rs.getString(3));
				list.add(t);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public TodoDetails getTaskById(int id) {
		TodoDetails t=null;
		try {
			String sql="select * from task where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				t=new TodoDetails();
				/* Id has column no=1
				 * Todo has column no=2
				 * Status has column no=3*/
				t.setId(rs.getInt(1));
				t.setTodo(rs.getString(2));
				t.setStatus(rs.getString(3));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	//for update
	public boolean updateTask(TodoDetails t) {
		boolean f=false;
		try {
			String sql="update task set todo=?,status=? where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1,t.getTodo());
			ps.setString(2,t.getStatus());
			ps.setInt(3, t.getId());
			
			int i=ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	//For Delete Button
	public boolean deleteTodo(int id) {
		boolean f=false;
		try {
			String sql="delete from task where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i= ps.executeUpdate();
			if(i==1) {
				f=true;
			}
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		return f;
	}
}
