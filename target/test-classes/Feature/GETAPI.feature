Feature: Validating GetAPI for IG
@getapi
Scenario: Verify getapi is working as expected
	Given We are at demo site
	When user calls APItest with GET http request
	Then the API call got success with status code 200
	And "status" in response body is 200
	And "message" in response body is "data retrieved successful"
	And "company" in response list is "ABC Infotech"