package Characteristic;
import Devices.Devices;

import java.util.ArrayList;

public class MemoryCard extends Devices{
    private int GB;
    private String model;
    public MemoryCard(int id, int price, int count, String brend, String model, int GB){
        super(id,price,count, brend);
        this.model = model;
        this.GB = GB;
    }

    public void setGB(int capacity) {
        this.GB = capacity;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getGB() {
        return GB;
    }

    public String getModel() {
        return model;
    }

}
