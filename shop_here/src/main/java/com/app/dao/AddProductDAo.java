package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

public interface AddProductDAo {

	public int addProduct(EmployeeProducts employeeProducts) throws BusinessException;
}
