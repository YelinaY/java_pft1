package ru.stqa.pft1.sandbox1;

import org.testng.Assert;
import org.testng.annotations.Test;
public class PointTest {

    @Test
    public void testDistance(){
      Point p = new Point(2,2,2,2); // Две точки имеют одинаковые координатоы (расстояние должно равняться "0"
      Assert.assertEquals(p.distance(), 0);
    }
/*
 2 вариант
 Point p = new Point(2,4,6,8);
      Assert.assertEquals(p.distance(), 5.656854249492381);
    }
3 вариант -негативный тест
Point p = new Point(2,4,6,8);
      Assert.assertEquals(p.distance(), 5.0);
    }
*/
  }



