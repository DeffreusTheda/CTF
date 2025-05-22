package org.effietheda;

import java.util.Scanner;

public class FlagChecker {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter flag: ");
    String input = scanner.nextLine();
    
    if (input.equals("QNQSEC{testflag}")) {
      System.out.println("Congratss :DD\nFlag is indeed " + input);
    } else {
      System.out.println("Wrong!");
    }
  }
}
