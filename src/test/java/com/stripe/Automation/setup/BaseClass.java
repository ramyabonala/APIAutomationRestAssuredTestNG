package com.stripe.Automation.setup;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import com.stripe.Automation.utilities.ExcelReader;

public class BaseClass {
	public static Properties config= new Properties();
	private FileInputStream fis;
	public static ExcelReader Excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
	
	@BeforeSuite
	public void setup(){
	
	try {
		fis = new FileInputStream("./src/test/resources/properties/config.properties");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	try {
		config.load(fis);		
	} catch (Exception e) {
		e.printStackTrace();
	}
	baseURI=config.getProperty("baseURI");
	basePath=config.getProperty("basePath");
}
}
