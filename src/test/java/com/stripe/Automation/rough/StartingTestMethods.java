package com.stripe.Automation.rough;

import static io.restassured.RestAssured.*;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.stripe.Automation.setup.BaseClass;
import com.stripe.Automation.utilities.DataUtility;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class StartingTestMethods extends BaseClass{
	
	@Test(priority = 1, dataProviderClass = DataUtility.class, dataProvider = "data")
	public void verifyCreateCustomerWithValidAuth(Hashtable<String, String> Data)
	
	

	{
		//RestAssured.baseURI="https://api.stripe.com";
		//RestAssured.basePath="/v1";
		Response resp=given().auth().basic(config.getProperty("validSecretKey"), "")
				  .formParam("name", Data.get("name"))
				  .formParam("email", Data.get("email"))
				  .formParam("description", Data.get("description"))
				  .post(config.getProperty("customerEndPoint"));
		resp.prettyPrint();
		System.out.println("Response-->"+resp.statusCode());
		Assert.assertEquals(resp.statusCode(), 200);				  
}
	@Test(priority = 2, dataProviderClass = DataUtility.class, dataProvider = "data")
	public void verifyCreateCustomerWithInValidAuth(Hashtable<String, String> Data)
	
	{
		//RestAssured.baseURI="https://api.stripe.com";
		//RestAssured.basePath="/v1";
		Response resp=given().auth().basic(config.getProperty("invalidSecretKey"), "")
				  .formParam("name", Data.get("name"))
				  .formParam("email", Data.get("email"))
				  .formParam("description", Data.get("description"))
				  .post(config.getProperty("customerEndPoint"));
		resp.prettyPrint();
		System.out.println("Response-->"+resp.statusCode());
		Assert.assertEquals(resp.statusCode(), 401, "expected value is not received");	
}
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		String sheetname="testdata";
//		int rows= Excel.getRowCount(sheetname);
//		int col= Excel.getColumnCount(sheetname);
//		System.out.println(rows+","+col);
//		Object[][] Data= new Object[rows-1][col];
//		
//		for(int rowNum = 2 ; rowNum <= rows; rowNum++) {
//			for(int colNum = 0; colNum<col ; colNum++) {
//				Data[rowNum-2][colNum] = Excel.getCellData(sheetname, colNum, rowNum);
//				
//			}
//		}
//		Data[0][0] = "New User Name01";
//		Data[0][1] = "abcdummy@gmai.com01";
//		Data[0][2] = "creating data from data provider1";
//		
//		Data[1][0] = "New User Name02";
//		Data[1][1] = "abcdummy@gmai.com02";
//		Data[1][2] = "creating data from data provider1";
//		
//		return Data;
		
//	}
}
 


