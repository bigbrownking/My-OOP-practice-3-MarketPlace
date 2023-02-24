package Accessories;

import Devices.Devices;

public abstract class Types extends Devices {
    private String type;
    private OS os;
    private Characteristic characteristic;

    public Types(){};
    public Types(int id, int price, int count, String brend, String type, OS os, Characteristic characteristic){
        super(id, price, count, brend);
        this.type = type;
        this.os = os;
        this.characteristic = characteristic;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public void setCharacteristic(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

    public OS getOs() {
        return os;
    }
}
