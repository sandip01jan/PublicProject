#Project Details
This project leverages spring-boot framework to calculate the rewards points earned by a customer based on the transaction made by him/her.

Below APIs are created:

/getRewards - Monthly details of amount spent and points earned by all customers in last 3 months

/getRewards/{customerId} - Monthly details of amount spent and points earned by a specific customer in last 3 months

/getTransactions - Complete details of transactions of all customers in last 3 months

Complete details (GET URL & JSON Response) of all the APIs are mentioned below.

#http://localhost:8080/getRewards
#curl --location 'http://localhost:8080/getRewards'
{
    "statusCode": 200,
    "statusMessage": "200 OK",
    "response": [
        {
            "customerId": 101,
            "month": 3,
            "amount": 80,
            "rewardPoints": 30
        },
        {
            "customerId": 101,
            "month": 4,
            "amount": 100,
            "rewardPoints": 20
        },
        {
            "customerId": 202,
            "month": 2,
            "amount": 560,
            "rewardPoints": 830
        },
        {
            "customerId": 202,
            "month": 3,
            "amount": 90,
            "rewardPoints": 40
        },
        {
            "customerId": 303,
            "month": 2,
            "amount": 170,
            "rewardPoints": 190
        },
        {
            "customerId": 303,
            "month": 4,
            "amount": 40,
            "rewardPoints": 0
        }
    ]
}

#http://localhost:8080/getRewards/101
#curl --location 'http://localhost:8080/getRewards/101'

{
    "statusCode": 200,
    "statusMessage": "200 OK",
    "response": [
        {
            "customerId": 101,
            "month": 3,
            "amount": 80,
            "rewardPoints": 30
        },
        {
            "customerId": 101,
            "month": 4,
            "amount": 100,
            "rewardPoints": 20
        }
    ]
}
#http://localhost:8080/getRewards/101
#curl --location 'http://localhost:8080/getRewards/101'

{
	"statusCode":200,
	"statusMessage":"200 OK",
	"response": [
			{
				"customerId":101,
				"transactionDate":"2023-03-04",
				"amount":80,
				"rewardPoints":30
			},
			{
				"customerId":101,
				"transactionDate":"2023-04-18",
				"amount":30,
				"rewardPoints":0
			},
			{
				"customerId":101,
				"transactionDate":"2023-04-23",
				"amount":70,
				"rewardPoints":20
			},
			{
				"customerId":202,
				"transactionDate":"2023-02-05",
				"amount":90,
				"rewardPoints":40
			},
			{
				"customerId":202,
				"transactionDate":"2023-02-14",
				"amount":470,
				"rewardPoints":790
			},
			{
				"customerId":202,
				"transactionDate":"2023-03-08",
				"amount":90,
				"rewardPoints":40
			},
			{
				"customerId":303,
				"transactionDate":"2023-02-26",
				"amount":170,
				"rewardPoints":190
			},
			{
				"customerId":303,
				"transactionDate":"2023-04-02",
				"amount":40,
				"rewardPoints":0
			}
		]
}