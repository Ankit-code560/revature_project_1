package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

public interface DeleteProductDAo {
	public int deleteProductDao(int id) throws BusinessException;
}
