package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Employee;
import org.example.Entities.Jobs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JobsModel extends DBEntity {
    private ArrayList<Jobs> jobsModel;

    public JobsModel() {
    }

    public void mapping(ResultSet res) throws SQLException {
        jobsModel=new ArrayList<>();

        while (res.next()){
            Jobs jobs=new Jobs();
            jobs.jobId= Integer.parseInt(res.getString("job_id"));
            jobs.jobDesc=res.getString("job_desc");
            jobs.minLvl= Integer.parseInt(res.getString("min_lvl"));
            jobs.maxLvl= Integer.parseInt(res.getString("max_lvl"));
            jobsModel.add(jobs);

        }
    }

    public ArrayList<Jobs> get(String shc) {
        String sql = "SELECT * FROM jobs WHERE ";
        sql += "concat(job_id, job_desc) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return jobsModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean put(Jobs odata, String campo, String valor) {
        String sql = "UPDATE jobs set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "job_id='" + odata.jobId + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(Jobs jobs) {
        String sql = "INSERT INTO jobs(job_id, job_desc, min_lvl, max_lvl) " +
                "\n" + "VALUES ('" + jobs.jobId + "'" + "," + "'" + jobs.jobDesc + "'" + "," + "'" + jobs.minLvl + "'" + "," + "'" + jobs.maxLvl + "'" +")";
        return execSQL(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM jobs WHERE job_id = ?";

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
