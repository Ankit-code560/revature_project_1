package com.app.add.product.service.impl;

import com.app.add.product.service.AddProductService;
import com.app.dao.AddProductDAo;
import com.app.dao.impl.AddProductDAoImpl;
import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

public class AddProductServiceImpl implements AddProductService {

	private AddProductDAo addProductDAo= new AddProductDAoImpl();
	@Override
	public int addProduct(EmployeeProducts employeeProducts) throws BusinessException {
	
		if(employeeProducts.getProName()!=null && employeeProducts.getProCategory()!=null) {
			return 1;
		}
		else {
		
		return 0;
	}

}}
