package ru.stqa.pft1.sandbox1;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("Alex");
    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + "=" + s.area()); //вызов метода s.area

    Rectangle r = new Rectangle(4,6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area()); //вызов метода r.area

    Point p = new Point(2,4,6,8);
    System.out.println("Расстояние между двумя точками  с координатами x1y1 и x2y2 = " + p.distance ()); //вызов метода p.distance ());

  }

  public static void hello(String somebody) {
    System.out.println("Hello," + somebody);
  }



}

//Hello,Alex
//Площадь квадрата со стороной5.0=25.0
//Площадь прямоугольника со сторонами4.0и6.0=24.0