package Characteristic;
import Devices.Devices;
public class Mouse extends Devices{
    private String model;
    private double weight;
    private int bottoms;
    private String sensitivity;
    private String connection;
    public Mouse(){}
    public Mouse(int id, int price, int count, String brend, String model, double weight, int bottoms, String sensitivity, String connection){
        super(id, price, count, brend);
        this.model = model;
        this.weight = weight;
        this.bottoms = bottoms;
        this.sensitivity = sensitivity;
        this.connection = connection;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setSensitivity(String sensitivity) {
        this.sensitivity = sensitivity;
    }
    public String getModel() {
        return model;
    }

    public String getSensitivity() {
        return sensitivity;
    }

    public void setBottoms(int bottoms) {
        this.bottoms = bottoms;
    }

    public int getBottoms() {
        return bottoms;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getConnection() {
        return connection;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
    @Override
    public String show(){
        return "Price: "+getPrice()+" "+"Count: "+getCount()+" "+"Brand: "+getBrend()+" "+"Model: "+getModel();
    }
}
