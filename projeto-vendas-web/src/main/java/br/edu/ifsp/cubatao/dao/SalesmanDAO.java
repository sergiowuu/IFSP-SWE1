package br.edu.ifsp.cubatao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.cubatao.model.Salesman;
import br.edu.ifsp.cubatao.util.ConnectionFactory;

public class SalesmanDAO {

    public void save(Salesman salesman) {
        String sql = "INSERT INTO salesman (SALESMAN_ID, NAME, CITY, COMMISSION) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, salesman.getSalesmanId());
            pstm.setString(2, salesman.getName());
            pstm.setString(3, salesman.getCity());
            pstm.setDouble(4, salesman.getCommission());

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

    public List<Salesman> findAll() {
        String sql = "SELECT * FROM salesman";
        List<Salesman> salesmen = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Salesman salesman = new Salesman();
                salesman.setSalesmanId(rset.getInt("SALESMAN_ID"));
                salesman.setName(rset.getString("NAME"));
                salesman.setCity(rset.getString("CITY"));
                salesman.setCommission(rset.getDouble("COMMISSION"));
                salesmen.add(salesman);
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
        return salesmen;
    }
}