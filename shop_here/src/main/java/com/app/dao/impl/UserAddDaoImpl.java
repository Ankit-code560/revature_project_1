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

			
			int id =userDetails.getUserId();
			String check="select exists(select user_id from user where user_id=?)";
			PreparedStatement preparedStatement2 =connection.prepareStatement(check);
			preparedStatement2.setInt(1, id);
			
			String sql ="insert into user(user_id,user_first_name,user_last_name,user_contact,user_card_no,user_email,user_password) values(?,?,?,?,?,?,?)"; 
			PreparedStatement preparedStatement =connection.prepareStatement(sql);

			

			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, userDetails.getUserFirstName());
			preparedStatement.setString(3, userDetails.getUserLastName());
			preparedStatement.setLong(4, userDetails.getUserContact());
			preparedStatement.setLong(5, userDetails.getUserCardNo());
			preparedStatement.setString(6, userDetails .getUserEmail());
			preparedStatement.setString(7, userDetails.getUserPassword());

			c=preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			throw new BusinessException("Internal Error");
		} 
		return c;
	}


}
