package src;


import java.lang.reflect.Method;

import org.testng.ITest;
import org.testng.annotations.BeforeMethod;

public  class UpdateTestNameBase implements ITest{
	private String testInstanceName = "";
	 
	 /**
	  * Allows us to set the current test name internally to this class so that
	  * the TestNG framework can use the {@link ITest} implementation for naming
	  * tests.
	  *
	  * @param testName
	  */
	 
	 private void setTestName(String anInstanceName) {
	  testInstanceName = anInstanceName;
	 }
	 
	 /**
	  * See {@link ITest#getTestName()}
	  */
	 
	 public String getTestName() {
	  return testInstanceName;
	 }

	 @BeforeMethod(alwaysRun = true)
	 public void extractTestNameFromParameters(Method method, Object[] parameters) {
		 updateTestName useAsTestName = method
				    .getAnnotation(updateTestName.class);
		 String testCaseId = (String) parameters[useAsTestName.idx()];
		 
		   setTestName(testCaseId);
	 }

	 
}
