import sweeets.Chocolate;

import java.math.BigDecimal;

public class Main {

  public static void main(String[] args) {

    Chocolate cho = new Chocolate("confi", 100, new BigDecimal("55"), 55);
    System.out.println(cho);
  }
}
