package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Discounts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DiscountsModel extends DBEntity {
    private ArrayList<Discounts> discountModel;

    public DiscountsModel(){

    }

    public void mapping(ResultSet res) throws SQLException {
        discountModel=new ArrayList<>();
        while (res.next()){
            Discounts discounts=new Discounts();
            discounts.discountType=res.getString("discounttype");
            discounts.storeId=res.getString("stor_id");
            discounts.lowQty= Integer.parseInt(res.getString("lowqty"));
            discounts.highQty= Integer.parseInt(res.getString("highqty"));
            discounts.discount= Double.parseDouble(res.getString("discount"));
            discountModel.add(discounts);
        }
    }

    public ArrayList<Discounts> get(String shc) {
        String sql = "SELECT * FROM discounts WHERE ";
        sql += "concat(discounttype,discount) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return discountModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean put(Discounts odata, String campo, String valor) {
        String sql = "UPDATE authors set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "stor_id='" + odata.storeId + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(Discounts discounts) {
        String sql = "INSERT INTO discounts(discounttype, stor_id, lowqty, highqty, discount) \n" + "VALUES ('" + discounts.discountType + "'" + "," + "'" + discounts.storeId + "'" + "," + "'" + discounts.lowQty + "'" + "," + "'" + discounts.highQty + "'" + "," + "'" + discounts.discount + "'"+")";
        return execSQL(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM discounts WHERE stor_id = ?";

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
