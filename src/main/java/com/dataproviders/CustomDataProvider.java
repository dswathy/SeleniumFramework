package com.dataproviders;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IDataProviderMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.IDataProviderAnnotation;

import com.enums.ExcelColumnConstants;
import com.enums.ExcelSheetNames;
import com.utils.ExcelUtils;

/**
 * This class is used to pass test data for each test case. As per present implementation this only takes data from 
 * only one sheet i.e Login Test. Need to provide implementation based on sheet name from test class.
 * @author Ashtesh Divakar
 *
 */
// Final class so that no inheritance allowed for this class
public final class CustomDataProvider {
	
	// Private constructor so that no refernce to class methods using object
	//private CustomDataProvider() {}
	
	private static Logger log = LogManager.getLogger();
	
	@DataProvider
	public Object[] getTestData(Method method) {
		
		List<HashMap<String,String>> dataList = new ArrayList<>();
		List<HashMap<String, String>> dataSubset = new ArrayList<>();
		dataList = ExcelUtils.getDataFromExcel(ExcelSheetNames.LOGIN_TEST);
		String testcaseName = "";
		int j=0;
		
		for(int i=0; i<dataList.size(); i++) {
			testcaseName = dataList.get(i).get(ExcelColumnConstants.TEST_CASE_NAME.getValue());
			String execute = dataList.get(i).get(ExcelColumnConstants.EXECUTE.getValue());
			if(testcaseName.equalsIgnoreCase(method.getName()) && execute.equalsIgnoreCase("yes")) {
				dataSubset.add(dataList.get(i));
				j++;
			}
		}
		
		if(Objects.isNull(dataSubset)) {
			log.info("Test Data not found for Test Case: " +testcaseName);
			throw new RuntimeException("Test Data not found for Test Case: " +testcaseName);
		}
		else {
			return dataSubset.toArray();
		}
		
	}

}
