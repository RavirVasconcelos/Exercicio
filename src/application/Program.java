package application;

import entities.Product;
import entities.ImportedProduct;
import entities.UsedProduct;

import java.util.Locale;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Program {

  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    List<Product> list = new ArrayList<>();

    System.out.print("Enter the number of products: ");
    int n = sc.nextInt();
    sc.nextLine();

    System.out.println();

    for (int i = 1; i <= n; i++) {

      System.out.println("Product #" + i + " data:");
      System.out.print("Common, used, imported (c/u/i)? ");
      char type = sc.nextLine().charAt(0);

      System.out.print("Name: ");
      String name = sc.nextLine();
      System.out.print("Price: ");
      double price = sc.nextDouble();
      sc.nextLine();

      if (type == 'i') {

        System.out.print("Customs fee: ");
        double customsFee = sc.nextDouble();
        sc.nextLine();

        list.add(new ImportedProduct(name, price, customsFee));
        
        System.out.println();
      }
      else if (type == 'u') {

        System.out.print("Manufacture date (DD/MM/YYYY): ");
        LocalDate manufactureDate = LocalDate.parse(sc.nextLine(), fmt);

        list.add(new UsedProduct(name, price, manufactureDate));

        System.out.println();
      }
      else {

        list.add(new Product(name, price));

        System.out.println();
      }
    }

    System.out.println("PRICE TAGS:");

    for(Product product : list) {

      System.out.println(product.priceTag());
    }
  }
}