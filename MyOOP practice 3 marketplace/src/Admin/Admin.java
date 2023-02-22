package Admin;

import Mediator.Mediator;

public class Admin implements Mediator {
    public Admin(String login, String password){
        if(forAdmin(login, password)){
            System.out.print("Great. ");
        }
        else{
           System.out.print("Try again... ");
        }
    }
}
