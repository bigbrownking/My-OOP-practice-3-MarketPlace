package Devices;

import Accessories.*;

public class PC extends Devices implements ShowableDevices{
    private String os;
    private String type;
    private String characteristic;
    public PC() {
    }

    public PC(int id, int price, int count, String brend, String os, String type, String characteristic) {
        super(id, price, count, brend);
        this.os = os;
        this.type = type;
        this.characteristic = characteristic;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }


    public String getOs() {
        return os;
    }

    public String getType() {
        return type;
    }

    public String getCharacteristic() {
        return characteristic;
    }
    @Override
    public String show(){
        return "Price: "+getPrice()+" "+"Count: "+getCount()+" "+"Brand: "+getBrend()+" "+"OS: "+getOs()+" "+"Type"+
                getType();
    }
}
