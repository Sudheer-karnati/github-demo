package com.mindtree.utilities;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mindtree.reusablecomponents.WebdriverHelper;

public class listeners extends WebdriverHelper implements ITestListener{

	//screenshot s=new screenshot();
	
	
	public void onTestFailure(ITestResult result) {
		
		try {
			getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
