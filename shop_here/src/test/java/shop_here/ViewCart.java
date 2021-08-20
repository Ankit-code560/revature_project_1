package shop_here;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.exception.BusinessException;
import com.app.view.cart.service.ViewCartService;
import com.app.view.cart.service.impl.ViewCartServiceImpl;

class ViewCart {

ViewCartService viewcartService = new ViewCartServiceImpl();
	@Test
	void test() throws BusinessException{
		assertNotNull(viewcartService.viewCartByUid(4));
	}

}
