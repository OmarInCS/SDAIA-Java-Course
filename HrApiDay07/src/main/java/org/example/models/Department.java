package org.example.models;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.ResultSet;
import java.sql.SQLException;

@XmlRootElement
public class Department {

    private int departmentId;
    private String departmentName;
    private int locationId;

    public Department() {
    }

    public Department(int departmentId, String departmentName, int locationId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.locationId = locationId;
    }

    public Department(ResultSet rs) throws SQLException {
        departmentId = rs.getInt("department_id");
        departmentName = rs.getString("department_name");
        locationId = rs.getInt("location_id");
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", locationId=" + locationId +
                '}';
    }
}
