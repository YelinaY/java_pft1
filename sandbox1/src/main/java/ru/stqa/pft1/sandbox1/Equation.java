package ru.stqa.pft1.sandbox1;

public class Equation {
  private double a;
  private double b;
  private double c;
  private int n;

  public Equation(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;

    double d = b * b - 4 * a * c;
    if (d > 0) {
      n = 2;
    } else {
      if (d == 0) {
        n = 1;
      } else {
        n = 0;
      }
    }
  }
  //конструктор для теста EquationTest
  public int rootNumber(){
   return n;
  }
}