package ru.stqa.pft1.addressbook1.tests;

import org.testng.annotations.Test;
import ru.stqa.pft1.addressbook1.model.ContactData;
import ru.stqa.pft1.addressbook1.model.Contacts;
import java.sql.*;

public class DbConnectionTestC {
  @Test
  public void testDbConnectionContact() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery("select id,firstname,lastname from addressbook");
      //ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");

      Contacts contacts = new Contacts();
      while (rs.next()) {
        contacts.add(new ContactData().withId(rs.getInt("id")).withUserfirstname(rs.getString("firstname"))
                .withUserlastname(rs.getString("lastname")));

      }
      rs.close();
      st.close();
      conn.close();
      System.out.println(contacts);
      // Do something with the Connection


    } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
    }
  }
}



