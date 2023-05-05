package com.prj.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prj.app.dto.Response;
import com.prj.app.dto.RewardResponse;
import com.prj.app.service.RewardService;

@RestController
public class RewardController {
	@Autowired
	private RewardService service;
	
	@GetMapping("/getRewards")
	public RewardResponse showRewards() {
		RewardResponse rewardResponse = new RewardResponse();
		
		try {
			List<Response> response = service.showRewards();
			rewardResponse.setResponse(response);
			
			if (response == null || response.size() == 0) {
				rewardResponse.setStatusCode(HttpStatus.NO_CONTENT.value());
				rewardResponse.setStatusMessage(HttpStatus.NO_CONTENT.toString());
			}
			else {
				rewardResponse.setStatusCode(HttpStatus.OK.value());
				rewardResponse.setStatusMessage(HttpStatus.OK.toString());
			}
		}
		catch (Exception e) {
			rewardResponse.setResponse(null);
			rewardResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			rewardResponse.setStatusMessage(e.getMessage());
		}
		return rewardResponse;
	}
	
	@GetMapping("/getRewards/{customerId}")
	public RewardResponse showRewardsByCustomerId(@PathVariable int customerId) {
		RewardResponse rewardResponse = new RewardResponse();
		
		try {
			List<Response> response = service.showRewardsByCustomerId(customerId);
			rewardResponse.setResponse(response);
			
			if (response == null || response.size() == 0) {
				rewardResponse.setStatusCode(HttpStatus.NO_CONTENT.value());
				rewardResponse.setStatusMessage(HttpStatus.NO_CONTENT.toString());
			}
			else {
				rewardResponse.setStatusCode(HttpStatus.OK.value());
				rewardResponse.setStatusMessage(HttpStatus.OK.toString());
			}
		}
		catch (Exception e) {
			rewardResponse.setResponse(null);
			rewardResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			rewardResponse.setStatusMessage(e.getMessage());
		}
		return rewardResponse;
	}
	
	@GetMapping("/getTransactions")
	public RewardResponse showTransactions() {
		RewardResponse rewardResponse = new RewardResponse();
		
		try {
			List<Response> response = service.showTransactions();
			rewardResponse.setResponse(response);
			
			if (response == null || response.size() == 0) {
				rewardResponse.setStatusCode(HttpStatus.NO_CONTENT.value());
				rewardResponse.setStatusMessage(HttpStatus.NO_CONTENT.toString());
			}
			else {
				rewardResponse.setStatusCode(HttpStatus.OK.value());
				rewardResponse.setStatusMessage(HttpStatus.OK.toString());
			}
		}
		catch (Exception e) {
			rewardResponse.setResponse(null);
			rewardResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			rewardResponse.setStatusMessage(e.getMessage());
		}
		return rewardResponse;
	}
}