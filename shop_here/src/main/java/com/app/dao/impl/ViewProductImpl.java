package com.app.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ViewProducts;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

public class ViewProductImpl implements ViewProducts{

	private static Logger log= Logger.getLogger(ViewProductImpl.class);
	EmployeeProducts employeeProducts =null;
	@Override
	public List<EmployeeProducts> viewProducts() throws BusinessException {
		List<EmployeeProducts> empProducts = new ArrayList<>();
		try(Connection connection = SqlDbConnection.getConnection()){
			String sql = "select id,name,category,price from employee_products";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
		while(resultSet.next()) {
			
			EmployeeProducts employeeProducts = new EmployeeProducts();
			employeeProducts.setpId(resultSet.getInt("id"));
			employeeProducts.setProName(resultSet.getString("name"));
			employeeProducts.setProCategory(resultSet.getString("category"));
			employeeProducts.setProPrice(resultSet.getDouble("price"));
			empProducts.add(employeeProducts);
		}
		if (empProducts.size()==0)
		{
			throw new BusinessException("No items in the Basket");
		}
		
		}catch(ClassNotFoundException | SQLException e)
		{
			log.error(e);
		}
	
		return empProducts;
}
}
