package com.app;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

import org.apache.log4j.Logger;
import org.omg.PortableServer.portable.Delegate;

import com.app.add.product.service.AddProductService;
import com.app.add.product.service.impl.AddProductServiceImpl;
import com.app.addtocart.impl.AddToCartServiceImpl;
import com.app.addtocart.service.AddToCartService;
import com.app.dao.AddProductDAo;
import com.app.dao.DeleteProductDAo;
import com.app.dao.PlaceOrderDao;
import com.app.dao.ReconfirmItemsDaoInCart;
import com.app.dao.UserAddDao;
import com.app.dao.UserSearchDao;
import com.app.dao.ViewOrderDao;
import com.app.dao.impl.AddProductDAoImpl;
import com.app.dao.impl.DeleteProductDAoImpl;
import com.app.dao.impl.PlaceOrderDaoImpl;
import com.app.dao.impl.ReconfirmItemsDaoInCartImpl;
import com.app.dao.impl.UserAddDaoImpl;
import com.app.dao.impl.UserSearchDaoImpl;
import com.app.dao.impl.ViewOrderDaoImpl;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.Cart;
import com.app.model.EmployeeProducts;
import com.app.model.OrderForEmployee;
import com.app.model.SuccOrder;
import com.app.model.UserDetails;
import com.app.search.service.ProductSearchService;
import com.app.search.service.impl.ProductSearchServiceImpl;
import com.app.view.cart.service.ViewCartService;
import com.app.view.cart.service.impl.ViewCartServiceImpl;
import com.app.view.product.service.impl.ViewProductServiceImpl;
import com.app.view.products.ViewProductService;
import com.mysql.cj.util.TestUtils;

public class Main {
	
