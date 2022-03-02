package java3;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

  public static final String JSON_PATH = "src\\java3\\json\\companies";
  public static final LocalDate TODAY = LocalDate.now();
  public static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
  public static DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yy");

  public static void main(String[] args) {

    Scanner console = new Scanner(System.in);
    List<Company> list = new ArrayList<>();
    try {
      Gson gson = new Gson();
      Reader reader = Files.newBufferedReader(Paths.get(JSON_PATH));

      Companies companies = gson.fromJson(reader, Companies.class);
      list = companies.getCompanies();
      list.forEach(
          c ->
              System.out.println(
                  c.getName()
                      + " - Дата основания "
                      + LocalDate.parse(c.getFounded(), formatter1).format(formatter2)));
      expiredSecurities(companies.getCompanies());
    } catch (Exception e) {
      System.out.println(e.getMessage() + " Проверьте содержимое json-файла");
    }
    System.out.println(
        "=============================================================================================================================================");
    System.out.println(
        "1. Для получения информации о компаниях, основанных позже определённой даты, введите запрос в виде:"
            + " ДД.ММ.ГГГГ; ДД.ММ,ГГ; ДД/ММ/ГГГГ; ДД/ММ/ГГ.\n"
            + "2. Для вывода информации о ценных бумагах, использующих определённую валюту, введите запрос в виде:"
            + " EU; USD; RUB");
    String in;
    try {
      in = console.nextLine();
      if (in.split("").length > 10) {
        throw new Exception("Запрос не соответствует минимальным условиям.");
      }
      if (Arrays.stream(in.split("")).anyMatch(s -> s.matches("\\d"))) {
        companiesFoundedAfterDate(in, list);
      } else securitiesByCurrency(in, list);
    } catch (Exception e) {
      System.out.println(e.getMessage() + " Ошибка в запросе, проверьте передоваемые данные");
    }
  }

  public static void expiredSecurities(List<Company> list) {
    list.forEach(
        c -> {
          System.out.print(c.getName() + " - ценные бумаги с истёкшим сроком: ");
          c.getSecurities().stream()
              .filter(s -> LocalDate.parse(s.getDate(), formatter1).isBefore(TODAY))
              .forEach(
                  s ->
                      System.out.print(
                          "{" + s.getCode() + ", " + s.getDate() + ", " + s.getName() + "}, "));
          System.out.println(
              "в количестве = "
                  + c.getSecurities().stream()
                      .filter(s -> LocalDate.parse(s.getDate(), formatter1).isBefore(TODAY))
                      .count());
        });
  }

  public static void companiesFoundedAfterDate(String str, List<Company> list) {
    List<String> strings = Arrays.asList(str.split(""));
    String string;

    if (strings.size() > 8) {
      string = str.replaceAll("[^\\d]", ".");
    } else {
      String[] arr = str.split("[^\\d]");
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 2; i++) {
        if (Integer.parseInt(arr[i]) < 10) {
          sb.append(0).append(Integer.parseInt(arr[i])).append(".");
        }
      }
      if (Integer.parseInt(arr[2]) > 69) {
        string = sb.append("19").append(arr[2]).toString();
      } else {
        string = sb.append("20").append(arr[2]).toString();
      }
    }
    list.stream()
        .filter(
            c ->
                LocalDate.parse(c.getFounded(), formatter1)
                    .isAfter(LocalDate.parse(string, formatter1)))
        .forEach(
            c ->
                System.out.println(
                    c.getName()
                        + " - Дата основания "
                        + LocalDate.parse(c.getFounded(), formatter1).format(formatter2)));
  }

  public static void securitiesByCurrency(String str, List<Company> list) throws Exception {
    String string = str.toUpperCase();
    List<Securities> formatedSecuritiesList = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    list.forEach(
        c ->
            formatedSecuritiesList.addAll(
                c.getSecurities().stream()
                    .filter(s -> s.getCurrency().contains(string))
                    .collect(Collectors.toList())));

    formatedSecuritiesList.forEach(
        s -> {
          if (!map.containsKey(s.getName())) {
            map.put(s.getName(), s.getCode());
          }
        });

    if (formatedSecuritiesList.size() == 0) {
        throw new Exception("По введённому запросу ничего не найдено.");
    }
    map.forEach((key, value) -> System.out.println(key + " - code:" + value));
  }

}
