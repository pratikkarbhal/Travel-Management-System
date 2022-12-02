package com.tms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tms.entities.Admin;
import com.tms.entities.Customer;
import com.tms.entities.User;
import com.tms.repository.IAdminRepository;
import com.tms.repository.ICustomerRepository;
import com.tms.repository.IUserRepository;

@Service
@Transactional
public class IUserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Autowired
	private IAdminRepository adminRepository;
	
	//Used for adding new User
	@Override
	public User addNewUser(User user) {
		if (user.getUserType().equalsIgnoreCase("admin")) {
			Admin admin = user.getAdmin();
			Admin newAdmin = adminRepository.save(admin);
			user.setUserId(newAdmin.getAdminId());
		} else {
			Customer customer = user.getCustomer();
			Customer newCustomer = customerRepository.save(customer);
			user.setUserId(newCustomer.getCustomerId());
		}
		
		User newUser = userRepository.save(user);
		return newUser;
	}
	
	// Used for signing in
	@Override
	public User signIn(User user) {
		Optional<User> optional = userRepository.findById(user.getUserId());
		User newUser = optional.get();
		if (newUser.getUserId() == user.getUserId() && newUser.getUserType().equals(user.getUserType()) && newUser.getPassword() == user.getPassword()) {
			if (user.getUserType().equalsIgnoreCase("admin")) {
				Optional<Admin> optionalAdmin = adminRepository.findById(user.getUserId());
				Admin admin = optionalAdmin.get();
				newUser.setAdmin(admin);
			} else {
				Optional<Customer> optionalCustomer = customerRepository.findById(user.getUserId()); 
				Customer customer = optionalCustomer.get();
				newUser.setCustomer(customer);
			}
		}
		return newUser;
	}
	// Used for signing out
	@Override
	public User signOut(User user) {
		Optional<User> optional = userRepository.findById(user.getUserId());
		User newUser = optional.get();
		return newUser;
	}

}
