package com.prj.app.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.prj.app.dto.Response;
import com.prj.app.repository.RewardRepository;

@ExtendWith(MockitoExtension.class)
public class RewardServiceTest {
	@InjectMocks
	RewardService service;

	@Mock 
	RewardRepository repository;

	@Before 
	public void setUp()
	{
	}

	@Test
	public void testShowRewards_Success()
	{
		List<Response> mockedListResponse = new ArrayList<>();
		mockedListResponse.add(getRewards());
		
		List<Response> response = null;
		
		try {
			when(repository.findAllRewards()).thenReturn(mockedListResponse);
			response = service.showRewards(); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(100, response.get(0).getAmount());
		assertEquals(1010, response.get(0).getCustomerId());
		assertEquals(4, response.get(0).getMonth());
		assertEquals(50, response.get(0).getRewardPoints());
	}

	@Test
	public void testShowRewards_BlankData()
	{
		List<Response> mockedListResponse = new ArrayList<>();
		
		List<Response> response = null;
		
		try {
			when(repository.findAllRewards()).thenReturn(mockedListResponse);
			response = service.showRewards(); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		assertNotNull(response);
		assertEquals(0, response.size());
	}

	@Test
	public void testShowRewards_NullData()
	{
		List<Response> response = null;

		try {
			when(repository.findAllRewards()).thenReturn(null);
			response = service.showRewards(); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
		assertNull(response);
	}

	@Test
	public void testShowRewardsByCustomerId_Success()
	{
		List<Response> mockedListResponse = new ArrayList<>();
		mockedListResponse.add(getRewards());
		
		List<Response> response = null;
		
		try {
			when(repository.findByCustomerId(anyInt())).thenReturn(mockedListResponse);
			response = service.showRewardsByCustomerId(1); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(100, response.get(0).getAmount());
		assertEquals(1010, response.get(0).getCustomerId());
		assertEquals(4, response.get(0).getMonth());
		assertEquals(50, response.get(0).getRewardPoints());
	}

	@Test
	public void testShowRewardsByCustomerId_BlankData()
	{
		List<Response> mockedListResponse = new ArrayList<>();
		
		List<Response> response = null;
		
		try {
			when(repository.findByCustomerId(anyInt())).thenReturn(mockedListResponse);
			response = service.showRewardsByCustomerId(1); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		assertNotNull(response);
		assertEquals(0, response.size());
	}

	@Test
	public void testShowRewardsByCustomerId_NullData()
	{
		List<Response> response = null;

		try {
			when(repository.findByCustomerId(anyInt())).thenReturn(null);
			response = service.showRewardsByCustomerId(1); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
		assertNull(response);
	}

	@Test
	public void testShowTransactions_Success()
	{
		List<Response> mockedListResponse = new ArrayList<>();
		mockedListResponse.add(getTransactions());
		
		List<Response> response = null;
		
		try {
			when(repository.findAllTransactions()).thenReturn(mockedListResponse);
			response = service.showTransactions(); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
		assertNotNull(response);
		assertEquals(1, response.size());
		assertEquals(100, response.get(0).getAmount());
		assertEquals(1010, response.get(0).getCustomerId());
		assertEquals("2023-04-28", response.get(0).getTransactionDate());
		assertEquals(50, response.get(0).getRewardPoints());
	}

	@Test
	public void testShowTransactions_BlankData()
	{
		List<Response> mockedListResponse = new ArrayList<>();
		
		List<Response> response = null;
		
		try {
			when(repository.findAllTransactions()).thenReturn(mockedListResponse);
			response = service.showTransactions(); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		assertNotNull(response);
		assertEquals(0, response.size());
	}

	@Test
	public void testShowTransactions_NullData()
	{
		List<Response> response = null;

		try {
			when(repository.findAllTransactions()).thenReturn(null);
			response = service.showTransactions(); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
				
		assertNull(response);
	}

	private Response getRewards() {
		Response response = new Response();
		
		response.setAmount(100);
		response.setCustomerId(1010);
		response.setMonth(4);
		response.setRewardPoints(50);
		
		return response;
	}
	
	private Response getTransactions() {
		Response response = new Response();
		
		response.setAmount(100);
		response.setCustomerId(1010);
		response.setTransactionDate("2023-04-28");
		response.setRewardPoints(50);
		
		return response;
	}
}
