package com.stripe.Automation.APIs;
 
import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.stripe.Automation.setup.BaseClass;
import com.stripe.Automation.utilities.DataUtility;

import io.restassured.response.Response;

public class DeleteCustomerAPI extends BaseClass{

	//@Test(priority = 1, dataProviderClass = DataUtility.class, dataProvider = "data")
	public static Response sendDeleteRequestToDeleteCustomerAPIWithValidAuth(Hashtable<String, String> Data)	{
		//RestAssured.baseURI="https://api.stripe.com";
		//RestAssured.basePath="/v1";
		Response resp=given().auth().basic(config.getProperty("validSecretKey"), "")
				.delete(config.getProperty("customerEndPoint")+"/"+Data.get("id"));
		
		return resp;

	}
}
