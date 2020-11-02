package model;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class Boss implements Serializable {
    private String name;
    private String surname;
    private List<Customer> allCustomers;

    public Boss() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boss(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public List<Customer> getAllCustomers() {
        return allCustomers;
    }

    public void setAllCustomers(List<Customer> allCustomers) {
        this.allCustomers = allCustomers;
    }



    @Override
    public String toString() {
        return "Boss{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}

