package com.app.view.cart.service.impl;

import java.util.List;

import javax.swing.text.View;

import com.app.dao.ViewCartDao;
import com.app.dao.impl.ViewCartDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.view.cart.service.ViewCartService;

public class ViewCartServiceImpl implements ViewCartService{

	private ViewCartDao viewcartDao = new ViewCartDAOImpl();
	@Override
	public List<Cart> viewCartByUid(int uid) throws BusinessException {
		List<Cart> cart=null;
		cart= viewcartDao.viewCartByUid(uid);
		return cart;
	}

}
