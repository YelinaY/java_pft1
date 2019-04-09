package ru.stqa.pft1.sandbox1;

public class CycleWhile {
  public static void main(String[] args) {
    int i = 0;
    while (i < 100) {
      System.out.println(i + "");
      i++;
    }
    int a = 5;
    while (a > 10) {
      System.out.println("Мы в цикле While"); // пока...
    }
    do {
      System.out.println("Мы в цикле do-while"); //делать пока..
    }while (a>10);
    a=0;

  }
}
