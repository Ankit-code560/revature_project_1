package com.app.search.service.impl;
import java.util.List;

import com.app.dao.ProductSearchDAO;
import com.app.dao.impl.ProductSearchDAOImpl;
import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;
import com.app.search.service.ProductSearchService;

public class ProductSearchServiceImpl implements ProductSearchService {

	
	private ProductSearchDAO productSearchDAO = new ProductSearchDAOImpl();
	@Override
	public List<EmployeeProducts> getProductBycategory(String category) throws BusinessException {
		
		List<EmployeeProducts> proList=null;
		if(category=="mobile" || category =="refrigerator" || category=="earphones" || category =="home theatre") {
			proList = productSearchDAO.getProductByCategory(category);
		}
		return proList;
	}

}
