package org.example;

public class Slog {

    // The class to call the threads for login using the concepts of the synchronization..
    // Contains Main method, and instances for the 2 classes
    public static void main(String args[]){
    final Smain mainobj= new Smain();
    mainobj.launchbrowser();
    //Login for the first user
    Login1 l1=new Login1(mainobj);
    //Login for the second user
    Login2 l2=new Login2(mainobj);
    try{
        //Executing the Threads
    l1.start();
    l2.start();}
    catch (Exception e){
        System.out.println(e);
    }
    //mainobj.quit();

    }
}
