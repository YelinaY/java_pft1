package ru.stqa.pft1.sandbox1;

public class Primes {
  public static boolean isPrime(int n) {
    for (int i = 2; i < n; i = i + 1) {
      if (n % i == 0) {  //деление без остатка 1, 2, 3, 4...
        return false;
      }
    }
    return true;
  }

  //i = i +1    можно заменить  i++     i+= 2   - увеличение на 2
  public static boolean isPrimeWhile(int n) {
    int i = 2;
    while (i < n) {
      if (n % i == 0) // проаерка что "N" целое число
      {
        return false;
      }
      i++;
    }
    return true;
  }

/*
  public static int isPrimeWhiled() {
    for (int i = 0; i <= 10; i++) {
      return i;
       }
    return 0;
  }
  public static void isPrimeWhiled1 (int n) {
    for (int i = 0; i < 10; i += 2) {
      System.out.println(i);
    }
  }
*/
public static boolean isPrime(long n) {
  for (long i = 2; i < n; i = i + 1) {
    if (n % i == 0) {  //деление без остатка 1, 2, 3, 4...
      return false;
    }
  }
  return true;
}

}

