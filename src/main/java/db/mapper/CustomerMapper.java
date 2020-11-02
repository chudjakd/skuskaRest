package db.mapper;

import model.Customer;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper  {

    public Customer mapRow(ResultSet rs) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("user_id"));
        customer.setName(rs.getString("name"));
        customer.setSurname(rs.getString("surname"));
        return customer;
    }
}
