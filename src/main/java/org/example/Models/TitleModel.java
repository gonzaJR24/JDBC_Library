package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Employee;
import org.example.Entities.Title;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TitleModel extends DBEntity {
    private ArrayList<Title> titleModel;

    public TitleModel() {
    }

//    this.titleId = "";
//        this.title = "";
//        this.type = "";
//        this.pubId = "";
//        this.notes = "";
//        this.price = 0;
//        this.advance = 0;
//        this.royalty = 0;
//        this.ytdSales = 0;
//        this.pubDate = null;

    private void mapping(ResultSet res) throws SQLException {
        titleModel =new ArrayList<>();
        while (res.next()){
            Title title=new Title();
            title.titleId= res.getString("title_id");
            title.title= res.getString("title");
            title.type= res.getString("type");
            title.pubId= res.getString("pub_id");
            title.notes=res.getString("notes");
            title.price= Double.parseDouble(res.getString("price"));
            title.advance= Double.parseDouble(res.getString("advance"));
            title.royalty= Integer.parseInt(res.getString("royalty"));
            title.ytdSales= Integer.parseInt(res.getString("ytd_sales"));
            title.pubDate= LocalDate.parse(res.getString("pubdate"));
            titleModel.add(title);

        }
    }

    public ArrayList<Title> get(String shc) {
        String sql = "SELECT * FROM titles WHERE ";
        sql += "concat(title_id, title) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return titleModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean put(Title odata, String campo, String valor) {
        String sql = "UPDATE titles set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "title_id='" + odata.titleId + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(Title title) {
        String sql = "INSERT INTO titles(title_id, title, type, pub_id, price, advance, royalty, ytd_sales, notes, pubdate) " +
                "\n" + "VALUES ('" + title.titleId + "'" + "," + "'" + title.title + "'" + "," + "'" + title.type + "'" + "," + "'" + title.pubId + "'" + "," + "'" + title.price + "'"+","+ "'" + title.advance + "'"
                +"'"+ title.royalty+"'"+"," +"'"+title.ytdSales+"'"+"," +"'"+title.notes+"'"+"," +"'"+title.pubDate+"'"+")";
        return execSQL(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM titles WHERE title_id = ?";

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
