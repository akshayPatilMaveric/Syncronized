package org.example;

public class Login2 extends Thread {
    Smain log;
    Login2(Smain log){
        this.log=log;
    }
    public void login(){
        log.login("standard_user");
    }
}
