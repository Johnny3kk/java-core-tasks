package box;

import sweeets.Sweets;

import java.math.BigDecimal;

public interface Box {

    void add(Sweets s);

    void addWithIndex(Sweets s, int i);

    Sweets getSweetsByIndex(int i);

    void remove(int i);

    void removeLast();

    int getBoxWeight();

    BigDecimal getTotalPrice();

    int getSize();

    String getInfo();

}
