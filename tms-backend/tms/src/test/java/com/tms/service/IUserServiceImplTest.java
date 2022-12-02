package com.tms.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.tms.entities.Customer;
import com.tms.entities.User;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(IUserServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IUserServiceImplTest {

	@Autowired
	private IUserService uService;
	
	@Test
	public void addNewUser() {
		Customer cust = new Customer("parul","par123","faridabad","9876543210","parul@gmail.com"); 
		User user = new User("customer","par123");
		user.setCustomer(cust);
		User userFound = uService.addNewUser(user);
		Assertions.assertEquals(userFound.getCustomer(), user.getCustomer());
		Assertions.assertEquals(userFound.getPassword(), user.getPassword());
	}
	
}
