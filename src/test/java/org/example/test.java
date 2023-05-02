package org.example;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test {
    Smain login;
    @BeforeTest
    public void launch(){
        login=new Smain();
        login.launchbrowser();
    }

    @Test
    @Parameters({"Username"})
    public void logink(String Username){
        login.login(Username);
    }

    @AfterTest
    public void Quit(){
        login.quit();
    }

}
