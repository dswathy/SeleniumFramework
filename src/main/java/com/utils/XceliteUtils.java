package com.utils;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.constants.FrameworkConstants;
import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.sheet.XceliteSheet;

public class XceliteUtils {
	
	/**
	 * This is utility class to read excel data and convert it in POJO 
	 */
	
	private XceliteUtils xceliteUtils;
	private Xcelite xcelite;
	
	public XceliteUtils getInstance() {
		if(Objects.isNull(xceliteUtils)) {
			xceliteUtils = new XceliteUtils();
			xceliteUtils.xcelite = new Xcelite(new File(FrameworkConstants.getTestDataFilePath()));
		}
		return xceliteUtils;
	}
	
	public <T> Collection<T> readSheet(String sheetName, Class<T> clazz, Xcelite xcelite) {
		XceliteSheet sheet = xcelite.getSheet(sheetName);
		return sheet.getBeanReader(clazz).read();
	}
	
	public <T> List<T> readSheet(String sheetName, Class<T> clazz) {
		return readSheet(sheetName, clazz, this.xcelite).stream().collect(Collectors.toList());
	}

}
