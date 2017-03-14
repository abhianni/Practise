package src;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class UpdateMethodNameTest extends UpdateTestNameBase{
	  
	 @updateTestName()
	 @Test(dataProvider="rawDP")
	 public void shouldHaveTestNamesStartingWithANA(String arg1, String arg2)
	 {
	  getTestName().equals(arg1);
	 }
	  
	 @updateTestName(idx=1)
	 @Test(dataProvider="rawDP")
	 public void shouldHaveTestNamesStartingWithThe(String arg1, String arg2)
	 {
	  getTestName().equals(arg2);
	 } 
	 
	 @DataProvider(name="rawDP")
	 public Object[][] sampleDataProvider()
	 {
	  Object[][] rawData = {
	    {"SCENARIO_1","First Test Scenario"}, 
	    {"SCENARIO_2","Second Test Scenario"},
	    {"SCENARIO_3","Third Test Scenario"}
	  };
	   
	  return rawData;
	 }
}
