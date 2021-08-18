package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ProductSearchDAO;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

public class ProductSearchDAOImpl implements ProductSearchDAO{

	private static Logger log = Logger.getLogger(ProductSearchDAOImpl.class);
	@Override
	public List<EmployeeProducts> getProductByCategory(String category) throws BusinessException {
		List<EmployeeProducts> productList = new ArrayList<>();
		EmployeeProducts employeeProducts=null;
		try(Connection connection= SqlDbConnection.getConnection()){
		String sql="select id , name,price from employee_products where category=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,category);
		 ResultSet resultSet = preparedStatement.executeQuery();
		 
		 while(resultSet.next()) {
			 employeeProducts= new EmployeeProducts();
			 employeeProducts.setpId(resultSet.getInt("id"));
			 employeeProducts.setProName(resultSet.getString("name"));
			 employeeProducts.setProPrice(resultSet.getDouble("price"));
			 productList.add(employeeProducts);
		 }
		 if(productList.size()==0) {
			 throw new BusinessException("no products");
		 }
		} catch (ClassNotFoundException | SQLException e) {
			log.error(e);
		}
		
		
		return productList;
	}

	
}
