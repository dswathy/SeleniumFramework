package com.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.enums.ExcelColumnConstants;
import com.enums.ExcelSheetNames;
import com.utils.ExcelUtils;

/**
 * This class will override the test case execution at run time. It will execute tests marked as Execute = yes in Test Data Excel.
 * This method will be invoke only once before the all test in suite is executed.
 * This method can alter priority, description, invocationCount, etc.
 * @author Ashtesh Divakar
 *
 */

public class MethodInterceptorListener implements IMethodInterceptor{

	private static List<IMethodInstance> result = new ArrayList<>();

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		ArrayList<HashMap<String, String>> testMethodList = ExcelUtils.getDataFromExcel(ExcelSheetNames.TEST_MANAGER);
		ArrayList<HashMap<String, String>> testMethodSubList = ExcelUtils.getDataFromExcel(ExcelSheetNames.LOGIN_TEST);
		for(int i=0; i<methods.size(); i++) {
			for(int j=0; j<testMethodList.size(); j++) {
				if(methods.get(i).getMethod().getMethodName().equals(testMethodList.get(j).get(ExcelColumnConstants.TEST_CASE_NAME.getValue()))
						&& testMethodList.get(j).get(ExcelColumnConstants.EXECUTE.getValue()).equalsIgnoreCase("yes")){
					result.add(methods.get(i));
				}
			}
		}

		return result;
	}

}
