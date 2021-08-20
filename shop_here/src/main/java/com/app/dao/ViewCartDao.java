package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface ViewCartDao {

	public List<Cart> viewCartByUid(int uid) throws BusinessException;
}
