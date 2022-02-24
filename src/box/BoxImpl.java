package box;

import sweeets.Sweets;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class BoxImpl implements Box {

    private List<Sweets> list = new ArrayList();

    @Override
    public void add(Sweets s) {
        list.add(s);
    }

    @Override
    public void remove(int i) {
        list.remove(i);
    }

    @Override
    public void removeLast() {
        list.remove(list.size() - 1);
    }

    @Override
    public int getWeight() {
        int sum = 0;
        for (Sweets s : list) {
            sum = sum + s.getWeight();
        }
        return sum;
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal sum = new BigDecimal("0");
        for (Sweets s : list) {
            sum = sum.add(s.getPrice());
        }
        return sum;
    }

    @Override
    public String getInfo() {
        return list.toString();
    }
}
