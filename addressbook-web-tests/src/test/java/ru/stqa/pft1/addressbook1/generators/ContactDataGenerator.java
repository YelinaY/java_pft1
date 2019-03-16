package ru.stqa.pft1.addressbook1.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft1.addressbook1.model.ContactData;
import ru.stqa.pft1.addressbook1.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
  @Parameter(names ="-c", description = "Contact count")
  public int count;

  @Parameter (names = "-f", description = "Targets file")
  public String file;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    }catch (ParameterException ex) {
      jCommander.usage();
    return;
    }
    generator.runs();
     }

  private void runs() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    save(contacts, new File(file));
  }

  private void save(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;\n", contact.getUserfirstname(), contact.getUserlastname()));
    }
    writer.close();
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withUserfirstname(String.format("firstName %s", i)).
              withUserlastname(String.format("lastName %s", i)));
    }
    return contacts;
  }
}


