package org.example;

import org.testng.annotations.DataProvider;

import java.util.Dictionary;
import java.util.Hashtable;

public class DP {
    public Dictionary<String,String> usernameStatus=new Hashtable<>();
    @DataProvider(name = "Usernames")
    public Object[][] dpUsernames(){
        return new Object[][] {
                {"standard_user","secret_sauce",3},
                {"problem_user","secret_sauce",10},
                {"standard_user","secret_sauce",4}
        };
    }
    public DP(){
        usernameStatus.put("standard_user","open");
        usernameStatus.put("problem_user","open");
    }
    public void lockUsername(String Username){
        usernameStatus.remove(Username);
        usernameStatus.put(Username,"locked");
    }
    public void unlockUsername(String Username){
        usernameStatus.remove(Username);
        usernameStatus.put(Username,"open");
    }
    public boolean checkUsernameStatus(String Username){
        if(usernameStatus.get(Username).equals("open")){
            return true;
        }
        else{
            return false;
        }
    }

}
