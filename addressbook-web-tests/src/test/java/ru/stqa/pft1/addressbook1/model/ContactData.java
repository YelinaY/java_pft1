package ru.stqa.pft1.addressbook1.model;

import java.io.File;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String userfirstname;
  private String usermiddlename;
  private String userlastname;
  private String usernickname;
  private String usercompany;
  private String useraddress;
  private String userhomephone;
  private String usermobilephone;
  private String userworkphone;
  private String useremail;
  private String useremail2;
  private String useremail3;
  private String userhomepage;
  private String useraddress2;
  private String usernotes;
  private String allPhones;
  private String allEmails;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }


  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
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

  public String getUserfirstname() {     return userfirstname;  }

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


  public String getUsernotes() {
    return usernotes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (userfirstname != null ? !userfirstname.equals(that.userfirstname) : that.userfirstname != null) return false;
    return userlastname != null ? userlastname.equals(that.userlastname) : that.userlastname == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (userfirstname != null ? userfirstname.hashCode() : 0);
    result = 31 * result + (userlastname != null ? userlastname.hashCode() : 0);
    return result;
  }

  //public ContactData setId(int id) {this.id=id;return this;}


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withUserfirstname(String userfirstname) {
    this.userfirstname = userfirstname;
    return this;
  }

  public ContactData withUsermiddlename(String usermiddlename) {
    this.usermiddlename = usermiddlename;
    return this;
  }

  public ContactData withUserlastname(String userlastname) {
    this.userlastname = userlastname;
    return this;
  }

  public ContactData withUsernickname(String usernickname) {
    this.usernickname = usernickname;
    return this;
  }

  public ContactData withtUsercompany(String usercompany) {
    this.usercompany = usercompany;
    return this;
  }

  public ContactData withUseraddress(String useraddress) {
    this.useraddress = useraddress;
    return this;
  }

  public ContactData withUserhomephone(String userhomephone) {
    this.userhomephone = userhomephone;
    return this;
  }

  public ContactData withUsermobilephone(String usermobilephone) {
    this.usermobilephone = usermobilephone;
    return this;
  }

  public ContactData withUserworkphone(String userworkphone) {
    this.userworkphone = userworkphone;
    return this;
  }


  public ContactData withUseremail(String useremail) {
    this.useremail = useremail;
    return this;
  }

  public ContactData withUseremail2(String useremail2) {
    this.useremail2 = useremail2;
    return this;
  }

  public ContactData withUseremail3(String useremail3) {
    this.useremail3 = useremail3;
    return this;
  }

  public ContactData withUserhomepage(String userhomepage) {
    this.userhomepage = userhomepage;
    return this;
  }

  public ContactData withUseraddress2(String useraddress2) {
    this.useraddress2 = useraddress2;
    return this;
  }


  public ContactData withUsernotes(String usernotes) {
    this.usernotes = usernotes;
    return this;
  }

}

