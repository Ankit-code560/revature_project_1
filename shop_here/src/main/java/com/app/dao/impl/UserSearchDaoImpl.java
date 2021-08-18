package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.dao.UserSearchDao;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.UserDetails;

public class UserSearchDaoImpl implements UserSearchDao{

	@Override
	public int userSearch(UserDetails userDetails) throws BusinessException {
int j=0;
		try(Connection connection = SqlDbConnection.getConnection()){
			
		String check= "SELECT user_email,user_password from user where user_email=''?'' and user_password=''?''";
		PreparedStatement preparedStatement= connection.prepareStatement(check);

		preparedStatement.setString(1,userDetails.getUserEmail());
		preparedStatement.setString(2,userDetails.getUserPassword());
		
		if(preparedStatement.execute()) {
			String sql="select user_id,user_first_name,user_last_name,user_contact,user_card_no,user_email from user where user_email=?";
			PreparedStatement preparedStatement2= connection.prepareStatement(sql);
			preparedStatement2.setString(1, userDetails.getUserEmail());
			ResultSet resultSet=preparedStatement2.executeQuery();
			
			if(!resultSet.next() ){
			System.out.println("user invalid");
		}else {
			do {
				String data = resultSet.getString("user_first_name");
				if(data!=null) {
					System.out.println(data);
					j+=1;
					return j;
				}
			}while(resultSet.next());
			
		}
		
		}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
			throw new BusinessException("Internal Error");
		}
		
		return j;
	}

}
