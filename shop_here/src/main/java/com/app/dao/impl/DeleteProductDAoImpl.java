package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import com.app.dao.DeleteProductDAo;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

public class DeleteProductDAoImpl implements DeleteProductDAo{

	@Override
	public int deleteProductDao(int id) throws BusinessException {
		int c=0;
		try(Connection connection = SqlDbConnection.getConnection()){
			String sql="delete from employee_products where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			
			c=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("internal error");
		}
		
		return c;
	}
	

}
