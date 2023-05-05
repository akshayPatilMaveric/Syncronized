package org.example;

import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

public class DP {
    public Map<String, String> usernameStatus = new HashMap<>();

    @DataProvider(name = "Usernames", parallel = true)
    public Object[][] dpUsernames() {
        return new Object[][] {
                { "standard_user", "secret_sauce", 3 },
                { "problem_user", "secret_sauce", 10 },
                { "standard_user", "secret_sauce", 4 }
        };
    }

    public void lockUsername(String username) {
        long threadId = Thread.currentThread().getId();
        if (checkUsernameStatus(username)) {
            usernameStatus.put(username, "locked");
        } else {
            while(!checkUsernameStatus(username)) {
                System.out.println(threadId + " Waiting for the user to be available " + username);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(threadId + " Locked user name " + username);
    }

    public void unlockUsername(String username) {
        long threadId = Thread.currentThread().getId();
        usernameStatus.put(username, "unlocked");
        System.out.println(threadId + " Unlocked user name " + username);
    }

    public synchronized boolean checkUsernameStatus(String username) {
        if (usernameStatus.containsKey(username)) {
            if (usernameStatus.get(username).equals("unlocked")) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }

    }

}
