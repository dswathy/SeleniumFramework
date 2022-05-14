package com.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 *  This class is used to define custom annotation values for test cases at run time.
 *  The values for annotations are fetched from Test Data Excel and modified accordingly.
 *  Implementation is still pending
 *  
 * @author Ashtesh Divakar
 *
 */
public class AnnotationListener implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
	}

}
