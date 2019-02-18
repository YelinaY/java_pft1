package ru.stqa.pft1.addressbook1.model;

public class ContactData {
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
  private String group;


  public ContactData(String userfirstname, String usermiddlename,
                     String userlastname, String usernickname, String usercompany, String useraddress,
                     String userhomephone, String usermobilephone, String userworkphone, String userfax, String useremail,
                     String useremail2, String useremail3, String userhomepage, String useraddress2, String userphone2,
                     String usernotes, String group) {
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

    this.group = group;
  }

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


  public String getGroup() { return group;
  }
}

