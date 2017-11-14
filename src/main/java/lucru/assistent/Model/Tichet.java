package lucru.assistent.Model;

//import lucru.assistent.Actions.LocalDateTimeAttributeConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.NaturalId;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="tichets")
public class Tichet implements Serializable {
    @javax.persistence.Id
    @GeneratedValue(strategy =GenerationType.AUTO) // vezi si application.properties
    private int id;
    private String continut;
    //@Convert(converter = LocalDateTimeAttributeConverter.class)
    //@Column(name="datain")
    private LocalDateTime datain;

    //@Convert(converter = LocalDateTimeAttributeConverter.class)
    //@Column(name="dataout")
    private LocalDateTime dataout;

    //@Convert(converter = LocalDateTimeAttributeConverter.class)
    //@Column(name="datastate01")
    private LocalDateTime datastate01;

    //@Convert(converter = LocalDateTimeAttributeConverter.class)
    //@Column(name="datastate02")
    private LocalDateTime datastate02;

    //@Convert(converter = LocalDateTimeAttributeConverter.class)
    //@Column(name="datastate03")
    private LocalDateTime datastate03;

    //@Convert(converter = LocalDateTimeAttributeConverter.class)
    //@Column(name="datastate04")
    private LocalDateTime datastate04;

    private String email;
    //@Column(name="continutmax")
    private String continutmax;
   // @NaturalId
    private String name;
    private int id_person;




    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person",  insertable = false, updatable = false)
    private Person person;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person personX) {
        this.person = person;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public Tichet(){}

    public Tichet(String continut, LocalDateTime datain, LocalDateTime dataout, LocalDateTime datastate01, LocalDateTime datastate02, LocalDateTime datastate03, LocalDateTime datastate04, String email, String continutmax, String name, int id_person) {
        this.continut = continut;
        this.datain = datain;
        this.dataout = dataout;
        this.datastate01 = datastate01;
        this.datastate02 = datastate02;
        this.datastate03 = datastate03;
        this.datastate04 = datastate04;
        this.email = email;
        this.continutmax = continutmax;
        this.name = name;
        this.id_person = id_person;

    }

    public String getContinut() {
        return continut;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDatain() {
        return datain;
    }

    public void setDatain(LocalDateTime datain) {
        this.datain = datain;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDataout() {
        return dataout;
    }

    public void setDataout(LocalDateTime dataout) {
        this.dataout = dataout;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDatastate01() {
        return datastate01;
    }

    public void setDatastate01(LocalDateTime datastate01) {
        this.datastate01 = datastate01;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDatastate02() {
        return datastate02;
    }

    public void setDatastate02(LocalDateTime datastate02) {
        this.datastate02 = datastate02;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDatastate03() {
        return datastate03;
    }

    public void setDatastate03(LocalDateTime datastate03) {
        this.datastate03 = datastate03;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDatastate04() {
        return datastate04;
    }

    public void setDatastate04(LocalDateTime datastate04) {
        this.datastate04 = datastate04;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContinutmax() {
        return continutmax;
    }

    public void setContinutmax(String continutmax) {
        this.continutmax = continutmax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tichet)) return false;

        Tichet tichet = (Tichet) o;

        if (getId() != tichet.getId()) return false;
        if (getId_person() != tichet.getId_person()) return false;
        if (!getEmail().equals(tichet.getEmail())) return false;
        return getName().equals(tichet.getName());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getId_person();
        return result;
    }

    @Override
    public String toString(){
        JSONObject JsonInfo = new JSONObject();
        JsonInfo.put("Name",this.name);
        JsonInfo.put("Data IN",this.datain);
        JsonInfo.put("Data OUT",this.dataout);
        JsonInfo.put("Continut ",this.continut);
        return JsonInfo.toString();
    }
}
