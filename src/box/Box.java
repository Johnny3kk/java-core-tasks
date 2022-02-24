package box;

import sweeets.Sweets;

import java.math.BigDecimal;

public interface Box {

    void add(Sweets s);

    void remove(int i);

    void removeLast();

    int getWeight();

    BigDecimal getTotalPrice();

    String getInfo();

}
