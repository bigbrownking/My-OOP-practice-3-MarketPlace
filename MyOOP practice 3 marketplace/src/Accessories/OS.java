package Accessories;
import Devices.*;
public abstract class OS extends Laptop {
    private String osType;
    private int price;
    public OS(){}
    public OS(String osType, int price){
        this.osType = osType;
        this.price = price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setOsType(String osType) {
        this.osType = osType;
    }

    public int getPrice() {
        return price;
    }

    public String getOsType() {
        return osType;
    }

}