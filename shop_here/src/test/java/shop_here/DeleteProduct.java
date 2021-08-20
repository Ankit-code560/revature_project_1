package shop_here;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.app.dao.DeleteProductDAo;
import com.app.dao.impl.DeleteProductDAoImpl;
import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;

class DeleteProduct {

	String name="hp";
	String category="notebook";
	double price=5200.00;
	int id=15;
	
	

	@Test
	void test() {
		DeleteProductDAo deletee= new DeleteProductDAoImpl();
		try {
			EmployeeProducts emp= new EmployeeProducts(name,category,price);
			assertEquals(1, deletee.deleteProductDao(id));
		}catch( BusinessException e)
		{
			
		}
		
	}

}
