package com.prj.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.prj.app.dto.Response;

@Mapper
public interface RewardRepository {
	static String selectAllRewards = "Select "
			+ "CUST_ID customerId, MONTH(TRX_DATE) month , sum(TRX_AMOUNT) amount, sum(POINTS_EARNED) rewardPoints\r\n"
			+ "From REWARD\r\n"
			+ "Where TRX_DATE > (CURRENT_DATE - 90)\r\n"
			+ "Group By CUST_ID, MONTH(TRX_DATE)\r\n"
			+ "Order By 1, 2";

	static String selectAllRewardsByCustId = "Select "
			+ "CUST_ID customerId, MONTH(TRX_DATE) month , sum(TRX_AMOUNT) amount, sum(POINTS_EARNED) rewardPoints\r\n"
			+ "From REWARD\r\n"
			+ "Where TRX_DATE > (CURRENT_DATE - 90) AND CUST_ID = #{customerId}\r\n"
			+ "Group By CUST_ID, MONTH(TRX_DATE)\r\n"
			+ "Order By 1, 2";

	static String selectAllTransactions = "Select "
			+ "CUST_ID customerId, TRX_DATE transactionDate, TRX_AMOUNT amount, POINTS_EARNED rewardPoints\r\n"
			+ "From REWARD\r\n"
			+ "Where TRX_DATE > (CURRENT_DATE - 90)\r\n"
			+ "Order By 1, 2";

	@Select(selectAllRewards)
	public List<Response> findAllRewards();
	
	@Select(selectAllRewardsByCustId)
	public List<Response> findByCustomerId(int customerId);

	@Select(selectAllTransactions)
	public List<Response> findAllTransactions();		
}
