package org.example.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDto {

    private int locationId;

    private String city;

    private String streetAddress;

    public LocationDto() {
    }

    public LocationDto(ResultSet rs) throws SQLException {
        locationId = rs.getInt("location_id");
        city = rs.getString("city");
        streetAddress = rs.getString("street_address");
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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
}
