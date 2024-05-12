package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Employee;
import org.example.Entities.Sales;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SalesModel extends DBEntity {
    private ArrayList<Sales> salesModel;

    public SalesModel() {
    }

    public void mapping(ResultSet res) throws SQLException {
        salesModel=new ArrayList<>();

        while (res.next()){
            Sales sales=new Sales();
            sales.storeId=res.getString("stor_id");
            sales.ordNum=res.getString("ord_num");
            sales.orderDate= LocalDate.parse(res.getString("order_date"));
            sales.qty= Integer.parseInt(res.getString("qty"));
            sales.payterms=res.getString("payterms");
            sales.titleId=res.getString("title_id");
            salesModel.add(sales);
        }
    }

    public ArrayList<Sales> get(String shc) {
        String sql = "SELECT * FROM sales WHERE ";
        sql += "concat(stor_id, title_id) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return salesModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean put(Sales odata, String campo, String valor) {
        String sql = "UPDATE sales set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "title_id='" + odata.titleId + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(Sales sales) {
        String sql = "INSERT INTO sales(stor_id, ord_num, ord_date, qty, payterms, title_id) " +
                "\n" + "VALUES ('" + sales.storeId + "'" + "," + "'" + sales.ordNum + "'" + "," + "'" + sales.orderDate + "'" + "," + "'" + sales.qty + "'" + "," + "'" + sales.payterms + "'"+","+ "'" + sales.titleId+"'"+")";
        return execSQL(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM sales WHERE title_id = ?";

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, id);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

