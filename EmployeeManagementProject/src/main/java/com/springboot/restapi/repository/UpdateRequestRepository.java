package com.springboot.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restapi.dto.UpdateRequest;

public interface UpdateRequestRepository extends JpaRepository<UpdateRequest, Integer> {

}