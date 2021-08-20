package com.app.dao;

import java.util.List;

import com.app.exception.BusinessException;
import com.app.model.OrderForEmployee;
import com.app.model.SuccOrder;

public interface ViewOrderDao {

	public List<SuccOrder> viewOrder(int user)  throws BusinessException;
	public List<OrderForEmployee> viewOrderForEmployee() throws BusinessException;
}
