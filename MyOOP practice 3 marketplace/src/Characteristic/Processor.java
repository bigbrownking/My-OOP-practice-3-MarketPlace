package Characteristic;
import Devices.Devices;
public class Processor extends Devices {
    private String model;
    private int GB;
    private double hz;
    private int countNucleus;
    private String type;

    public Processor(int id, int price, int count, String brend, String model,double hz, int countNucleus, int GB, String type) {
        super(id, price, count, brend);
        this.model = model;
        this.countNucleus = countNucleus;
        this.GB = GB;
        this.hz = hz;
        this.type = type;

    }

    public void setHz(double hz) {
        this.hz = hz;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getHz() {
        return hz;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCountNucleus(int countNucleus) {
        this.countNucleus = countNucleus;
    }


    public String getModel() {
        return model;
    }

    public void setGB(int GB) {
        this.GB = GB;
    }

    public int getGB() {
        return GB;
    }

    public int getCountNucleus() {
        return countNucleus;
    }
    @Override
    public String show(){
        return "Price: "+getPrice()+" "+"Count: "+getCount()+" "+"Brand: "+ getBrend()+" "+"Model: "+ getModel();
    }

}


