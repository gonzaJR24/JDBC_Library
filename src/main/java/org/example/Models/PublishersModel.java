package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Employee;
import org.example.Entities.Publishers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PublishersModel extends DBEntity {
    private ArrayList<Publishers>publishersModel;

    public PublishersModel() {
    }

    public void mapping(ResultSet res) throws SQLException {
        publishersModel=new ArrayList<>();
        while (res.next()){
            Publishers publishers=new Publishers();
            publishers.pubId=res.getString("pub_id");
            publishers.pubName=res.getString("pub_name");
            publishers.city=res.getString("city");
            publishers.state=res.getString("state");
            publishers.country=res.getString("country");

            publishersModel.add(publishers);

        }
    }

    public ArrayList<Publishers> get(String shc) {
        String sql = "SELECT * FROM publishers WHERE ";
        sql += "concat(pub_id, pub_name) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return publishersModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean put(Publishers odata, String campo, String valor) {
        String sql = "UPDATE publishers set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "pub_id='" + odata.pubId + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(Publishers publishers) {
        String sql = "INSERT INTO publishers(pub_id, pub_name, city, state, country) " +
                "\n" + "VALUES ('" + publishers.pubId + "'" + "," + "'" + publishers.pubName+ "'" + "," + "'" + publishers.state + "'" + "," + "'" + publishers.city + "'" + "," + "'" + publishers.country +"'"+ ")";
        return execSQL(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM publishers WHERE emp_id = ?";

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
