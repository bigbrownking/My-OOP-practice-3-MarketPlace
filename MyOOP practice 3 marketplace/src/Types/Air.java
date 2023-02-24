package Types;
import Accessories.*;
public class Air extends Types {
    public Air(){}
    public Air(int id, int price, int count, String brend, String type, OS os, Characteristic characteristic){
        super(id, price, count, brend, type, os, characteristic);
    }
    @Override
    public String show(){
        return "ID: "+getId()+" "+"Price: "+getPrice()+" "+"Count: "+" "+"Brand: "+" "+"Type: "+getType()+" "+"OS: "+getOs()+
                "Characteristics: "+getCharacteristic();
    }
}
