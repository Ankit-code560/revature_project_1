package com.app.add.product.service;

import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

public interface AddProductService {
	public int addProduct(EmployeeProducts employeeProducts) throws BusinessException;
}
