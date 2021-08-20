package com.app.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.dao.AddProductDAo;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

public class AddProductDAoImpl implements AddProductDAo{

	@Override
	public int addProduct(EmployeeProducts employeeProducts) throws BusinessException {
		int c=0;
		try(Connection connection = SqlDbConnection.getConnection()){
			
			String sql= "insert into employee_products(name,category,price) values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, employeeProducts.getProName());
			preparedStatement.setString(2, employeeProducts.getProCategory());
			preparedStatement.setDouble(3,employeeProducts.getProPrice() );
			
			c= preparedStatement.executeUpdate();
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
			throw new BusinessException("internal error");
		}
		
		return c;
	}

}
