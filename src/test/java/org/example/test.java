package org.example;

import org.testng.ITestContext;
import org.testng.annotations.*;

public class test {
    Smain login;
    DP dataPro;

    @BeforeSuite
    public void launch() {
        dataPro = new DP();
    }

    @BeforeMethod
    public void beforeTest(Object[] testArgs) {
        long threadId = Thread.currentThread().getId();
        String username = (String) testArgs[0];
        System.out.println(threadId + " myParam value in Before Test: " + username);
        dataPro.lockUsername(username);
    }

    @AfterMethod
    public void afterTest(Object[] testArgs) {
        long threadId = Thread.currentThread().getId();
        String username = (String) testArgs[0];
        System.out.println(threadId + " myParam value in After Test: " + username);
        dataPro.unlockUsername(username);
    }

    @Test(dataProvider = "Usernames", dataProviderClass = org.example.DP.class)
    public void logink(String Username, String Password, Integer qty) throws InterruptedException {
        long threadId = Thread.currentThread().getId();
        System.out.println(threadId + " Starting Test with username " + Username);
        Thread.sleep(20000);
        System.out.println(threadId + " Ending Test with username " + Username);
    }

    @AfterTest
    public void Quit() {
        login.quit();
    }

}
