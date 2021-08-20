package com.app.addtocart.service;

import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

public interface AddToCartService {

	
	public int addTocart(int user,int id,int quant) throws BusinessException;
	public int retRes();
}
