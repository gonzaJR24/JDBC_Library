package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Employee;
import org.example.Entities.PubInfo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PubInfoModel extends DBEntity {
    private ArrayList<PubInfo> pubInfoModel;

    public PubInfoModel() {
    }

    public void mapping(ResultSet res) throws SQLException {
        pubInfoModel=new ArrayList<>();
        while (res.next()){
            PubInfo pubInfo=new PubInfo();
            pubInfo.pubId =res.getString("pub_id");
            pubInfo.lo= res.getString("lo").getBytes();
            pubInfo.prInfo=res.getString("pr_info");

        }
    }

    public ArrayList<PubInfo> get(String shc) {
        String sql = "SELECT * FROM pub_info WHERE ";
        sql += "concat(pub_id, lo, pr_info) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return pubInfoModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean put(PubInfo odata, String campo, String valor) {
        String sql = "UPDATE pub_info set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "pub_id='" + odata.pubId + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(PubInfo pubInfo) {
        String sql = "INSERT INTO pub_info(pub_id, lo, pr_info) " +
                "\n" + "VALUES ('" + pubInfo.pubId + "'" + "," + "'" + pubInfo.lo + "'" + "," + "'" + pubInfo.prInfo+ "'"+")";
        return execSQL(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM pub_info WHERE pub_id = ?";

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
