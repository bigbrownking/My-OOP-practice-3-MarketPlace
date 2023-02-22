package Accessories;

import Characteristic.*;
import Devices.Devices;

public abstract class Characteristic extends Devices {
    private Monitor monitor;
    private Mouse mouse;
    private Keyboard keyboard;
    private Processor processor;
    public Characteristic(){}
    public Characteristic(int id, int price, int count, String brend, Monitor monitor, Mouse mouse, Processor processor, Keyboard keyboard){
        super(id, price, count, brend);
        this.monitor = monitor;
        this.mouse = mouse;
        this.processor = processor;
        this.keyboard = keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Processor getProcessor() {
        return processor;
    }
}
