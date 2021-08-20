package shop_here;

import static org.junit.jupiter.api.Assertions.*;
import javax.swing.text.View;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.*
;
import com.app.exception.*;
import com.app.view.product.service.impl.ViewProductServiceImpl;
import com.app.view.products.ViewProductService;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ViewProducts {

	ViewProductService viewproductSerice = new ViewProductServiceImpl();

	@Test
	void test() throws BusinessException{
		assertNotNull(viewproductSerice.viewProducts());
	}

}
