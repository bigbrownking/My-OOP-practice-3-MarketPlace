package Devices;
public abstract class Devices implements ShowableDevices {
    private int price;
    private int id;
    private int count;
    private String brend;

    public Devices(){}
    public Devices(int id, int price, int count, String brend){
        this.brend = brend;
        this.id = id;
        this.price = price;
        this.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public String getBrend() {
        return brend;
    }
    public String show(){
        return "Price: "+getPrice()+" "+"Brand: "+getBrend()+" "+"Count: "+getCount();
    }
}
