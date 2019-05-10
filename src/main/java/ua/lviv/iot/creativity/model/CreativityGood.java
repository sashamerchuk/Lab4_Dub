package ua.lviv.iot.creativity.model;

public class CreativityGood {
    private int price;
    private Type type;
    private String name;

    public CreativityGood() {
    };

    public CreativityGood(String name, int price, Type type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String toString() {
        return "Creativity goods : " + " Name : " + name + "," + " Price : " + price + "," + " Type : " + type + ",";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    public String getHeaders() {
        return "type" + "," + "price" + "," + "name";
    }
public String toCSV() {
return this.type + "," + this.price + "," + this.name;
}
}