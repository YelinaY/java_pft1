package ru.stqa.pft1.sandbox1;

import org.testng.annotations.Test;

public class SquareTests {
  @Test
  public void testArea(){
    Square s = new Square(4);
    assert s.area()==16;
  }
}
//вычисляется площадь прямоугольника
