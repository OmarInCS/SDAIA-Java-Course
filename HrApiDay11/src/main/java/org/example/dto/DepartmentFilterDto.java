package org.example.dto;

import jakarta.ws.rs.QueryParam;

public class DepartmentFilterDto {
    private @QueryParam("locId") Integer locId;
    private @QueryParam("limit") Integer limit;
    private @QueryParam("offset") int offset;

    public Integer getLocId() {
        System.out.println("I'm in getLocId");
        return locId;
    }

    public void setLocId(Integer locId) {
        this.locId = locId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
