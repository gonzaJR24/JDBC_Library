package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Employee;
import org.example.Entities.RoySched;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoySchedModel extends DBEntity {
    private ArrayList<RoySched>roySchedModel;

    public RoySchedModel() {
    }

    public void mapping(ResultSet res) throws SQLException {
        roySchedModel=new ArrayList<>();

        while (res.next()){
            RoySched roySched=new RoySched();
            roySched.titleId =res.getString("title_id");
            roySched.lorange= Integer.parseInt(res.getString("lorange"));
            roySched.hirange= Integer.parseInt(res.getString("hirange"));
            roySched.royalty= Integer.parseInt(res.getString("royalty"));
            roySchedModel.add(roySched);
        }
    }

    public ArrayList<RoySched> get(String shc) {
        String sql = "SELECT * FROM roysched WHERE ";
        sql += "concat(title_id, royalty) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return roySchedModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean put(RoySched odata, String campo, String valor) {
        String sql = "UPDATE roysched set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "title_id='" + odata.titleId + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(RoySched roySched) {
        String sql = "INSERT INTO roysched(title_id, lorange, hirange, royalty) " +
                "\n" + "VALUES ('" + roySched.titleId + "'" + "," + "'" + roySched.lorange + "'" + "," + "'" + roySched.hirange + "'" + "," + "'" + roySched.royalty + "'" +")";
        return execSQL(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM roysched WHERE title_id = ?";

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
