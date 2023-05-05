package com.prj.app.controller;

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
import com.prj.app.dto.RewardResponse;
import com.prj.app.service.RewardService;

@ExtendWith(MockitoExtension.class)
public class RewardControllerTest {
	@InjectMocks
	RewardController controller;

	@Mock 
	RewardService service;

	@Before 
	public void setUp()
	{
	}

	@Test
	public void testShowRewards_Success()
	{
		List<Response> mockedListResponse = new ArrayList<>();
		mockedListResponse.add(getRewards());
		
		when(service.showRewards()).thenReturn(mockedListResponse);

		RewardResponse response = controller.showRewards(); 
				
		assertNotNull(response);
		assertEquals(200, response.getStatusCode());
		assertEquals("200 OK", response.getStatusMessage());
		assertEquals(1, response.getResponse().size());
		assertEquals(100, response.getResponse().get(0).getAmount());
		assertEquals(1010, response.getResponse().get(0).getCustomerId());
		assertEquals(4, response.getResponse().get(0).getMonth());
		assertEquals(50, response.getResponse().get(0).getRewardPoints());
	}

	@Test
	public void testShowRewards_BlankData()
	{
		List<Response> mockedListResponse = new ArrayList<>();
		
		when(service.showRewards()).thenReturn(mockedListResponse);

		RewardResponse response = controller.showRewards(); 
				
		assertNotNull(response);
		assertNotNull(response.getResponse());
		assertEquals(0, response.getResponse().size());
		assertEquals(204, response.getStatusCode());
		assertEquals("204 NO_CONTENT", response.getStatusMessage());
	}

	@Test
	public void testShowRewards_NullData()
	{
		when(service.showRewards()).thenReturn(null);

		RewardResponse response = controller.showRewards(); 
				
		assertNotNull(response);
		assertNull(response.getResponse());
		assertEquals(204, response.getStatusCode());
		assertEquals("204 NO_CONTENT", response.getStatusMessage());
	}

	@Test
	public void testShowRewardsByCustomerId_Success()
	{
		List<Response> mockedListResponse = new ArrayList<>();
		mockedListResponse.add(getRewards());
		
		when(service.showRewardsByCustomerId(anyInt())).thenReturn(mockedListResponse);
		RewardResponse response = controller.showRewardsByCustomerId(1); 
				
		assertNotNull(response);
		assertEquals(200, response.getStatusCode());
		assertEquals("200 OK", response.getStatusMessage());
		assertEquals(1, response.getResponse().size());
		assertEquals(100, response.getResponse().get(0).getAmount());
		assertEquals(1010, response.getResponse().get(0).getCustomerId());
		assertEquals(4, response.getResponse().get(0).getMonth());
		assertEquals(50, response.getResponse().get(0).getRewardPoints());
	}

	@Test
	public void testShowRewardsByCustomerId_BlankData()
	{
		List<Response> mockedListResponse = new ArrayList<>();
		
		when(service.showRewardsByCustomerId(anyInt())).thenReturn(mockedListResponse);
		RewardResponse response = controller.showRewardsByCustomerId(1); 

		assertNotNull(response);
		assertNotNull(response.getResponse());
		assertEquals(0, response.getResponse().size());
		assertEquals(204, response.getStatusCode());
		assertEquals("204 NO_CONTENT", response.getStatusMessage());
	}

	@Test
	public void testShowRewardsByCustomerId_NullData()
	{
		when(service.showRewardsByCustomerId(anyInt())).thenReturn(null);
		RewardResponse response = controller.showRewardsByCustomerId(1); 
				
		assertNotNull(response);
		assertNull(response.getResponse());
		assertEquals(204, response.getStatusCode());
		assertEquals("204 NO_CONTENT", response.getStatusMessage());
	}

	@Test
	public void testShowTransactions_Success()
	{
		List<Response> mockedListResponse = new ArrayList<>();
		mockedListResponse.add(getTransactions());
		
		when(service.showTransactions()).thenReturn(mockedListResponse);
		RewardResponse response = controller.showTransactions(); 
				
		assertNotNull(response);
		assertEquals(200, response.getStatusCode());
		assertEquals("200 OK", response.getStatusMessage());
		assertEquals(1, response.getResponse().size());
		assertEquals(100, response.getResponse().get(0).getAmount());
		assertEquals(1010, response.getResponse().get(0).getCustomerId());
		assertEquals("2023-04-28", response.getResponse().get(0).getTransactionDate());
		assertEquals(50, response.getResponse().get(0).getRewardPoints());
	}

	@Test
	public void testShowTransactions_BlankData()
	{
		List<Response> mockedListResponse = new ArrayList<>();
		
		when(service.showTransactions()).thenReturn(mockedListResponse);
		RewardResponse response = controller.showTransactions(); 

		assertNotNull(response);
		assertNotNull(response.getResponse());
		assertEquals(0, response.getResponse().size());
		assertEquals(204, response.getStatusCode());
		assertEquals("204 NO_CONTENT", response.getStatusMessage());
	}

	@Test
	public void testShowTransactions_NullData()
	{
		when(service.showTransactions()).thenReturn(null);
		RewardResponse response = controller.showTransactions(); 
				
		assertNotNull(response);
		assertNull(response.getResponse());
		assertEquals(204, response.getStatusCode());
		assertEquals("204 NO_CONTENT", response.getStatusMessage());
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
