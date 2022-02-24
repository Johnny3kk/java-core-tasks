import java.math.BigDecimal;

public abstract class Sweets {

    private String name;
    private int weight;
    private BigDecimal price;

    public Sweets(String name, int weight, BigDecimal price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public abstract int getUniq();

    public abstract void setUniq(int i);

}
