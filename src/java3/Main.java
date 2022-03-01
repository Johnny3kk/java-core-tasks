package java3;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static final String JSON_PATH = "src\\java3\\json\\companies";

  public static void main(String[] args) throws Exception {

    Gson gson = new Gson();

    Reader reader = Files.newBufferedReader(Paths.get(JSON_PATH));
    Companies cy = gson.fromJson(reader, Companies.class);
    System.out.println(cy.getCompanies().get(0).getSecurities().get(0).getCurrency());

  }
}
