package ru.stqa.pft1.addressbook1.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String userfirstname;
  private final String usermiddlename;
  private final String userlastname;
  private final String usernickname;
  private final String usercompany;
  private final String useraddress;
  private final String userhomephone;
  private final String usermobilephone;
  private final String userworkphone;
  private final String userfax;
  private final String useremail;
  private final String useremail2;
  private final String useremail3;
  private final String userhomepage;
  private final String useraddress2;
  private final String userphone2;
  private final String usernotes;







  public ContactData(int id, String userfirstname, String usermiddlename,
                     String userlastname, String usernickname, String usercompany, String useraddress,
                     String userhomephone, String usermobilephone, String userworkphone, String userfax, String useremail,
                     String useremail2, String useremail3, String userhomepage, String useraddress2, String userphone2,
                     String usernotes) {
    this.id = 0;
    this.userfirstname = userfirstname;
    this.usermiddlename = usermiddlename;
    this.userlastname = userlastname;
    this.usernickname = usernickname;
    this.usercompany = usercompany;
    this.useraddress = useraddress;
    this.userhomephone = userhomephone;
    this.usermobilephone = usermobilephone;
    this.userworkphone = userworkphone;
    this.userfax = userfax;
    this.useremail = useremail;
    this.useremail2 = useremail2;
    this.useremail3 = useremail3;
    this.userhomepage = userhomepage;
    this.useraddress2 = useraddress2;
    this.userphone2 = userphone2;
    this.usernotes = usernotes;
  }

  public ContactData(String userfirstname, String usermiddlename,
                     String userlastname, String usernickname, String usercompany, String useraddress,
                     String userhomephone, String usermobilephone, String userworkphone, String userfax, String useremail,
                     String useremail2, String useremail3, String userhomepage, String useraddress2, String userphone2,
                     String usernotes) {
    this.id = id;
    this.userfirstname = userfirstname;
    this.usermiddlename = usermiddlename;
    this.userlastname = userlastname;
    this.usernickname = usernickname;
    this.usercompany = usercompany;
    this.useraddress = useraddress;
    this.userhomephone = userhomephone;
    this.usermobilephone = usermobilephone;
    this.userworkphone = userworkphone;
    this.userfax = userfax;
    this.useremail = useremail;
    this.useremail2 = useremail2;
    this.useremail3 = useremail3;
    this.userhomepage = userhomepage;
    this.useraddress2 = useraddress2;
    this.userphone2 = userphone2;
    this.usernotes = usernotes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData contactData = (ContactData) o;

    if (id != contactData.id) return false;
    if (userfirstname != null ? !userfirstname.equals(contactData.userfirstname) : contactData.userfirstname != null) return false;
    return userlastname != null ? userlastname.equals(contactData.userlastname) : contactData.userlastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (userfirstname != null ? userfirstname.hashCode() : 0);
    result = 31 * result + (userlastname != null ? userlastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", userfirstname='" + userfirstname + '\'' +
            ", userlastname='" + userlastname + '\'' +
            '}';
  }

  public int getId() {     return id;   }
  public String getUserfirstname() {
    return userfirstname;
  }
  public String getUsermiddlename() {
    return usermiddlename;
  }
  public String getUserlastname() {
    return userlastname;
  }
  public String getUsernickname() {
    return usernickname;
  }
  public String getUsercompany() {
    return usercompany;
  }
  public String getUseraddress() {
    return useraddress;
  }
  public String getUserhomephone() {
    return userhomephone;
  }
  public String getUsermobilephone() {
    return usermobilephone;
  }
  public String getUserworkphone() {
    return userworkphone;
  }
  public String getUserfax() {
    return userfax;
  }
  public String getUseremail() {
    return useremail;
  }
  public String getUseremail2() {
    return useremail2;
  }
  public String getUseremail3() {
    return useremail3;
  }
  public String getUserhomepage() {
    return userhomepage;
  }
  public String getUseraddress2() {
    return useraddress2;
  }
  public String getUserphone2() {
    return userphone2;
  }
  public String getUsernotes() {
    return usernotes;
  }

}

