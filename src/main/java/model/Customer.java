package model;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;
import javax.naming.StringRefAddr;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Referenceable {

    @Id
    private int Id;
    private String Name;
    private String Surname;

    public Customer(int id, String name, String surname) {
        this.Id = id;
        this.Name = name;
        this.Surname = surname;
    }

    public Customer() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                '}';
    }

    @Override
    public Reference getReference() throws NamingException {
        Reference reference= new Reference(Customer.class.getName());
        reference.add(new StringRefAddr("id",String.valueOf(this.Id)));
        reference.add(new StringRefAddr("name",this.Name));
        reference.add(new StringRefAddr("surname",this.Surname));
        return reference;
    }
}
