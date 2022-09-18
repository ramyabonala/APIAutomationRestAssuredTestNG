package com.stripe.Automation.utilities;

import java.lang.reflect.Method;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;

import com.stripe.Automation.setup.BaseClass;

public class DataUtility extends BaseClass {

	@DataProvider(name="data")
	public Object[][] getData(Method m)
	
	{
		String sheetName=config.getProperty("testDataSheetName");
		
		int rows= Excel.getRowCount(sheetName);
		
		System.out.println("Total Number of Rows : " + rows);
		
		String testName=m.getName();
		
		System.out.println("Test Name is : " + testName);
		
		int testCaseRowNum = 1;
		
		for(testCaseRowNum = 1; testCaseRowNum <= rows; testCaseRowNum++)
		{
			String testCaseName = Excel.getCellData(sheetName, 0, testCaseRowNum);
			if(testCaseName.equalsIgnoreCase(testName))
				break;
			
		}
		
		System.out.println("Test case data start from row : " +testCaseRowNum);
		
		int testDataStartRowNum = testCaseRowNum+2;
		
		int testDataRows = 0;
		
		while(!Excel.getCellData(sheetName, 0, testDataStartRowNum+testDataRows).equals(""))
		{
			testDataRows++;
		}
		
		System.out.println("Total rows of data are : "+ testDataRows);
		
		//check col names
		
		int colStartRowNum = testCaseRowNum+1;
		
		int testColNum = 0;
		
		while(!Excel.getCellData(sheetName, testColNum, colStartRowNum).equals(""))
		{
			testColNum++;
		}
		
		System.out.println("Total cols of data are : "+testColNum);
		
		Object [][] Data= new Object[testDataRows][1];
		
		int i=0;
		
		
		for(int rNum = testDataStartRowNum; rNum < (testDataStartRowNum+testDataRows);rNum++) {
			
			Hashtable<String, String> table = new Hashtable<String, String>();
			
			for(int cNum=0; cNum < testColNum ; cNum++) {
				String colName = Excel.getCellData(sheetName, cNum, colStartRowNum);
				String testData = Excel.getCellData(sheetName, cNum, rNum);	
				
				
				table.put(colName, testData);
			}
			Data[i][0]=table;
			i++;
			
		}
		
		//int col= Excel.getColumnCount(sheetname);
		//System.out.println(rows+","+col);
		//Object[][] Data= new Object[rows-1][col];
		
		//for(int rowNum = 2 ; rowNum <= rows; rowNum++) {
			//for(int colNum = 0; colNum<col ; colNum++) {
				//Data[rowNum-2][colNum] = Excel.getCellData(sheetname, colNum, rowNum);
				
			//}
		//}
		
		return Data;
	}
}
