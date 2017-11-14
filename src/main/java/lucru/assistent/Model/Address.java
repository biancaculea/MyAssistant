package lucru.assistent.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Address implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // vezi si application.properties
    private int id;
    private String email;
    private String street;
    private String number;
    private String building;
    private String sc;
    private String ap;
    private int postalCod;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String city;
    private String country;

    public Address() {
    }

    public Address(int id, String email, String street, String number, String building, String sc, String ap, int postalCod) {
        this.id= id;
        this.email = email;
        this.street = street;
        this.number = number;
        this.building = building;
        this.sc = sc;
        this.ap = ap;
        this.postalCod = postalCod;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public Address(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getSc() {
        return sc;
    }

    public void setSc(String sc) {
        this.sc = sc;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public int getPostalCod() {
        return postalCod;
    }

    public void setPostalCod(int postalCod) {
        this.postalCod = postalCod;
    }


    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", building='" + building + '\'' +
                ", sc='" + sc + '\'' +
                ", ap='" + ap + '\'' +
                ", postalCod=" + postalCod +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (getId() != address.getId()) return false;
        if (getPostalCod() != address.getPostalCod()) return false;
        if (getEmail() != null ? !getEmail().equals(address.getEmail()) : address.getEmail() != null) return false;
        if (getStreet() != null ? !getStreet().equals(address.getStreet()) : address.getStreet() != null) return false;
        if (getNumber() != null ? !getNumber().equals(address.getNumber()) : address.getNumber() != null) return false;
        if (getBuilding() != null ? !getBuilding().equals(address.getBuilding()) : address.getBuilding() != null)
            return false;
        if (getSc() != null ? !getSc().equals(address.getSc()) : address.getSc() != null) return false;
        if (getAp() != null ? !getAp().equals(address.getAp()) : address.getAp() != null) return false;
        if (getCity() != null ? !getCity().equals(address.getCity()) : address.getCity() != null) return false;
        return country != null ? country.equals(address.country) : address.country == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
        result = 31 * result + (getNumber() != null ? getNumber().hashCode() : 0);
        result = 31 * result + (getBuilding() != null ? getBuilding().hashCode() : 0);
        result = 31 * result + (getSc() != null ? getSc().hashCode() : 0);
        result = 31 * result + (getAp() != null ? getAp().hashCode() : 0);
        result = 31 * result + getPostalCod();
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
