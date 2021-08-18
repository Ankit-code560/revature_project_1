package com.app;
import java.util.List;
import java.util.Scanner;
import java.sql.*;

import org.apache.log4j.Logger;

import com.app.dao.UserAddDao;
import com.app.dao.UserSearchDao;
import com.app.dao.impl.UserAddDaoImpl;
import com.app.dao.impl.UserSearchDaoImpl;
import com.app.dao.util.SqlDbConnection;
import com.app.exception.BusinessException;
import com.app.model.EmployeeProducts;
import com.app.model.UserDetails;
import com.app.search.service.ProductSearchService;
import com.app.search.service.impl.ProductSearchServiceImpl;

public class Main {
	
	private  static Logger log = Logger.getLogger(Main.class);
	public static void main(String[] args) throws BusinessException {
		Scanner scanner = new Scanner(System.in);
		log.info("Welcome !!! ");
		
		int ch=0;
		do {
			log.info("1. login as user \n2.login as employee\n");
			
			try {
				ch=Integer.parseInt(scanner.nextLine());
			}catch(NumberFormatException e) {}
			
			switch (ch) {
				case 1:
					log.info("1.already a user? \n2.New user ");
					int ch1=0;
					try {
						
						ch1=Integer.parseInt(scanner.nextLine());
						
					}catch(NumberFormatException e) {}
					
					
						switch (ch1) 
						{
						case 1:
							System.out.println("Enter email id and password");
							String email=scanner.nextLine();
							String password= scanner.nextLine();
							
							UserSearchDao userSearchDao= new UserSearchDaoImpl();
							UserDetails userDetails1 = new UserDetails(00,"", "",00 , 00, email,password);

							try {
								if(userSearchDao.userSearch(userDetails1)==1) {
									log.info("user found");
									
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
													}
													catch(BusinessException | NullPointerException e) {
														log.warn("no stock available, will notify you soon ");
													}
													
													
													
												
												
											}
										}
									
									
									
								}
							}catch(BusinessException e) {
								log.info(e.getMessage());
							}
							break;
							
						case 2:
							UserAddDao useraddDAO= new UserAddDaoImpl();
							log.info("enter details");
							int uid=Integer.parseInt(scanner.nextLine());
							String ufname = scanner.nextLine();
							String ulname = scanner.nextLine();
							long ucontact= Long.parseLong(scanner.nextLine());
							long ucardno =Long.parseLong(scanner.nextLine());
							String uemail = scanner.nextLine();
							String upassword = scanner.nextLine();
							UserDetails userDetails=new UserDetails(uid, ufname, ulname, ucontact, ucardno, uemail, upassword);
							
							try {
								if(useraddDAO.createUser(userDetails)==1) {
									log.info("player created");
									log.info(userDetails);
								}
							}catch(BusinessException e) {
								log.info(e.getMessage());
							}
							break;
							
						default:log.info("/ninvalid input !!!!");
							break;
						}
						
						
						break;
				
				case 2:log.info("enter username and password");
				
						String EmployeeName ="John";
						String EmployeePassword ="Cena";
						String emp_name= scanner.nextLine();
						String emp_pass= scanner.nextLine();
						if(EmployeeName.equals(emp_name) && EmployeePassword.equals(emp_pass)) {
							log.info("Hey Welcome Back");
						}
						else {
							log.info("Wrong username or password, please check again");
							System.exit(0);
						}
						
						break;
				
			default: log.warn("Invalid Input");
				break;
			}
			
		}while(ch!=2);
		 

	}

}

