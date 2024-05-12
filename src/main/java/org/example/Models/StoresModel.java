package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Employee;
import org.example.Entities.Stores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StoresModel extends DBEntity {
    private ArrayList<Stores>storesModel;

    public StoresModel() {
    }

    public void mapping(ResultSet res) throws SQLException {
        storesModel=new ArrayList<>();

        while (res.next()){
            Stores stores=new Stores();
            stores.storeId=res.getString("stor_id");
            stores.storeName=res.getString("stor_name");
            stores.storeAddress=res.getString("stor_address");
            stores.city=res.getString("city");
            stores.state=res.getString("state");
            stores.zip=res.getString("zip");
            storesModel.add(stores);
        }
    }

    public ArrayList<Stores> get(String shc) {
        String sql = "SELECT * FROM  stores WHERE ";
        sql += "concat(stor_id, stor_name) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return storesModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean put(Stores odata, String campo, String valor) {
        String sql = "UPDATE stores set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "stor_id='" + odata.storeId + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(Stores stores) {
        String sql = "INSERT INTO stores(stor_id, stor_name, stor_address, city, state, zip) " +
                "\n" + "VALUES ('" + stores.storeId + "'" + "," + "'" + stores.storeName + "'" + "," + "'" + stores.storeAddress + "'" + "," + "'" + stores.city + "'" + "," + "'" + stores.state + "'"+","+ "'" + stores.zip + "'"+")";
        return execSQL(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM stores WHERE stor_id = ?";

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
