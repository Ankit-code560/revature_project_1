package com.app.dao;

import com.app.exception.BusinessException;

public interface ReconfirmItemsDaoInCart {

	
	public int reconfirmItemsInCart(int user) throws BusinessException;
}
