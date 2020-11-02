package db.repository;

import db.mapper.CustomerMapper;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    static String name = "admin";
    static String pass = "admin";
    static CustomerMapper mapper= new CustomerMapper();
    Connection conn = null;
    Statement stmt = null;
    public List<Customer> getAllCustomer() {
        try {
            String sqlCommand = "SELECT * FROM CUSTOMER";
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, name, pass);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlCommand);
            List<Customer> allCustomers= new ArrayList<>();
            while(rs.next()){
                allCustomers.add(mapper.mapRow(rs));
            }
            return allCustomers;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }

    public List<Customer> getCustomersByName(String nameOfCustomer){
        try {
            String sqlCommand="SELECT * FROM CUSTOMER WHERE NAME="+"'"+nameOfCustomer+"'";
            conn= DriverManager.getConnection(url,name,pass);
            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery(sqlCommand);
            List<Customer> allCustomerWithTheSameName= new ArrayList<>();
            while(rs.next()){
                allCustomerWithTheSameName.add(mapper.mapRow(rs));
            }
            return allCustomerWithTheSameName;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    }
    public Integer insertCustomer(Customer customer){

        try {
            String sqlCommand="INSERT INTO CUSTOMER(user_id,name,surname) VALUES(?,?,?)";
            conn= DriverManager.getConnection(url,name,pass);
            PreparedStatement ps= conn.prepareStatement(sqlCommand);
            ps.setInt(1,customer.getId());
            ps.setString(2,customer.getName());
            ps.setString(3,customer.getSurname());
            ps.execute();
            return 1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            try{
                if(stmt!=null)
                    conn.commit();
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }

    }

    public Integer deleteCustomerById(int id){

        try {
            String sqlCommand="DELETE FROM CUSTOMER WHERE USER_ID="+id;
            conn= DriverManager.getConnection(url,name,pass);
            stmt= conn.createStatement();
            System.out.println(stmt.executeUpdate(sqlCommand));
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            try{
                if(stmt!=null)
                conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }

    }

    public Integer updateCustomer(Customer customer){
        String sqlCommand="UPDATE CUSTOMER SET SURNAME=?,NAME=? WHERE USER_ID=?";
        try {
            conn= DriverManager.getConnection(url,name,pass);
            PreparedStatement ps= conn.prepareStatement(sqlCommand);
            ps.setString(1,customer.getSurname());
            ps.setString(2,customer.getName());
            ps.setInt(3,customer.getId());
            ps.execute();
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException se){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }

    }
}