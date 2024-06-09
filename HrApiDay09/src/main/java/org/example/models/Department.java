package org.example.models;

import jakarta.ws.rs.FormParam;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

@XmlRootElement
public class Department {

    @FormParam("departmentId")
    private int departmentId;
    @FormParam("departmentName")
    private String departmentName;
    @FormParam("locationId")
    private int locationId;

    private Location location;

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
        ResultSetMetaData mt = rs.getMetaData();
        if(mt.getColumnCount() > 3) {
            location = new Location(rs);
        }
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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
