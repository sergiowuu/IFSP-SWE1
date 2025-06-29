package br.edu.ifsp.cubatao.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.cubatao.model.Order;
import br.edu.ifsp.cubatao.util.ConnectionFactory;

public class OrderDAO {
	
    public void save(Order order) {
        String sql = "INSERT INTO orders(ORD_NO, PURCH_AMT, ORD_DATE, CUSTOMER_ID, SALESMAN_ID) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, order.getOrdNo());
            pstm.setDouble(2, order.getPurchAmt());
            pstm.setDate(3, Date.valueOf(order.getOrdDate())); 
            pstm.setInt(4, order.getCustomerId());
            pstm.setInt(5, order.getSalesmanId());

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

    public List<Order> findAll() {
        String sql = "SELECT * FROM orders";
        List<Order> orders = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Order order = new Order();
                order.setOrdNo(rset.getInt("ORD_NO"));
                order.setPurchAmt(rset.getDouble("PURCH_AMT"));
                order.setOrdDate(rset.getDate("ORD_DATE").toLocalDate());
                order.setCustomerId(rset.getInt("CUSTOMER_ID"));
                order.setSalesmanId(rset.getInt("SALESMAN_ID"));
                orders.add(order);
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
        return orders;
    }
}