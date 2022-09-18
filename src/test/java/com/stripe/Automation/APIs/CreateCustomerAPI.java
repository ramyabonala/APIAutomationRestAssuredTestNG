package com.stripe.Automation.APIs;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.stripe.Automation.setup.BaseClass;
import com.stripe.Automation.utilities.DataUtility;

import io.restassured.response.Response;

public class CreateCustomerAPI extends BaseClass{

	//@Test(priority = 1, dataProviderClass = DataUtility.class, dataProvider = "data")
	public static Response sendPostRequestToCreateCustomerAPIWithValidAuth(Hashtable<String, String> Data)	{
		//RestAssured.baseURI="https://api.stripe.com";
		//RestAssured.basePath="/v1";
		Response resp=given().auth().basic(config.getProperty("validSecretKey"), "")
				  .formParam("name", Data.get("name"))
				  .formParam("email", Data.get("email"))
				  .formParam("description", Data.get("description"))
				  .post(config.getProperty("customerEndPoint"));
		//resp.prettyPrint();
		//System.out.println("Response-->"+resp.statusCode());
		//Assert.assertEquals(resp.statusCode(), 200);			
		
		return resp;
}
	
	//@Test(priority = 2, dataProviderClass = DataUtility.class, dataProvider = "data")
	public static Response sendPostRequestToCreateCustomerAPIWithInValidAuth(Hashtable<String, String> Data)

	{
		//RestAssured.baseURI="https://api.stripe.com";
		//RestAssured.basePath="/v1";
		Response resp=given().auth().basic(config.getProperty("invalidSecretKey"), "")
				  .formParam("name", Data.get("name"))
				  .formParam("email", Data.get("email"))
				  .formParam("description", Data.get("description"))
				  .post(config.getProperty("customerEndPoint"));
		//resp.prettyPrint();
		//System.out.println("Response-->"+resp.statusCode());
		//Assert.assertEquals(resp.statusCode(), 401, "expected value is not received");
		return resp;
		
		
	}

	
}
