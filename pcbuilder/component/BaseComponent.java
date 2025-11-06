package component;
public abstract class BaseComponent {
    protected String name;
    protected double price;

    public BaseComponent(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
    
    public String getName() {
        return this.name;
    }
}