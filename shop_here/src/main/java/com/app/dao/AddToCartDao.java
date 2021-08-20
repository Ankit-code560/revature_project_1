package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

public interface AddToCartDao {
 
	public int addTocart(int user,int id,int quant) throws BusinessException;
}
