package com.poonia.services;

import com.poonia.model.User;

public interface UserService {
	Iterable<User> listAllProducts();

	User getProductById(Integer id);

	User saveProduct(User product);

	void deleteProduct(Integer id);
}
