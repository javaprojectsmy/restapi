package com.poonia.services;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.poonia.model.User;
import com.poonia.repositories.UserRepository;


@Component
public class UserServiceImpl implements UserService{
	 private final Logger logger = LoggerFactory.getLogger(this.getClass());
        private List<User> users = new LinkedList<User>();
	

	    @Override
	    public Iterable<User> listAllProducts() {
	        logger.debug("listAllProducts called");
	        return users;
	    }

	    @Override
	    public User getProductById(Integer id) {
	        logger.debug("getProductById called");
	        return users.get(id);
	    }

	    @Override
	    public User saveProduct(User user) {
	        logger.debug("saveProduct called");
	        users.add(user);
	        return user;
	    }

	    @Override
	    public void deleteProduct(Integer id) {
	        logger.debug("deleteProduct called");
	        users.remove(id);
	    }
	}
