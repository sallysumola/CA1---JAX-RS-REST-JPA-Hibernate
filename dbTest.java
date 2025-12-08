package com.example.dao;

import com.example.dao.UserDAO;
import com.example.dit.model.User;

import java.sql.SQLException;


public class dbTEST {
	
	

	public dbTEST() {
		User user = new User ("John", "secret88");
		UserDAO userdao = new UserDAO();
		userdao.persist(user);
	}
	
	public static void main(String[] args) {
		new dbTEST();
	}
	
	
	
