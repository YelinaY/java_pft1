package ru.stqa.pft1.mantis.tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
  @Test
  public void testRegistration(){
    app.registration().start("User1", "user1@localhost.localdomain");
  }
}
