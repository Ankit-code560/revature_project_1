package com.app.dao;

import com.app.exception.BusinessException;
import com.app.model.UserDetails;

public interface UserSearchDao {

	public int userSearch(UserDetails userDetails) throws BusinessException;
}
