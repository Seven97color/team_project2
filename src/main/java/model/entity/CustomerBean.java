package model.entity;

import java.io.Serializable;

public class CustomerBean implements Serializable {
    private String name;
    private String kana;
    private String zipcode;
    private String area;
    private String gender;
    private String birthday;
    private String phoneNumber;

    public CustomerBean() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getKana() { return kana; }
    public void setKana(String kana) { this.kana = kana; }

    public String getZipcode() { return zipcode; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBirthday() { return birthday; }
    public void setBirthday(String birthday) { this.birthday = birthday; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
