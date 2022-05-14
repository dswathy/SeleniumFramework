package com.tests;

import org.testng.annotations.Test;

import com.beans.excel.ExcelToBeanMapper;

public final class XceliteFeatureTest {

	private XceliteFeatureTest() {}
	
	@Test
	public void runXceliteDataMappingintoPOJOTest() {
		ExcelToBeanMapper.printPOJOValuesForExcel();
	}
	
}
