import java.util.ArrayList;
import Devices.*;
import java.util.Random;
public class Basket implements Buyable, ShowableBasket {
    Random r = new Random();
    private long random = r.nextLong(1000000, 9999999);
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

    public long getRandom() {
        return random;
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
