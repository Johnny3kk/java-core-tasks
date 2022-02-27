package java2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {

    Scanner sc = new Scanner(new File("src/java2/texts/most_important_text.txt"));
    List<String> list = new ArrayList<>();
    while (sc.hasNext()) {
      list.addAll(
          Arrays.asList(
              sc.nextLine()
                  .replaceAll("'", " ")
                  .toLowerCase()
                  .replaceAll("[^a-z]", " ")
                  .trim()
                  .split("\\s+")));
      if (list.get(list.size() - 1).equals("")) {
        list.remove(list.size() - 1);
      }
    }

    System.out.println(list);
    percentUsingWordsPrintList(list);
    maxUsingWord(list);
  }

  public static void percentUsingWordsPrintList(List<String> list) {
    int wordSum = list.size();
    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < list.size(); i++) {
      if (map.containsKey(list.get(i))) {
        map.put(list.get(i), map.get(list.get(i)) + 1);
      } else map.put(list.get(i), 1);
    }

    Map<String, Integer> sortedMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    sortedMap.putAll(map);

    for (Map.Entry<String, Integer> m : sortedMap.entrySet()) {
      double value = (double) m.getValue() * 100 / wordSum;
      System.out.println(m.getKey() + ": " + String.format("%.2f", value) + "%");
    }
  }

  public static void maxUsingWord(List<String> list) {
    int wordSum = list.size();
    int maxValue = Integer.MIN_VALUE;
    List<String> maxResults = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < list.size(); i++) {
      if (map.containsKey(list.get(i))) {
        map.put(list.get(i), map.get(list.get(i)) + 1);
      } else map.put(list.get(i), 1);
    }

    for (Map.Entry<String, Integer> m : map.entrySet()) {
      if (m.getValue() == maxValue) {
        maxResults.add(m.getKey());
      }
      if (m.getValue() > maxValue) {
        maxValue = m.getValue();
        maxResults.removeAll(maxResults);
        maxResults.add(m.getKey());
      }
    }
    double percentValue = (double) maxValue * 100 / wordSum;
    for (String s : maxResults) {
      System.out.println(
          "Максимальное число раз ("
              + maxValue
              + " или "
              + String.format("%.2f", percentValue)
              + "%) встречается слово: "
              + s);
    }
  }
}
