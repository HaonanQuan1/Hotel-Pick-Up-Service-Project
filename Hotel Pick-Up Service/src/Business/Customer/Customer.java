/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

/**
 *
 * @author quanhaonan
 */
public class Customer {
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
    private String gender;
    private String name;
    private int id;
    private static int count = 0;

    public Customer(String firstname,String lastname, String phonenumber, String email, String gender) {
        id = count;
        count++;
        this.firstname=firstname;
        this.lastname=lastname;
        this.name=firstname+" "+lastname;
        this.phonenumber=phonenumber;
        this.email=email;
        this.gender=gender;
        
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setName(String firstname, String lastname) {
        //this.name = name;
        this.name=firstname+lastname;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
