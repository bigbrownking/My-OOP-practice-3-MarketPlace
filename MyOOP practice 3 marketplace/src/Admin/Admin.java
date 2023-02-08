package Admin;

public class Admin implements Authentication {
    public Admin(String login, String password){
        if(forAdmin(login, password)){
            System.out.print("Great. ");
        }
        else{
           System.out.print("Try again. ");
        }
    }
}
