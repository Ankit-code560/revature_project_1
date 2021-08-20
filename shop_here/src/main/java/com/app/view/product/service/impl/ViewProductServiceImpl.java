package com.app.view.product.service.impl;

import java.util.List;

import javax.swing.text.View;

import com.app.dao.ViewProducts;
import com.app.dao.impl.ViewProductImpl;
import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;
import com.app.view.products.ViewProductService;

public class ViewProductServiceImpl implements ViewProductService{

	private ViewProducts viewPro = new ViewProductImpl();
	@Override
	public List<EmployeeProducts> viewProducts() throws BusinessException {
		List<EmployeeProducts> employeeProducts=null;
		employeeProducts = viewPro.viewProducts();
		return employeeProducts;
	}

}
