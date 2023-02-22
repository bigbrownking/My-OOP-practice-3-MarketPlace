import java.util.ArrayList;
import Devices.*;
import Mediator.Mediator;
public class Basket implements Mediator {

    private ArrayList<Devices> devices;
    public Basket(){
        devices = new ArrayList<Devices>();
    }

    @Override
    public int buy(ArrayList<Devices> devices) {
        int total = 0;
        for(Devices device: devices){
            total+=device.getPrice()*device.getCount();
        }
        return total;
    }
    @Override
    public String show(){
        String str = "";
        for( Devices devices : devices){
            str += devices.show()+"\n";
        }

        return str;
    }
    public void setDevices(ArrayList<Devices> devices) {
        this.devices = devices;
    }

    public ArrayList<Devices> getDevices() {
        return devices;
    }
    public void addDevice(Devices device){
        devices.add(device);
    }
}
