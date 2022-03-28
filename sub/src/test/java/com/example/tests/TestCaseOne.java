package com.example.tests;

import org.testng.annotations.Test;

import static io.qameta.allure.Allure.step;

public class TestCaseOne {

    @Test
    public void test(){
        String env = System.getProperty("env");
        step(env + " step-1");
        step(env + " step-2");
        step(env + " step-3");
        step(env + " step-4");
        step(env + " step-5");
        step(env + " step-6");
    }
}
