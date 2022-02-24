package sweeets;

import java.math.BigDecimal;

public class HardCandy extends Sweets{

    private int sweetness;

    public HardCandy(String name, int weight, BigDecimal price, int sweetness) {
        super(name, weight, price);
        this.sweetness = sweetness;
    }

    @Override
    public String toString() {
        return "HardCandy{" +
                "name= " + getName() +
                ", weight= " + getWeight() +
                ", price= " + getPrice() +
                ", sweetness= " + getUniq() +
                "}";
    }

    @Override
    public int getUniq() {
        return sweetness;
    }

    @Override
    public void setUniq(int i) {
        this.sweetness = i;
    }
}
