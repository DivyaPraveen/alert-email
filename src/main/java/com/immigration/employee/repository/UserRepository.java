/*
 * Copyright (C) 2018, Liberty Information Technology
 *
 * Created on 04/16/2018
 *
 */

package com.immigration.employee.repository;

import com.immigration.employee.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
//    List<User> findAll();
}
