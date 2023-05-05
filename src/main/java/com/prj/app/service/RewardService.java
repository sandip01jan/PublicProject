package com.prj.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prj.app.dto.Response;
import com.prj.app.repository.RewardRepository;

@Service
public class RewardService {
	@Autowired
	private RewardRepository repository;
	
	public List<Response> showRewards() {
		return repository.findAllRewards();
	}
	
	public List<Response> showRewardsByCustomerId(int customerId) {
		return repository.findByCustomerId(customerId);
	}
	
	public List<Response> showTransactions() {
		return repository.findAllTransactions();
	}
}