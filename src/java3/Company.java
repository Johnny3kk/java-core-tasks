package java3;

import java.io.Serializable;
import java.util.List;

public class Company {

    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String inn;
    private String founded;
    private List<Securities> securities;

    public Company() {
    }

    public Company(long id, String name, String address, String phoneNumber, String inn, String founded, List<Securities> securities) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inn = inn;
        this.founded = founded;
        this.securities = securities;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public List<Securities> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Securities> securities) {
        this.securities = securities;
    }

    @Override
    public String toString() {
        return "Companies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", inn='" + inn + '\'' +
                ", founded='" + founded + '\'' +
                '}';
    }

}
