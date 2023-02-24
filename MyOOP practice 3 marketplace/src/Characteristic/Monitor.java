package Characteristic;
import Devices.Devices;
public class Monitor extends Devices{
    private int Hz;
    private String matrix;
    private String quality;
    private double diagonal;
    private String model;
    public Monitor(){}
    public Monitor(int id, int price, int count, String brend,String model,int hz,double diagonal, String matrix, String quality ){
        super(id, price, count, brend);
        this.Hz = hz;
        this.model = model;
        this.diagonal = diagonal;
        this.matrix = matrix;
        this.quality = quality;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setHz(int hz) {
        Hz = hz;
    }

    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public int getHz() {
        return Hz;
    }

    public String getMatrix() {
        return matrix;
    }

    public String getQuality() {
        return quality;
    }
    @Override
    public String show(){
        return "Price: "+getPrice()+" "+"Count: "+getCount()+" "+"Brand: "+getBrend()+" "+"Model: "+getModel();
    }
}
