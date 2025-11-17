package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//Data Provider1
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path=".\\testData\\OpenCartData.xlsx"; //taking excel from testData
		ExcelUtility xlutil=new ExcelUtility(path);
		
		int total_rows=xlutil.getRowCount("Sheet1");
		int total_cols=xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[total_rows][total_cols];
		
		//0 is header row so will ignore it and start from 1
		for(int i=1;i<=total_rows;i++) {
			for(int j=0;j<total_cols;j++) {
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j); //i-1 because arr index start from 0 and i is 1
			
			}
			
		}
		return logindata;
		
	}
	
	//DataProvider2

}