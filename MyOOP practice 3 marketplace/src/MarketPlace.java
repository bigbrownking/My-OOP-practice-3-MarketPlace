import java.util.ArrayList;

public class MarketPlace{

    private String name;
    private int storage;
    public MarketPlace(String name, int storage){
        this.name = name;
        this.storage = storage;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getName() {
        return name;
    }



    public int getStorage() {
        return storage;
    }



}
