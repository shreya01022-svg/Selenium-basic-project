package org.example.listeners;


import org.example.utils.RetryAnalyzer;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation,
                          Class testClass,
                          Constructor constructor,
                          Method method) {
        System.out.println("Transformer applied on: " + method.getName());
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
