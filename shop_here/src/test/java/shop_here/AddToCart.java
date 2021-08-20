package shop_here;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.addtocart.impl.AddToCartServiceImpl;
import com.app.addtocart.service.AddToCartService;
import com.app.exception.BusinessException;

class AddToCart {

	AddToCartService addToCartService = new AddToCartServiceImpl();

	@Test
	void test() throws BusinessException {
		assertEquals(0,addToCartService.retRes() );
	}

}
