package Mediator;

import Devices.Devices;
import java.util.ArrayList;
public interface Mediator {
    default String show(){
        return "00";
    };

    default int buy(ArrayList<Devices> devices) {
        return 0;
    }
    default boolean forAdmin(String login, String password){
        if(login.equals("admin") && password.equals("admin228")){
            return true;
        }
        return false;
    }
}
