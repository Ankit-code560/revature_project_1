package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ViewCartDao;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;

public class ViewCartDAOImpl implements ViewCartDao {

	private static Logger log= Logger.getLogger(ViewCartDAOImpl.class);
	Cart cart=null;
	@Override
	public List<Cart> viewCartByUid(int uid) throws BusinessException {
		List<Cart> ccart=new ArrayList<>();
		try(Connection connection = SqlDbConnection.getConnection()){
			String sql= "SELECT distinct srno,	name,price,quantity FROM cart as c  inner join employee_products as p1 on c.p_id=p1.id inner join user  on c.u_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
			preparedStatement.setInt(1, uid);
	
			ResultSet resultSet = preparedStatement.executeQuery();
				
		while(resultSet.next()) {
				Cart cart= new Cart();
				cart.setCid(resultSet.getInt("srno"));
				cart.setName(resultSet.getString("name"));
				cart.setPrice(resultSet.getDouble("price"));
				cart.setQuantity(resultSet.getInt("quantity"));
					ccart.add(cart);
		
			}
		if(ccart.size()==0)
		{
			throw new BusinessException("noppp items in the cart");
		}
			
	} catch (ClassNotFoundException | SQLException e) {
		log.error(e);
	}
		return ccart;

	
}
}