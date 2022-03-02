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

  public static void main(String[] args) throws Exception {

    Scanner console = new Scanner(System.in);
    Gson gson = new Gson();
    Reader reader = Files.newBufferedReader(Paths.get(JSON_PATH));
    LocalDate today = LocalDate.now();

    Companies companies = gson.fromJson(reader, Companies.class);
    companies
        .getCompanies()
        .forEach(
            c ->
                System.out.println(
                    c.getName()
                        + " - Дата основания "
                        + LocalDate.parse(c.getFounded(), formatter1).format(formatter2)));
    expiredSecurities(companies.getCompanies());
    System.out.println(
        "=============================================================================================================================================");
    System.out.println(
        "1. Для получения информации о компаниях, основанных позже определённой даты, введите запрос в виде:"
            + " ДД.ММ.ГГГГ; ДД.ММ,ГГ; ДД/ММ/ГГГГ; ДД/ММ/ГГ.\n"
            + "2. Для вывода информации о ценных бумагах, использующих определённую валюту, введите запрос в виде:"
            + " EU; USD; RUB");
    String in = console.nextLine();
    if (Arrays.stream(in.split("")).anyMatch(s -> s.matches("\\d"))) {
      companiesFoundedAfterDate(in, companies.getCompanies());
    } else securitiesByCurrency(in, companies.getCompanies());
  }

  public static void expiredSecurities(List<Company> list) {
    list
        .forEach(
            c -> {
              System.out.print(c.getName() + " ценные бумаги с истёкшим сроком: ");
              c.getSecurities().stream()
                  .filter(s -> LocalDate.parse(s.getDate(), formatter1).isBefore(TODAY))
                  .forEach(
                      s ->
                          System.out.print(
                              "{" + s.getCode() + ", " + s.getDate() + ", " + s.getName() + "}, "));
              System.out.println(
                  "количество истёкших ценных бумаг компании = "
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
      if (Integer.parseInt(arr[2]) > 70) {
          string = sb.append(arr[0]).append(".").append(arr[1]).append(".").append("19").append(arr[2]).toString();
      } else {
          string = sb.append(arr[0]).append(".").append(arr[1]).append(".").append("20").append(arr[2]).toString();
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

  public static void securitiesByCurrency(String str, List<Company> list) {
    List<Securities> formatedSecuritiesList = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    list.forEach(
        c -> {
          formatedSecuritiesList.addAll(
              c.getSecurities().stream()
                  .filter(s -> s.getCurrency().contains(str))
                  .collect(Collectors.toList()));
        });

    formatedSecuritiesList.forEach(
        s -> {
          if (!map.containsKey(s.getName())) {
            map.put(s.getName(), s.getCode());
          }
        });

    map.forEach((key, value) -> System.out.println(key + " - code:" + value));
  }

}
