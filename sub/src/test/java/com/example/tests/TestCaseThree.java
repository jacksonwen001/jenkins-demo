package com.example.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class TestCaseThree {
    private final String enableVNC = "enableVNC";
    private final String enableVideo = "enableVideo";
    private final String dns = "dnsServers";
    private final String selenoidOptions = "selenoid:options";
    private final String debugAddress = "debuggerAddress";

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

    @Test
    public void testOpen(){
        Configuration.remote = "http://192.168.55.54:4444/wd/hub";
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.downloadsFolder = "target/downloads";
        Map<String, Object> options = new HashMap<>();
        options.put(enableVNC, true);
        options.put(enableVideo, true);
        options.put(dns, new String[]{"8.8.8.8"});
        Configuration.browserCapabilities = new ChromeOptions();
        Configuration.browserCapabilities.setCapability(selenoidOptions, options);
        open("https://www.baidu.com");
        $("#id").shouldBe(Condition.visible).sendKeys("hello");

    }
}
