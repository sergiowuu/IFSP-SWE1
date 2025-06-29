package br.edu.ifsp.cubatao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.cubatao.model.Customer;
import br.edu.ifsp.cubatao.util.ConnectionFactory;

public class CustomerDAO {

    public void save(Customer customer) {
        String sql = "INSERT INTO customer(CUSTOMER_ID, CUST_NAME, CITY, GRADE, SALESMAN_ID) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, customer.getCustomerId());
            pstm.setString(2, customer.getCustName());
            pstm.setString(3, customer.getCity());
            pstm.setInt(4, customer.getGrade());
            pstm.setInt(5, customer.getSalesmanId());

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer";
        List<Customer> customers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(rset.getInt("CUSTOMER_ID"));
                customer.setCustName(rset.getString("CUST_NAME"));
                customer.setCity(rset.getString("CITY"));
                customer.setGrade(rset.getInt("GRADE"));
                customer.setSalesmanId(rset.getInt("SALESMAN_ID"));
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) rset.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return customers;
    }
}