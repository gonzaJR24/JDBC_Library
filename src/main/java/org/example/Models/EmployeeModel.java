package org.example.Models;

import org.example.DBEntity.DBEntity;
import org.example.Entities.Discounts;
import org.example.Entities.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeModel extends DBEntity {

    ArrayList<Employee> employeeModel;

    public EmployeeModel() {
    }

    public void mapping(ResultSet res) throws SQLException {
        employeeModel=new ArrayList<>();
        while (res.next()){
            Employee employee=new Employee();
            employee.empId=res.getString("emp_id");
            employee.fName=res.getString("fname");
            employee.minIt=res.getString("minit");
            employee.jobId= Integer.parseInt(res.getString("job_id"));
            employee.jobLvl= Integer.parseInt(res.getString("job_lvl"));
            employee.pubId= res.getString("pub_id");
            employee.hireDate= LocalDate.parse(res.getString("hire_date"));
        }
    }

    public ArrayList<Employee> get(String shc) {
        String sql = "SELECT * FROM employee WHERE ";
        sql += "concat(emp_id, job_id) LIKE '%" + shc + "%'";
        try {
            mapping(getData(sql));
            return employeeModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean put(Employee odata, String campo, String valor) {
        String sql = "UPDATE employee set " + campo + "=" + "'" + valor + "'" + " WHERE ";
        sql += "emp_id='" + odata.empId + "'";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean post(Employee employee) {
        String sql = "INSERT INTO employee(emp_id, fname, minit, lname, job_id, job_lvl, pub_id, hire_date) " +
                "\n" + "VALUES ('" + employee.empId + "'" + "," + "'" + employee.fName + "'" + "," + "'" + employee.minIt + "'" + "," + "'" + employee.lName + "'" + "," + "'" + employee.jobId + "'"+","+ "'" + employee.jobLvl + "'"
        +"'"+ employee.pubId+"'"+"," +"'"+employee.hireDate+"'"+")";
        return execSQL(sql);
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM employee WHERE emp_id = ?";

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