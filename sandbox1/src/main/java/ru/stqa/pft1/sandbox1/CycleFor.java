package ru.stqa.pft1.sandbox1;

public class CycleFor {
  public static void main(String[] args) {
    for (int i = 0; i <= 10; i++) {
      System.out.println(i + "");
    }
    for (int i = 0; i < 10; i += 2) {
      System.out.println(i);
    }
  }

}