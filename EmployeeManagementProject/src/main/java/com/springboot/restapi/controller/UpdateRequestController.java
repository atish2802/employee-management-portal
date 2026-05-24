package com.springboot.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.dto.UpdateRequest;
import com.springboot.restapi.repository.UpdateRequestRepository;

@RestController
@RequestMapping("/request")
public class UpdateRequestController {

	@Autowired
	private UpdateRequestRepository repo;

	@PostMapping
	public String sendRequest(

			@RequestBody UpdateRequest request) {

		request.setRequestStatus("Pending");

		repo.save(request);

		return "Request Sent";

	}

}