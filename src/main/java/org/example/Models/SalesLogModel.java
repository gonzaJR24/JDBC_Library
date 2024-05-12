package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Employee;
import org.example.Entities.SalesLog;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class SalesLogModel extends DBEntity {

    private ArrayList<SalesLog>salesLogsModel;

    public SalesLogModel() {
    }

    public void mapping(ResultSet res) throws SQLException {
        salesLogsModel=new ArrayList<>();

        while (res.next()){
            SalesLog salesLog=new SalesLog();
            salesLog.storeId=res.getString("stor_id");
            salesLog.ordNum=res.getString("ord_num");
            salesLog.titleId= res.getString("title_id");
            salesLog.auId= res.getString("au_id");
            salesLog.logFecha= LocalDate.parse(res.getString("log_fecha"));
            salesLog.salesLogId= Integer.parseInt(res.getString("sales_log_id"));
            salesLog.price= Double.parseDouble(res.getString("price"));
            salesLogsModel.add(salesLog);
        }
    }

    public ArrayList<SalesLog> get(String shc) {
        String sql = "SELECT * FROM sales_log WHERE ";
        sql += "concat(sales_log_id, stor_id) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return salesLogsModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean put(SalesLog odata, String campo, String valor) {
        String sql = "UPDATE sales_log set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "sales_log_id='" + odata.salesLogId + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(SalesLog salesLog) {
        String sql = "INSERT INTO sales_log(sales_log_id, stor_id, ord_num, title_id, au_id, log_fecha, price, quantity) " +
                "\n" + "VALUES ('" + salesLog.salesLogId + "'" + "," + "'" + salesLog.storeId + "'" + "," + "'" + salesLog.ordNum + "'" + "," + "'" + salesLog.titleId + "'" + "," + "'" + salesLog.auId + "'"+","+ "'" + salesLog.logFecha + "'"
                +"'"+ salesLog.price+"'"+"," +"'"+salesLog.quantity+"'"+")";
        return execSQL(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM sales_log WHERE sales_log_id = ?";

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
