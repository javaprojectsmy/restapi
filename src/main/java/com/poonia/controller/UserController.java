package com.poonia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.poonia.model.User;
import com.poonia.services.UserService;

import io.swagger.annotations.*;

@RestController
@RequestMapping("/users")
@Api(value = "users")
public class UserController {
	@Autowired
	private UserService userService;

	

	@ApiOperation(value = "View a list of available user", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public Iterable<User> list(Model model) {
		Iterable<User> productList = userService.listAllProducts();
		return productList;
	}

	@ApiOperation(value = "Search a user with an ID", response = User.class)
	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET, produces = "application/json")
	public User showProduct(@PathVariable Integer id, Model model) {
		User product = userService.getProductById(id);
		return product;
	}

	@ApiOperation(value = "Add a user")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity saveProduct(@RequestBody User user) {
		userService.saveProduct(user);
		return new ResponseEntity("User saved successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Update a user")
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody User user) {
		User storedUser = userService.getProductById(id);
		storedUser.setDateOfBirth(user.getDateOfBirth());
		storedUser.setEmailId(user.getEmailId());
		storedUser.setName(user.getName());
		userService.saveProduct(storedUser);
		return new ResponseEntity("User updated successfully", HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a user")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity delete(@PathVariable Integer id) {
		userService.deleteProduct(id);
		return new ResponseEntity("User deleted successfully", HttpStatus.OK);

	}

}
