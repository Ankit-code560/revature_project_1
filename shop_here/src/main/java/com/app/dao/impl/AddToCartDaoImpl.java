package com.app.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.app.dao.AddToCartDao;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

public class AddToCartDaoImpl implements AddToCartDao{

	private static Logger log= Logger.getLogger(AddToCartDaoImpl.class);
	int res=0;
	@Override
	public int addTocart(int user,int pid,int quant) throws BusinessException {
		
		try(Connection connection = SqlDbConnection.getConnection()){
			String sql= "insert into cart(p_id,u_id,quantity) values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, pid);
			preparedStatement.setInt(2, user);
			preparedStatement.setInt(3, quant);
			
			res= preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			log.info(e.getMessage());
		}
		return res;
	}
	

}
