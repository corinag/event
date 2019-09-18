package org.restlet.contacto.webapi.common;

//import org.restlet.contacto.webapi.common.Address;
import java.io.Serializable;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Event implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    private String name;

    private String title;

    private String lastName;

    private String line1;

    private String line2;

    private String zipCode;

    private String city;

    private String country;

    private int age;

    public Event() {
    }

    public Event(String name, String title, String lastName, String line1, String line2, String zipCode, String city, String country, int age) {
        super();
        this.name = name;
        this.title = title;
        this.lastName = lastName;
        this.line1 = line1;
        this.line2 = line2; 
        this.zipCode = zipCode; 
        this.city = city; 
        this.country = country;
        this.age = age;
    }

  
   

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getLine1() {
        return line1;
    }

    public String getLine2() {
        return line2;
    }

    public String getZipcode() {
        return zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public void setZipcode(String zipCode) {
        this.zipCode = zipCode;
    }


    

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTitle() {
        return title;
    }

  

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

  

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
