package stepdefinition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import io.restassured.path.json.*;

import org.junit.runner.RunWith;
@RunWith(Cucumber.class)


public class StepDefinition {
	RequestSpecification req;
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
    @Given("We are at demo site")
    public void we_are_at_demo_site() throws Throwable {
        RestAssured.baseURI="http://demo4032024.mockable.io";
        req= new RequestSpecBuilder().setBaseUri("http://demo4032024.mockable.io").build();
        
        resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        res=given().spec(req);
    
    }

    @When("user calls APItest with GET http request")
    public void user_calls_apitest_with_get_http_request() throws Throwable {
    	response = res.when().get("/apitest");
    	
    }

    @Then("^the API call got success with status code 200$")
    public void the_api_call_got_success_with_status_code() throws Throwable {

    	System.out.println("Validating statuscode as 200...");   
    	int nStatus = response.getStatusCode();
    	AssertionPass1(nStatus);
    	String responseString=response.asString();
    	//System.out.println(responseString);

    }

    
    @And("^\"([^\"]*)\" in response body is 200$")
    public void something_in_response_body_is_200(String strArg1) throws Throwable {
    	System.out.println("Validating status has value of 200...");   
    	AssertionPass2(strArg1);
    	   
    }
    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String strArg1, String strArg2) throws Throwable {
    	System.out.println("Validating \"message\" key in response body has \"data retrieved successful\"");      
    	AssertionPass3(strArg1, strArg2);
    }
    @And("^\"([^\"]*)\" in response list is \"([^\"]*)\"$")
    public void something_in_response_list_is_something(String strArg1, String strArg2) throws Throwable {
    	System.out.println("Validating the \"company\" in list is \"ABC Infotech\"");   
    	AssertionPass4(strArg1, strArg2);
    }
public void AssertionPass1(int statusCode)
{
	assertEquals(statusCode,200);
}
public void AssertionPass2(String keyValue)
{
	assertEquals(response.jsonPath().get(keyValue),200);
}
public void AssertionPass3(String keyValue, String ExpValue)
{
	assertEquals(response.jsonPath().get(keyValue).toString(),ExpValue);
}
public void AssertionPass4(String keyValue, String ExpValue)
{
	String key = "employeeData";
	List<Map<String, String>> empList = response.jsonPath().getList(key);
	if(empList.size()>0)
	{
		System.out.println("Expected value= "+ExpValue);
		   Map<String, String> empInstance = empList.get(0);
		   System.out.println("Actual value= "+empInstance.get(keyValue));
		   assertEquals(ExpValue, empInstance.get(keyValue));
	}
}
}

