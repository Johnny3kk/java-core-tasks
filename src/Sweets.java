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

    public abstract String getName();

    public abstract void setName(String name);

    public abstract int getWeight();

    public abstract void setWeight(int weight);

    public abstract BigDecimal getPrice();

    public abstract void setPrice(BigDecimal price);
}
