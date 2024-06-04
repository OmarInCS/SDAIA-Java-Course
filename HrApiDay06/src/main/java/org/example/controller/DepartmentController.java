package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.dao.DepartmentDAO;
import org.example.dto.DepartmentFilterDto;
import org.example.models.Department;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/departments")
public class DepartmentController {

    DepartmentDAO dao = new DepartmentDAO();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public ArrayList<Department> getAllDepartments(
//            @QueryParam("locId") Integer locId,
//            @QueryParam("limit") Integer limit,
//            @QueryParam("offset") int offset
            @BeanParam DepartmentFilterDto filter
    ) {
        try {
//            return dao.selectAllDepts(locId, limit, offset);
            return dao.selectAllDepts(filter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{deptId}")
    public Department getDepartment(@PathParam("deptId") int deptId) {

        try {
            return dao.selectDept(deptId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("{deptId}")
    public void deleteDepartment(@PathParam("deptId") int deptId) {

        try {
            dao.deleteDept(deptId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void insertDepartment(Department dept) {

        try {
            dao.insertDept(dept);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("{deptId}")
    public void updateDepartment(@PathParam("deptId") int deptId, Department dept) {

        try {
            dept.setDepartmentId(deptId);
            dao.updateDept(dept);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Path("{deptId}/employees")
    public EmployeeController getEmployeeController() {
        return new EmployeeController();
    }


}
