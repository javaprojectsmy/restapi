package com.poonia.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.poonia.model.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Integer> {

}
