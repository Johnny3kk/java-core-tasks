import box.Box;
import box.BoxImpl;
import sweeets.Chocolate;
import sweeets.Cupcake;
import sweeets.HardCandy;
import sweeets.Marshmallow;

import java.math.BigDecimal;

public class Main {

  public static void main(String[] args) {

    Chocolate cho = new Chocolate("confi", 100, new BigDecimal("55"), 55);
    Marshmallow mar = new Marshmallow("marsh", 330, new BigDecimal("88"), 50);
    HardCandy hc = new HardCandy("candy", 10, new BigDecimal("10"), 77);
    Cupcake cup = new Cupcake("cake", 450, new BigDecimal("110"), 44);
    Box box = new BoxImpl();

    box.add(cho);
    box.add(mar);
    box.add(hc);
    box.add(cup);
    System.out.println(box.getInfo());
  }
}
