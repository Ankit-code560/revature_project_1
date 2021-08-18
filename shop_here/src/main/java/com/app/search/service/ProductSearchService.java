package com.app.search.service;

import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;
import java.util.List;
public interface ProductSearchService {

	public List<EmployeeProducts> getProductBycategory(String category) throws BusinessException;
}
