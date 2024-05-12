package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Employee;
import org.example.Entities.TitleAuthor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TitleAuthorModel extends DBEntity {
    private ArrayList<TitleAuthor>titleAuthorModel;

    public TitleAuthorModel() {
    }



    public void mapping(ResultSet res) throws SQLException {
        titleAuthorModel=new ArrayList<>();

        while (res.next()){
            TitleAuthor titleAuthor=new TitleAuthor();
            titleAuthor.auId=res.getString("au_id");
            titleAuthor.titleId= res.getString("title_id");
            titleAuthor.auOrd= Integer.parseInt(res.getString("au_ord"));
            titleAuthor.royalTyper= Integer.parseInt(res.getString("royaltyper"));
            titleAuthorModel.add(titleAuthor);
        }
    }

    public ArrayList<TitleAuthor> get(String shc) {
        String sql = "SELECT * FROM titleauthor WHERE ";
        sql += "concat(au_id, title_id) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return titleAuthorModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean put(TitleAuthor odata, String campo, String valor) {
        String sql = "UPDATE  titleauthor set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "au_id='" + odata.auId + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(TitleAuthor titleAuthor) {
        String sql = "INSERT INTO titleauthor(au_id, title_id, au_ord, royaltyper) " +
                "\n" + "VALUES ('" + titleAuthor.auId + "'" + "," + "'" + titleAuthor.titleId + "'" + "," + "'" + titleAuthor.auOrd + "'" + "," + "'" + titleAuthor.royalTyper + "'" + ")";
        return execSQL(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM titleauthor WHERE au_id = ?";

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
