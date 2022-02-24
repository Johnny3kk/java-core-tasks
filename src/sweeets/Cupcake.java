package sweeets;

import java.math.BigDecimal;

public class Cupcake extends Sweets {

    private int volume;

    public Cupcake(String name, int weight, BigDecimal price, int volume) {
        super(name, weight, price);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Cupcake{" +
                "name= " + getName() +
                ", weight= " + getWeight() +
                ", price= " + getPrice() +
                ", volume= " + getUniq() +
                "}";
    }

    @Override
    public int getUniq() {
        return volume;
    }

    @Override
    public void setUniq(int i) {
        this.volume = i;
    }
}
