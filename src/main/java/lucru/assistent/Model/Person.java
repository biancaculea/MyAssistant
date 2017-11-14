package lucru.assistent.Model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;


@Entity
@Table(name="person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO) // vezi si application.properties
    private int id;

    private String firstname;
    private String lastname;

    //@NaturalId
    private String email;
    private String phone;


    @OneToMany( mappedBy ="person", cascade = CascadeType.ALL, orphanRemoval = true)
    // How to solve circular reference in json serializer caused by Many TO Many hibernate bidirectional mapping:

    //@Cascade({CascadeType.SAVE_UPDATE}) // org.hibernate.annotations.Cascade
    // https://www.mkyong.com/hibernate/cascade-jpa-hibernate-annotation-common-mistake/


    @JsonIgnoreProperties(value="person")
    private List<Tichet> tichets =new ArrayList<>();


    public List<Tichet> getTichets() {
        return tichets;
    }

     public void setTichets(List<Tichet> tichets) {
        this.tichets = tichets;
    }


    // https://vladmihalcea.com/2017/03/29/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/
    // You should always provide these methods whenever you are working with a bidirectional association as,
    // otherwise, you risk very subtle state propagation issues:

    public void addTichets(Tichet tichet) {
        tichets.add(tichet);
         tichet.setPerson(this);
    }

    public void removeTichets(Tichet tichet) {
        tichets.remove(tichet);
        tichet.setPerson(null);
    }


    public Person(){}

    public Person(String firstname, String lastname, String email, String phone, List<Tichet> tichets) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.tichets = tichets;
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id;
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public String getFirstname(){
        return this.firstname;
    }

    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    public String getLastname(){
        return this.lastname;
    }

    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setPhone(String phone){
        this.phone=phone;
    }
    public String getPhone(){
        return this.phone;
    }




    @Override
    public String toString(){
        JSONObject JsonInfo = new JSONObject();

        JsonInfo.put("FirstName",this.firstname);
        JsonInfo.put("LastName ",this.lastname);

        JSONArray  JsonArray = new JSONArray();
        JSONObject subJson = new JSONObject();
        subJson.put("Email ",this.email);
        JsonArray.put(subJson);
        subJson.put("Phone ",this.phone);
        JsonArray.put(subJson);
        JsonInfo.put("Detalii: ", JsonArray);

        return JsonInfo.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!getFirstname().equals(person.getFirstname())) return false;
        if (!getLastname().equals(person.getLastname())) return false;
        return getEmail().equals(person.getEmail());
    }

    @Override
    public int hashCode() {
        int result = getFirstname().hashCode();
        result = 31 * result + getLastname().hashCode();
        result = 31 * result + getEmail().hashCode();
        return result;
    }
}

