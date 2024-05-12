package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Autor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutorModel extends DBEntity {
    private ArrayList<Autor> aumodel;

    public AutorModel() {
    }

    private void mapping(ResultSet res) throws SQLException {
        aumodel = new ArrayList<>();
        while (res.next()) {
            Autor autor = new Autor();
            autor.auId = res.getString("au_id");
            autor.auLname = res.getString("au_lname");
            autor.auFname = res.getString("au_fname");
            autor.phone = res.getString("phone");
            autor.address = res.getString("address");
            aumodel.add(autor);

        }
    }

    public ArrayList<Autor> get(String shc) {
        String sql = "SELECT * FROM authors WHERE ";
        sql += "concat(au_lname, ' ', au_fname, ' ', au_id) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return aumodel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean put(Autor odata, String campo, String valor) {
        String sql = "UPDATE authors set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "au_id='" + odata.auId + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(Autor autor) {
        String sql = "INSERT INTO authors(au_id, au_lname, au_fname, phone, address, city, state, zip, contract) \n" +
                "VALUES ('" + autor.auId + "', '" + autor.auLname + "', '" + autor.auFname + "', '" +
                autor.phone + "', '" + autor.address + "', '" + autor.city + "', '" + autor.state + "', '" +
                autor.zip + "', " + autor.contract  + ")";
        return execSQL(sql);
    }

    public boolean delete(String auId) {
        String sql = "DELETE FROM authors WHERE au_id = ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, auId);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
