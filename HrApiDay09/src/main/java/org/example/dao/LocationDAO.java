package org.example.dao;


import org.example.dto.DepartmentFilterDto;
import org.example.models.Department;
import org.example.models.Location;

import java.sql.*;
import java.util.ArrayList;

public class LocationDAO {

    private static final String URL = "jdbc:sqlite:D:\\Private\\SDAIA\\SDAIA Java Course\\JavaBasics\\src\\main\\java\\day4\\hr.db";
    private static final String SELECT_ALL_LOCS = "select * from locations";
    private static final String SELECT_ONE_LOC = "select * from locations where location_id = ?";
    private static final String SELECT_LOC_WITH_LOC = "select * from locations where location_id = ?";
    private static final String SELECT_LOC_WITH_LOC_PAGINATION = "select * from locations where location_id = ? order by location_id limit ? offset ?";
    private static final String SELECT_LOC_WITH_PAGINATION = "select * from locations order by location_id limit ? offset ?";
    private static final String INSERT_LOC = "insert into locations values (?, ?, ?)";
    private static final String UPDATE_LOC = "update locations set location_name = ?, location_id = ? where location_id = ?";
    private static final String DELETE_LOC = "delete from locations where location_id = ?";

//    public void insertLoc(Location l) throws SQLException, ClassNotFoundException {
//        Class.forName("org.sqlite.JDBC");
//        Connection conn = DriverManager.getConnection(URL);
//        PreparedStatement st = conn.prepareStatement(INSERT_LOC);
//        st.setInt(1, d.getDepartmentId());
//        st.setString(2, d.getDepartmentName());
//        st.setInt(3, d.getLocationId());
//        st.executeUpdate();
//    }
//
//    public void updateLoc(Location l) throws SQLException, ClassNotFoundException {
//        Class.forName("org.sqlite.JDBC");
//        Connection conn = DriverManager.getConnection(URL);
//        PreparedStatement st = conn.prepareStatement(UPDATE_LOC);
//        st.setInt(3, d.getDepartmentId());
//        st.setString(1, d.getDepartmentName());
//        st.setInt(2, d.getLocationId());
//        st.executeUpdate();
//    }
//
//    public void deleteLoc(int deptId) throws SQLException, ClassNotFoundException {
//        Class.forName("org.sqlite.JDBC");
//        Connection conn = DriverManager.getConnection(URL);
//        PreparedStatement st = conn.prepareStatement(DELETE_LOC);
//        st.setInt(1, deptId);
//        st.executeUpdate();
//    }

    public Location selectLoc(int locId) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st = conn.prepareStatement(SELECT_ONE_LOC);
        st.setInt(1, locId);
        ResultSet rs = st.executeQuery();
        if(rs.next()) {
            return new Location(rs);
        }
        else {
            return null;
        }
    }

    public ArrayList<Location> selectAllLocs(Integer locId, Integer limit, int offset) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if(locId != null && limit != null) {
            st = conn.prepareStatement(SELECT_LOC_WITH_LOC_PAGINATION);
            st.setInt(1, locId);
            st.setInt(2, limit);
            st.setInt(3, offset);
        }
        else if(locId != null) {
            st = conn.prepareStatement(SELECT_LOC_WITH_LOC);
            st.setInt(1, locId);
        }
        else if(limit != null) {
            st = conn.prepareStatement(SELECT_LOC_WITH_PAGINATION);
            st.setInt(1, limit);
            st.setInt(2, offset);
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_LOCS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<Location> locs = new ArrayList<>();
        while (rs.next()) {
            locs.add(new Location(rs));
        }

        return locs;
    }

    public ArrayList<Department> selectAllLocs(DepartmentFilterDto filter) throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection(URL);
        PreparedStatement st;
        if(filter.getLocId() != null && filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_LOC_WITH_LOC_PAGINATION);
            st.setInt(1, filter.getLocId());
            st.setInt(2, filter.getLimit());
            st.setInt(3, filter.getOffset());
        }
        else if(filter.getLocId() != null) {
            st = conn.prepareStatement(SELECT_LOC_WITH_LOC);
            st.setInt(1, filter.getLocId());
        }
        else if(filter.getLimit() != null) {
            st = conn.prepareStatement(SELECT_LOC_WITH_PAGINATION);
            st.setInt(1, filter.getLimit());
            st.setInt(2, filter.getOffset());
        }
        else {
            st = conn.prepareStatement(SELECT_ALL_LOCS);
        }
        ResultSet rs = st.executeQuery();
        ArrayList<Department> depts = new ArrayList<>();
        while (rs.next()) {
            depts.add(new Department(rs));
        }

        return depts;
    }
}
