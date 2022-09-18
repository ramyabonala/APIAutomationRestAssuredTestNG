package com.stripe.Automation.testcases;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stripe.Automation.APIs.CreateCustomerAPI;
import com.stripe.Automation.setup.BaseClass;
import com.stripe.Automation.utilities.DataUtility;

import io.restassured.response.Response;

public class CreateCustomerTest extends BaseClass {
	
	@Test(priority = 1, dataProviderClass = DataUtility.class, dataProvider = "data")
	public void verifyCreateCustomerWithValidAuth(Hashtable<String, String> Data)
	{
		Response resp = CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithValidAuth(Data);
		resp.prettyPrint();
		
		JSONObject jsonObj = new JSONObject(resp.asString());
		
		//jsonObj.has("id");
		
		System.out.println(jsonObj.has("id"));
		System.out.println(jsonObj.get("id"));
	
		System.out.println("Response-->"+resp.statusCode());
		//Assert.assertEquals(resp.statusCode(), 200);
		Assert.assertEquals(jsonObj.get("email"), Data.get("email"));
	
	}


@Test(priority = 2, dataProviderClass = DataUtility.class, dataProvider = "data")
public void verifyCreateCustomerWithInValidAuth(Hashtable<String, String> Data)

{
	//RestAssured.baseURI="https://api.stripe.com";
	//RestAssured.basePath="/v1";
	Response resp=CreateCustomerAPI.sendPostRequestToCreateCustomerAPIWithInValidAuth(Data);
//			  .formParam("name", Data.get("name"))
//			  .formParam("email", Data.get("email"))
//			  .formParam("description", Data.get("description"))
//			  .post(config.getProperty("customerEndPoint"));
	resp.prettyPrint();
	System.out.println("Response-->"+resp.statusCode());
	Assert.assertEquals(resp.statusCode(), 401, "expected value is not received");	
}
}
