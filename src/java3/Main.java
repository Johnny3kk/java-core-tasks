package java3;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static final String JSON_PATH = "src\\java3\\json\\companies";
   public static final LocalDate TODAY = LocalDate.now();
    public static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    public static DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM,yy");
    public static DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("dd/MM/yy");

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
                        + LocalDate.parse(c.getFounded(), formatter1).format(formatter4)));
    expiredSecurities(companies.getCompanies());
    System.out.println("=============================================================================================================================================");
    System.out.println("1. Для получения информации о компаниях, основанных позже определённой даты, введите запрос в виде:" +
            " ДД.ММ.ГГ; ДД.ММ,ГГ; ДД/ММ/ГГГГ; ДД/ММ/ГГ.\n" +
            "2. Для вывода информации о ценных бумагах, использующих определённую валюту, введите запрос в виде:" +
            " EU; USD; RUB");
    String in = console.nextLine();
    System.out.println(in);
  }

  public static void expiredSecurities(List<Company> list) {
    list.stream()
        .forEach(
            c -> {
              System.out.print(c.getName() + ": ");
              c.getSecurities().stream()
                  .filter(s -> LocalDate.parse(s.getDate(), formatter1).isBefore(TODAY))
                  .forEach(
                      s ->
                          System.out.print(
                              "{" + s.getCode() + ", " + s.getDate() + ", " + s.getName() + "}"));
              System.out.println(" количество истёкших ценных бумаг компании = " + c.getSecurities().stream()
                      .filter(s -> LocalDate.parse(s.getDate(), formatter1).isBefore(TODAY)).count());
            });
  }
}
