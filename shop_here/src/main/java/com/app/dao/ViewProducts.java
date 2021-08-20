package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;
public interface ViewProducts {
	public List<EmployeeProducts> viewProducts() throws BusinessException;
}
