package Admin;

public interface Authentication {
     default boolean forAdmin(String login, String password){
         if(login.equals("root") && password.equals("12345")){
             return true;
         }
         return false;
    }
}
