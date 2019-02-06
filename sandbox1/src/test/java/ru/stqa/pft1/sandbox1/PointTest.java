package ru.stqa.pft1.sandbox1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testDistance() {
    Point p1 = new Point(2, 2);
    Point p2 = new Point(6, 8);
    Assert.assertEquals(p1.distance(p2), 7.211102550927978);
  }
/*
      2 вариант -негативный тест
      Point p1 = new Point(2,2);
      Point p2 = new Point(6,8);
      Assert.assertEquals(p1.distance (p2), 5.0);
    }
*/
}