	private  static Logger log = Logger.getLogger(Main.class);
	public static void main(String[] args) throws BusinessException {
		Scanner scanner = new Scanner(System.in);
		log.info("            Welcome to SHOP HERE!!!           ");
		log.info("Wishing to have a great Shopping Experience here");
		log.info("How do you wish to start here !!! ");
		
		int ch=0;
		int user= 0;
		do {
			log.info("Press \n1. User \n2. login as employee\n");
			
			try {
				ch=Integer.parseInt(scanner.nextLine());
			}catch(NumberFormatException e) {}
			
			switch (ch) {
				case 1:
					log.info("Press \n1. Already a user? \n2. New user ");
					int ch1=0;
					try {
						
						ch1=Integer.parseInt(scanner.nextLine());
						
					}catch(NumberFormatException e) {}
					
					
						switch (ch1) 
						{
						
						case 1:
							System.out.println("Please Enter VALID email id and password");
							String email=scanner.nextLine();
							String password= scanner.nextLine();
							
							UserSearchDao userSearchDao= new UserSearchDaoImpl();
							UserDetails userDetails1 = new UserDetails("", "",00 , 00, email,password);

							try {
								if(userSearchDao.userSearch(userDetails1)>=1) {
									log.info("user found");
									user=userSearchDao.userSearch(userDetails1);
					
									System.out.println("what do you want to do now!!!");
									System.out.println("press 1 for products \npress 2 for cart \npress 3 for view orders");
									int choice=0;
									try {
									 choice = Integer.parseInt(scanner.nextLine());
									}catch(NumberFormatException e) {
										log.warn("Enter number only");
									}
										
										switch(choice) {
										
										case 1: 
										    ProductSearchService productSearchService = new ProductSearchServiceImpl();
											log.info("press any number to view all category");
											if(scanner.nextInt()<=9) {
												log.info("1.mobiles\n2.earphones\n3.refrigerator\n4.home theatre\n");
												int option = 0;
												try { log.info("press the number");
												log.info("loading the data. hold for a while");
													option=(scanner.nextInt());
						
												}catch(NumberFormatException e) {log.info(e);}
												
												
												try {
														String category =null;
														if(option == 1)
														{category ="mobile";}
														if(option == 2)
														{category ="earphone";}
														if(option == 3)
														{category ="refrigerator";}
														if(option == 4)
														{category ="home theatre";}
														
														List<EmployeeProducts> empProducts= productSearchService.getProductBycategory(category);
														if(empProducts!= null && empProducts.size()>0) {
															log.info("loading\n");
														}
													
														for(EmployeeProducts products:empProducts) {
															log.info("ID is  "+products.getpId());
															log.info("model is  "+products.getProName());
															log.info("price is  "+products.getProPrice()+"\n");
														}
														
														log.info("want to add any item in cart ??");
														log.info("enter product id to add to your cart");
														
														AddToCartService addToCartService = new AddToCartServiceImpl();
														try {
															
														int product_id= scanner.nextInt();
														log.info("enter the qunatity");
														int quant=scanner.nextInt();
														int result= addToCartService.addTocart(user, product_id, quant);
														
														if(result>0) {
															log.info("successfully inserted");
														}
													
														}catch(NumberFormatException e){
															log.warn("enter valid entry");
														}
											
													}
													catch(BusinessException | NullPointerException e) {
														log.warn("no stock available, will notify you soon ");
													}
											
											}
											
											break;
											
										case 2:
											ViewCartService viewCartService = new ViewCartServiceImpl();
											try {
												List<Cart> cart= viewCartService.viewCartByUid(user);
												if(cart!=null && cart.size()>0) {
													for(Cart item:cart) {
														log.info(item);
													}
													
													log.info("Want to place orders ? press Y for Yes and N for No\n");
													char str= scanner.next().charAt(0);
													if (str=='Y') {
														log.info("welcome to place your order");
														double pr;
														int qnt;
														double tot = 0;
														for(Cart item:cart) {
															tot+= item.getPrice()*item.getQuantity();
														}
														log.info("Your total Items Costs :- "+tot);
														
														log.info("select orders to place");
														log.info("want to delete any item press 1 else press any number");
														int p= scanner.nextInt();
														if(p==1) {
														ReconfirmItemsDaoInCart reconfirmItemsDaoInCart= new ReconfirmItemsDaoInCartImpl();
														if(reconfirmItemsDaoInCart.reconfirmItemsInCart(user)==1) {
															log.info("successsfully deleted");
														}}else {
														
														
														tot=0;
											
														List<Cart> cart1= viewCartService.viewCartByUid(user);
														if(cart!=null && cart1.size()>0) {
														for(Cart item:cart1) {
															tot+= item.getPrice()*item.getQuantity();
														}
														
														log.info("Your total Items Costs :- "+tot);
														log.info("Placing your order...\n");
													
							
														PlaceOrderDao placeOrderDao= new PlaceOrderDaoImpl();
														if(placeOrderDao.placeOrder(user)==1) {
															log.info("successfully placed");
														
														
														}
														}
														}
												
														
														
													}else if(str=='N') {
														log.info("\nYour ordersare waiting to be places.. please be back soon");
													}else {
														log.info("\nwrong input !!!!!");
													}
												}
												
												
											}catch(BusinessException e) {
												log.warn(e.getMessage());
											}
											break;
											
										case 3:
											log.info("\n\nloading your successfull orders");
											ViewOrderDao viewOrderDao = new ViewOrderDaoImpl();
											try {
												List<SuccOrder> succOrder= viewOrderDao.viewOrder(user);
												if(succOrder!=null && succOrder.size()>0) {
													for(SuccOrder item : succOrder) {
														log.info(item);
													}
												}
											}catch(BusinessException e)
											{
												log.info("\nno items in cart");
											}
											
											break;
										
										}
									
									
									
								}
							}catch(BusinessException e) {
								log.info(e.getMessage());
							}
							break;
							
						case 2:
							UserAddDao useraddDAO= new UserAddDaoImpl();
							log.info("\nWelcome to SignUp....\n Please enter your details");
							
							log.info("\nEnter First Name :");
							String ufname = scanner.nextLine();
							log.info("\nEnter Last Name :");
							String ulname = scanner.nextLine();
							log.info("\nEnter valid Mobile No.");
							long ucontact= Long.parseLong(scanner.nextLine());
							log.info("\nEnter ValidCard NO");
							long ucardno =Long.parseLong(scanner.nextLine());
							log.info("\nEnter your Email id");
							String uemail = scanner.nextLine();
							log.info("\nEnter Password");
							String upassword = scanner.nextLine();
							UserDetails userDetails=new UserDetails( ufname, ulname, ucontact, ucardno, uemail, upassword);
							
							try {
								if(useraddDAO.createUser(userDetails)==1) {
									log.info("player created");
									log.info(userDetails);
								}
							}catch(BusinessException e) {
								log.info(e.getMessage());
							}
							break;
							
						default:log.info("\ninvalid input !!!!");
							break;
						}
						break;
						
						
				
				case 2:log.info("enter username and password");
				
						String EmployeeName ="Employee";
						String EmployeePassword ="Shop_Here";
						String emp_name= scanner.nextLine();
						String emp_pass= scanner.nextLine();
						
						if(EmployeeName.equals(emp_name) && EmployeePassword.equals(emp_pass)) {
							log.info("Hey Welcome Back");
						}else {
							log.info("Wrong username or password, please check again");
							System.exit(0);
						}
						
						log.info("Press \n1.View Orders \n2.View Products \n3.Modify Product");
						int option= scanner.nextInt();
						
						switch(option) {
						case 1:
							log.info("loading orders");
							
							ViewOrderDao viewOrderDao = new ViewOrderDaoImpl();
							try {
								List<OrderForEmployee> orderForEmployees = viewOrderDao.viewOrderForEmployee();
								if(orderForEmployees!=null && orderForEmployees.size()>0) {
									for(OrderForEmployee order: orderForEmployees) {
										log.info(order);
									}
								}
							}catch(BusinessException e) {
								log.warn(e.getMessage());
							}
							
							
							break;
							
						case 2:
							log.info("loading products");
							ViewProductService viewproService = new ViewProductServiceImpl();
							try {
								List<EmployeeProducts> employeeProducts = viewproService.viewProducts();
								if(employeeProducts!=null && employeeProducts.size()>0) {
									for(EmployeeProducts product: employeeProducts) {
										log.info(product);
									}
								}
							}catch(BusinessException e) {
								log.warn(e.getMessage());
							}
							break;
						
						case 3:
							
							AddProductDAo addProductDAo = new AddProductDAoImpl();
							log.info("\nwish to\n1. Add new Product \n2.Delete Existing Product");
							int wish=scanner.nextInt();
							switch(wish) {
							case 1:
								log.info("\nadd product details");
								log.info("Enter Product model and Category ");
								String name1= scanner.next();
								String cat= scanner.next();
								log.info("Enter Product Price");
								double  price= scanner.nextDouble();
								EmployeeProducts employeeProducts = new EmployeeProducts(name1,cat,price);
							
								try {
									if(addProductDAo.addProduct(employeeProducts)==1) {
										log.info("\nsuccessfully added");
									}
								}catch(BusinessException e) {
									log.info(e.getMessage());
								}
								break;
								
							case 2:
								DeleteProductDAo deleteProductDAo= new DeleteProductDAoImpl();
								log.info("\nEnter ProductId to delete");
								int pid= scanner.nextInt();
								
								try {
									if(deleteProductDAo.deleteProductDao(pid)==1){
										log.info("\ndeleted");
									}
			
								}catch(BusinessException e) {
									log.info(e.getMessage());}
								break;
								
							}
							
							
						}
						
						
						
						break;
				
			default: log.warn("Invalid Input");
				break;
			}
			
			break;
		}while(ch!=2);
		 

	}

}

