package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.app.dao.ViewOrderDao;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Order;
import com.app.model.OrderForEmployee;
import com.app.model.SuccOrder;

public class ViewOrderDaoImpl implements ViewOrderDao{

	private static Logger log= Logger.getLogger(ViewOrderDaoImpl.class);
	SuccOrder order= null;
	@Override
	public List<SuccOrder> viewOrder(int user) throws BusinessException {
		List<SuccOrder> ord = new ArrayList<>();
		
		try(Connection connection = SqlDbConnection.getConnection()){
			String sql= "SELECT e.name,e.price,c.quantity FROM (shop_here.order o join cart c on o.u_id= ?) join employee_products e on e.id= o.p_id  ;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				SuccOrder orrd= new SuccOrder();
				orrd.setName(resultSet.getString("name"));
				orrd.setPrice(resultSet.getDouble("price"));
				orrd.setQuantity(resultSet.getInt("quantity"));
				ord.add(orrd);
				
			}
			if(ord.size()==0) {
				throw new BusinessException("NO Orders in the cart");
			}
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			log.info(e.getMessage());
		}
		return ord;
	}
	
	OrderForEmployee o= null;
	@Override
	public List<OrderForEmployee> viewOrderForEmployee() throws BusinessException {
		List<OrderForEmployee> oo= new ArrayList<>();
		
		try(Connection connection = SqlDbConnection.getConnection()){
			String sql ="SELECT order_id,e.name,u_id from shop_here.order o join employee_products e on e.id=o.p_id";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				OrderForEmployee o= new OrderForEmployee();
				o.setOid(resultSet.getInt("order_id"));
				o.setName(resultSet.getString("name"));
				o.setUid(resultSet.getInt("u_id"));
				oo.add(o);
			}
			
		}catch(SQLException | ClassNotFoundException e) {
			log.info(e);
		}
		if(oo.size()==0) {
			throw new BusinessException("No orders to view");
		}
		return oo;
	}
	
}
