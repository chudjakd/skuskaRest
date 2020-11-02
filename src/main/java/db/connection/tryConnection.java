package db.connection;

import db.repository.CustomerRepository;
import db.repository.GoodThingRepository;
import db.service.implementation.GoodThingImplementation;
import model.Customer;
import model.goodThingProject.GoodThing;

import java.sql.*;

public class tryConnection {

    public boolean connectToOracleDB(){
        String urlDatabase="jdbc:oracle:thin@localhost:1521:orcl";
        String username="SYS";
        String pass="Ceasdaa1";
        try {
            Connection connection= DriverManager.getConnection(urlDatabase,username,pass);
            return true;
        } catch (SQLException throwables) {
            return false;
        }

    }

    public static void main(String[] args) {

        CustomerRepository customerRepository= new CustomerRepository();
        Customer customer= new Customer(5,"Borka","Fajna");
//        if(customerRepository.insertCustomer(customer)==null){
//            System.out.println("Jeblo to");
//
//        }else{
//            System.out.println("insert bol uspesny");
//        }
//        System.out.println(customerRepository.getCustomersByName("Jozo"));
//        System.out.println(customerRepository.getAllCustomer());
//        System.out.println(customerRepository.deleteCustomerById(1));
//        System.out.println(customerRepository.getAllCustomer());
//        customerRepository.updateCustomer(customer);
//        System.out.println(customerRepository.getAllCustomer());
        //GoodThing goodThing= new GoodThing(1,"Alojzko","Alojzko hlina co vam poviem",1);
        //GoodThingRepository goodThingRepository= new GoodThingRepository();
//        System.out.println("All good things before insert: "+goodThingRepository.getAllGoodThings());
//        System.out.println("Inserted good thing id: "+goodThingRepository.createNewGoodThings(goodThing));
//        System.out.println("ALl good things after insert: "+goodThingRepository.getAllGoodThings());
//        System.out.println("All good things before update: "+goodThingRepository.getAllGoodThings());
//        System.out.println(goodThingRepository.updateGoodThing(3,goodThing));
//        System.out.println("ALl good things after update: "+goodThingRepository.getAllGoodThings());
        //goodThingRepository.getAllGoodThings();
        //System.out.println("All good things before delete: "+goodThingRepository.getAllGoodThings());
//        System.out.println(goodThingRepository.deleteGoodThingById(3));
//        System.out.println("All good things after delete: "+goodThingRepository.getAllGoodThings());
        GoodThingImplementation goodThingImplementation= new GoodThingImplementation();
        //GoodThingRepository goodThingRepository= new GoodThingRepository();
        System.out.println(goodThingImplementation.getAllGoodThings());
    }
}
