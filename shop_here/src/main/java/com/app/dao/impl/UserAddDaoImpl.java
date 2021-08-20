package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import com.app.dao.UserAddDao;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.UserDetails;

public class UserAddDaoImpl implements UserAddDao{

	@Override
	public int createUser(UserDetails userDetails) throws BusinessException {
		int c=0;
		try(Connection connection = SqlDbConnection.getConnection()){

			
			
			
			
			String sql ="insert into user(user_first_name,user_last_name,user_contact,user_card_no,user_email,user_password) values(?,?,?,?,?,?)"; 
			PreparedStatement preparedStatement =connection.prepareStatement(sql);

			

		
			preparedStatement.setString(1, userDetails.getUserFirstName());
			preparedStatement.setString(2, userDetails.getUserLastName());
			preparedStatement.setLong(3, userDetails.getUserContact());
			preparedStatement.setLong(4, userDetails.getUserCardNo());
			preparedStatement.setString(5, userDetails .getUserEmail());
			preparedStatement.setString(6, userDetails.getUserPassword());

			c=preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new BusinessException("Internal Error");
		} 
		return c;
	}


}
