package com.codemymobile.Assesment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.codemymobile.Assesment.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Page<User> findAll(Pageable pageable);

}
