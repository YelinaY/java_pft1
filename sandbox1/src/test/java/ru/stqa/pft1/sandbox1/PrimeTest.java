package ru.stqa.pft1.sandbox1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTest {
  @Test
  public void testPrimes(){
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }
  @Test
  public void testNonPrimes(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }
  }
