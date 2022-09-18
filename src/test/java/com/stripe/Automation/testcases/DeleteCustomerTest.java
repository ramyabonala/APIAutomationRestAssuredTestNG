package com.stripe.Automation.testcases;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.stripe.Automation.APIs.DeleteCustomerAPI;
import com.stripe.Automation.setup.BaseClass;
import com.stripe.Automation.utilities.DataUtility;

import io.restassured.response.Response;

public class DeleteCustomerTest extends BaseClass {
	
	@Test(priority = 1, dataProviderClass = DataUtility.class, dataProvider = "data")
	public void verifyDeleteCustomerWithValidAuth(Hashtable<String, String> Data)
	{
		Response resp = DeleteCustomerAPI.sendDeleteRequestToDeleteCustomerAPIWithValidAuth(Data);
		resp.prettyPrint();
		System.out.println("Response-->"+resp.statusCode());
		Assert.assertEquals(resp.statusCode(), 200);
	}
}