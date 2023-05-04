package org.example;

import org.testng.annotations.*;

public class test {
    Smain login;
    DP dataPro;
    @BeforeTest
    public void launch(){
        dataPro=new DP();
        login=new Smain();
        login.launchbrowser();
    }

    @Test (dataProvider = "Usernames", dataProviderClass = org.example.DP.class)
    public void logink(String Username,String Password, Integer qty) throws InterruptedException {
        if(true){
            if(dataPro.checkUsernameStatus(Username)){
                dataPro.lockUsername(Username);
                login.login(Username,Password,qty);
                dataPro.unlockUsername(Username);
            }
        }
        else {
            System.out.println("Username already in use, waiting for next 30 seconds");
            Thread.sleep(30000);
        }

    }

    @AfterTest
    public void Quit(){
        login.quit();
    }

}
