package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.util.Objects;
import java.util.Properties;

import com.constants.FrameworkConstants;

// Final class so that should not be extended by other class
public final class PropertyUtils {

	private PropertyUtils() {}
	
	private static org.apache.logging.log4j.Logger log = LogManager.getLogger();

	private static HashMap<String,String> propertyMap;

	public static HashMap<String,String> readProperty() {

		if(Objects.isNull(propertyMap)) {

			try {
				FileInputStream src = new FileInputStream(FrameworkConstants.getConfigPropertyPath());
				Properties prop = new Properties();
				prop.load(src);
				propertyMap = new HashMap<>();
				for(Entry entry : prop.entrySet()) {
					String key = (String) entry.getKey();
					String value = (String) entry.getValue();

					propertyMap.put(key.trim(),value.trim());
				}
			} catch (FileNotFoundException e) {
				log.info("Property file path is incorrect.");
			} catch (IOException e) {
				log.info("Data in property file is incorrect: ");
			}
		}
		return propertyMap;
	}

}
