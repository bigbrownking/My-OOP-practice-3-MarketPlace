package Types;

import Accessories.*;

public class Gaming extends Types{
    public Gaming(){};
    public Gaming(int id, int price, int count, String brend, String type, OS os, Characteristic characteristic){
        super(id, price, count,brend, type, os, characteristic);
    }
    @Override
    public String show(){
        return "ID: "+getId()+" "+"Price: "+getPrice()+" "+"Count: "+" "+"Brand: "+" "+"Type: "+getType()+" "+"OS: "+getOs()+
                "Characteristics: "+getCharacteristic();
    }



}
