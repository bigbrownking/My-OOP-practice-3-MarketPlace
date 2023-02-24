package Characteristic;
import Devices.Devices;
public class Keyboard extends Devices {
    private String model;
    private String Interface;
    private String type_ot_buttons;
    private double weight;
    public Keyboard(){}
    public Keyboard(int id, int price, int count, String brend, String model, String Interface, String type_of_buttons, double weight){
        super(id, price, count, brend);
        this.Interface = Interface;
        this.model = model;
        this.type_ot_buttons = type_of_buttons;
        this.weight = weight;
    }

    public void setInterface(String anInterface) {
        Interface = anInterface;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType_ot_buttons(String type_ot_buttons) {
        this.type_ot_buttons = type_ot_buttons;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getInterface() {
        return Interface;
    }

    public double getWeight() {
        return weight;
    }

    public String getModel() {
        return model;
    }

    public String getType_ot_buttons() {
        return type_ot_buttons;
    }
    @Override
    public String show(){
        return "Price: "+getPrice()+" "+"Count: "+getCount()+ " " +"Brand: "+getBrend()+" "+"Model: "+getModel();
    }
}
