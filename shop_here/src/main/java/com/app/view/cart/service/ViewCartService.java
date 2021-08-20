package com.app.view.cart.service;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.Cart;

public interface ViewCartService {

	public List<Cart> viewCartByUid(int uid) throws BusinessException;
}
