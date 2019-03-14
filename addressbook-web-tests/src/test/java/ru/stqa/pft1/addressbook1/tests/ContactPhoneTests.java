package ru.stqa.pft1.addressbook1.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
public class ContactPhoneTests extends TestBase {

  @Test //(enabled = false)
  public void testContactPhones() {
    app.groupsContacts().gotoHomePage();
    ContactData contact = app.groupsContacts().allc().iterator().next();
    ContactData contactInfoFromEditForm = app.groupsContacts().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
  }
  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getUserhomephone(), contact.getUsermobilephone(), contact.getUserworkphone()).
            stream().filter((s) -> !s.equals("")).
            map(ContactPhoneTests::cleaned).
            collect(Collectors.joining("\n"));
  }
  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");// функция удаляет ненужные символы при сравнении
    //    "\\s"  заменить пробел на пустую строку (удалить при проверке)
  }
}