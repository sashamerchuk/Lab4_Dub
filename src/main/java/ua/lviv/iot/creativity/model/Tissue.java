package ua.lviv.iot.creativity.model;

import ua.lviv.iot.creativity.model.CreativityGood;
import ua.lviv.iot.creativity.model.Type;

public class Tissue extends CreativityGood {

    private int width;
    private int height;

    public Tissue() {
    }

    public Tissue(String name, int price, Type type, int width, int height) {
        super(name, price, type);
        this.width = width;
        this.height = height;
    }

    public String toString() {
        return super.toString() + " Width : " + width + "," + " Height : " + height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String getHeaders() {
        return super.toCSV() + "," + " width" + " height";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + "," + this.width + "," + this.height;
    }
}
