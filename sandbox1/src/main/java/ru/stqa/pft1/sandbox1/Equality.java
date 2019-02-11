package ru.stqa.pft1.sandbox1;
//проверить, что s1=s2 объект s1 равен s2
//объекты можно сравнивать только методом s1.equals(s2)
//цифры можно сравнивать методом "==", s1==s2, если s1=2, ...
public class Equality {
  public static void main (String [] args){
    String s1 = "firefox";
    String s2 = new String (s1);
    //String s2 = new String(s1);
    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
  }
}
