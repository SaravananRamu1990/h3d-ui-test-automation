package com.h3d.ui.runner;

import com.h3d.ui.pages.LoginPage;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Runner {

    @Test
    public void runner() {
        TestNG testng = new TestNG();
        TestListenerAdapter adapter = new TestListenerAdapter();
        List<String> suites = new ArrayList<String>();
        testng.addListener(adapter);
        suites.add("suitefiles.xml");
        testng.setTestSuites(suites);
        testng.setParallel("parallel");
        testng.setSuiteThreadPoolSize(5);
        testng.setOutputDirectory(System.getProperty("user.dir") + "//target");
        testng.run();

    }
}
