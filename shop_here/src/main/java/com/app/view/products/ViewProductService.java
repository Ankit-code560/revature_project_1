package com.app.view.products;
import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;
public interface ViewProductService {

	public List<EmployeeProducts> viewProducts() throws BusinessException;
}
