package com.app.addtocart.impl;

import com.app.addtocart.service.AddToCartService;
import com.app.dao.AddToCartDao;
import com.app.dao.impl.AddToCartDaoImpl;
import com.app.exception.BusinessException;

public class AddToCartServiceImpl implements AddToCartService{

	int res=0;
	private AddToCartDao addTocartDao= new AddToCartDaoImpl();
	@Override
	public int addTocart(int user, int id, int quant) throws BusinessException {
	
		if(quant==0) {
		  throw new BusinessException("invalid quantity");
		}
		else
		{
			res= addTocartDao.addTocart(user, id, quant);
		}
		return res;
	}
	public int retRes() {
		return res;
	}

}
