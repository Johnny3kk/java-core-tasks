package sweeets;

import java.math.BigDecimal;

public class Marshmallow extends Sweets {

    int softness;

    public Marshmallow(String name, int weight, BigDecimal price, int softness) {
        super(name, weight, price);
        this.softness = softness;
    }

    @Override
    public String toString() {
        return "Marshmallow{" +
                "name= " + getName() +
                ", weight= " + getWeight() +
                ", price= " + getPrice() +
                ", softness= " + getUniq() +
                '}';
    }

    @Override
    public int getUniq() {
        return softness;
    }

    @Override
    public void setUniq(int i) {
        this.softness = i;
    }
}
