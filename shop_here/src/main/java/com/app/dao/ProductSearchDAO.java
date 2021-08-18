package com.app.dao;
import java.util.List;
import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

public interface ProductSearchDAO {

	
	public List<EmployeeProducts> getProductByCategory(String category) throws BusinessException;
}
