package org.example;

public class Login1 extends Thread{
    Smain log;
    Login1(Smain log){
        this.log=log;
    }
    public void login(){
        log.login("problem_user");
    }
}
