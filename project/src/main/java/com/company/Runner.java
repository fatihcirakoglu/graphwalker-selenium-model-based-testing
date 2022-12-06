package com.company;

import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import java.io.IOException;

public class Runner {
  public static void main(String[] args) throws IOException {
      Executor executor1 = new TestExecutor(
              PazaramaLoginLogoutTest.class
      );

      Executor executor2 = new TestExecutor(
              PazaramaFailLoginTest.class
      );

      Executor executor3 = new TestExecutor(
              PazaramaSearchItemTest.class
      );

      Executor executor4 = new TestExecutor(
              PazaramaAddShoppingCartTest.class
      );

      Result result1 = executor1.execute(true);
      System.out.println("Done: [" + result1.getResults().toString(2) + "]");

      Result result2 = executor2.execute(true);
      System.out.println("Done: [" + result2.getResults().toString(2) + "]");

      Result result3 = executor3.execute(true);
      System.out.println("Done: [" + result3.getResults().toString(2) + "]");

      Result result4 = executor4.execute(true);
      System.out.println("Done: [" + result4.getResults().toString(2) + "]");
  }
}
