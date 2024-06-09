package org.example.dto;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@XmlRootElement
public class DepartmentDto {

    private int deptId;
    private String deptName;
    private int locId;

    private String city;

    private String streetAddress;

    private ArrayList<LinkDto> links = new ArrayList<>();

    public DepartmentDto() {
    }

    public DepartmentDto(int deptId, String deptName, int locId) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.locId = locId;
    }

    public DepartmentDto(ResultSet rs) throws SQLException {
        deptId = rs.getInt("department_id");
        deptName = rs.getString("department_name");
        locId = rs.getInt("location_id");
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @XmlElementWrapper
    @XmlElement(name = "link")
    public ArrayList<LinkDto> getLinks() {
        return links;
    }

    public void addLink(String url, String rel) {
        LinkDto link = new LinkDto();
        link.setLink(url);
        link.setRel(rel);
        links.add(link);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + deptId +
                ", departmentName='" + deptName + '\'' +
                ", locationId=" + locId +
                '}';
    }
}
