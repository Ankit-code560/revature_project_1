package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.PlaceOrderDao;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Order;


public class PlaceOrderDaoImpl implements PlaceOrderDao{

	private static Logger log= Logger.getLogger(PlaceOrderDaoImpl.class);
	@Override
	public int placeOrder(int user) throws BusinessException {
		List<Order> or= new ArrayList<>();
		Order order = null;
		int pid=0;
		int c=0;
		try(Connection connection= SqlDbConnection.getConnection()){
			
			String sql= "select p_id,u_id from cart where u_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
			order= new Order();
			order.setPid(resultSet.getInt("p_id"));
			order.setUid(resultSet.getInt("u_id"));
			order.setStatus(1);
			or.add(order);
			}
			
			
			String sql2="insert into shop_here.order(u_id,p_id,status) values(?,?,?)";
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			
			for(Order oo:or) {
			preparedStatement2.setInt(1,oo.getUid() );
			preparedStatement2.setInt(2,oo.getPid());
			preparedStatement2.setInt(3, oo.getStatus());
			}
			c= preparedStatement2.executeUpdate();
			
			
			String sql3= "delete from cart where u_id=?";
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement3.setInt(1, user);
			c=preparedStatement3.executeUpdate();
			return c;
			
			}
			
		
		catch( ClassNotFoundException | SQLException e) {
			log.info(e);
		}
		
		
		return c;
	}
}
