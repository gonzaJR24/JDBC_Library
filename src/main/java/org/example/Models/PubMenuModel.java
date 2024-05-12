package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Employee;
import org.example.Entities.PubMenu;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PubMenuModel extends DBEntity {
    private ArrayList<PubMenu>pubMenuModel;

    public PubMenuModel() {
    }

    public void mapping(ResultSet res) throws SQLException {
        pubMenuModel=new ArrayList<>();

        while (res.next()){
            PubMenu pubMenu=new PubMenu();
            pubMenu.mnuNum= Integer.parseInt(res.getString("mnu_num"));
            pubMenu.mnuMaster= Integer.parseInt(res.getString("mnu_master"));
            pubMenu.MNU_NAME=res.getString("MNU_NAME");
            pubMenuModel.add(pubMenu);
        }
    }

    public ArrayList<PubMenu> get(String shc) {
        String sql = "SELECT * FROM pub_menu WHERE ";
        sql += "concat(mnu_num, mnu_master) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return pubMenuModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean put(PubMenu odata, String campo, String valor) {
        String sql = "UPDATE pub_menu set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "mnu_num='" + odata.mnuNum + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(PubMenu pubMenu) {
        String sql = "INSERT INTO pub_menu(mnu_num, mnu_master, MNU_NAME) " +
                "\n" + "VALUES ('" + pubMenu.mnuNum + "'" + "," + "'" + pubMenu.mnuMaster + "'" + "," + "'" + pubMenu.MNU_NAME + "'" +")";
        return execSQL(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM pub_menu WHERE mnu_num = ?";

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
