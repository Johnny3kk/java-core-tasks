import java.math.BigDecimal;

public interface Box {

    void add();

    void remove();

    void removeLast();

    int getWeight();

    BigDecimal getTotalPrice();

    String getInfo();

}
