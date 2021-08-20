package com.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.app.dao.ReconfirmItemsDaoInCart;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.view.cart.service.ViewCartService;
import com.app.view.cart.service.impl.ViewCartServiceImpl;

public class ReconfirmItemsDaoInCartImpl implements ReconfirmItemsDaoInCart{
	Scanner sc= new Scanner(System.in);
	int c=0;

	@Override
	public int reconfirmItemsInCart(int user) throws BusinessException {
		
		ViewCartService viewCartService = new ViewCartServiceImpl();
		try {
			List<Cart> cart= viewCartService.viewCartByUid(user);
			if(cart!=null && cart.size()>0) {
				for(Cart item:cart) {
					System.out.println(item);
				}
		System.out.println("Enter ID to delete Item");
		int itemNo = sc.nextInt();
				try(Connection connection = SqlDbConnection.getConnection()){
			
			String sql="delete from cart where u_id=? and srno=?";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1,user);
			preparedStatement.setInt(2, itemNo);
			
			c= preparedStatement.executeUpdate();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		} 
		
	}

}
		catch(BusinessException e) {
			System.out.println(e);
		}
		return c;
	}
	
}
