package org.example.mappers;

import org.example.dto.DepartmentDto;
import org.example.models.Department;
import org.example.models.Location;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;


@Mapper(uses = {LocationMapper.class}, imports = {java.util.UUID.class}, componentModel = "cdi")
public interface DepartmentMapper {
//    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class);

    @BeforeMapping
    static void validate(Department d) {
        System.out.println("VALIDATE");
        if (d.getDepartmentName() != null) {
            d.setDepartmentName(d.getDepartmentName().toUpperCase());
        }
    }

    @AfterMapping
    static void doAfter(@MappingTarget DepartmentDto dto) {
        System.out.println("Do Something After");

    }


    @Mapping(source = "departmentId", target = "deptId")
    @Mapping(source = "departmentName", target = "deptName", defaultValue = "No Department")
//    @Mapping(constant = "Data Hidden", target = "deptName")
    @Mapping(source = "locationId", target = "locId", defaultExpression = "java((int)(Math.random() * 4))")
//    @Mapping(expression = "java((int)(Math.random() * 4))", target = "locId")
    @Mapping(source = "location", target = "loc")
//    @Mapping(source = "location.locationId", target = "loc.locationId")
//    @Mapping(source = "location.city", target = "loc.city")
    DepartmentDto toDeptDto(Department d);

    @Mapping(source = "d.departmentId", target = "deptId")
    @Mapping(source = "d.departmentName", target = "deptName")
    @Mapping(source = "d.locationId", target = "locId")
//    @InheritConfiguration
    DepartmentDto toDeptDto(Department d, Location l);

    @Mapping(target = "departmentId", source = "deptId")
    @Mapping(target = "departmentName", source = "deptName")
    @Mapping(target = "locationId", source = "locId")
//    @InheritInverseConfiguration
    Department toModel(DepartmentDto dto);

}
