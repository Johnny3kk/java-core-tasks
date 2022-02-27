package java2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {

    Scanner sc = new Scanner(new File("src/java2/texts/most_important_text.txt"));
    List<String> list = new ArrayList<>();
    while (sc.hasNext()) {
      list.addAll(
          Arrays.asList(
              sc.nextLine()
                  .trim()
                  .replaceAll("'", " ")
                  .toLowerCase()
                  .replaceAll("[^a-z]", " ")
                  .split("\\s+")));
      if (list.get(list.size() - 1).equals("")) {
        list.remove(list.size() - 1);
      }
    }

    System.out.println(list);
  }
}
