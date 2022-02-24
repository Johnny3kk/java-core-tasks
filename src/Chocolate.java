import java.math.BigDecimal;

public class Chocolate extends Sweets {

    private int bitterness;

    public Chocolate(String name, int weight, BigDecimal price, int bitterness) {
        super(name, weight, price);
        this.bitterness = bitterness;
    }


    @Override
    public String toString() {
        return "Chocolate{" +
                "name=" + getName() +
                ", weight='" + getWeight() +
                ", price=" + getPrice() +
                ", bitterness=" + getUniq() +
                '}';
    }

    @Override
    public int getUniq() {
        return bitterness;
    }

    @Override
    public void setUniq(int bitterness) {
        this.bitterness = bitterness;
    }
}
