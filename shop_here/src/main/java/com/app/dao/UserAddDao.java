package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.UserDetails;

public interface UserAddDao {

	
	public int createUser( UserDetails userDetails) throws BusinessException;
}
