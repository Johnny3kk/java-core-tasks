import box.Box;
import box.BoxImpl;
import sweeets.*;

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
    System.out.println(box.getBoxWeight());

    minPriceBoxOptimization(800, box);
    System.out.println(box.getInfo());
    System.out.println(box.getBoxWeight());
  }

  public static void minWeightBoxOptimization(int weightBorder, Box box) {
    int steps = box.getSize();
    if (box.getBoxWeight() > weightBorder) {
      for (int i = 0; i < steps; i++) {
        int min = box.getSweetsByIndex(0).getWeight();
        int index = 0;
        for (int j = 1; j < box.getSize(); j++) {
          if (box.getSweetsByIndex(j).getWeight() < min) {
            min = box.getSweetsByIndex(j).getWeight();
            index = j;
          }
        }
        box.remove(index);
        if (box.getBoxWeight() <= weightBorder) {
          break;
        }
      }
    }
  }
  public static void minPriceBoxOptimization(int weightBorder, Box box) {
    int steps = box.getSize();
    if (box.getBoxWeight() > weightBorder) {
      for (int i = 0; i < steps; i++) {
        BigDecimal min = box.getSweetsByIndex(0).getPrice();
        int index = 0;
        for (int j = 1; j < box.getSize(); j++) {
          if (box.getSweetsByIndex(j).getPrice().compareTo(min) < 0) {
            min = box.getSweetsByIndex(j).getPrice();
            index = j;
          }
        }
        box.remove(index);
        if (box.getBoxWeight() <= weightBorder) {
          break;
        }
      }
    }
  }

}
