import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import org.example.controller.DepartmentController;
import org.example.dao.DepartmentDAO;
import org.example.dto.DepartmentDto;
import org.example.mappers.DepartmentMapper;
import org.example.models.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URI;
import java.sql.SQLException;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestDepartmentController {


    @InjectMocks
    DepartmentController deptCont;

    @Mock
//    @Spy
    DepartmentDAO dao;

    @Mock
    DepartmentMapper mapper;

    @Mock
    UriInfo uriInfo;


    @Test
    public void testGetDepartment() throws SQLException, ClassNotFoundException {
        Department d = new Department(1, "Test Dept", 1500);
        DepartmentDto dDto = new DepartmentDto(1, "Test Dept", 1500);
        URI uri = URI.create("http://localhost/api/department/1");

        when(dao.selectDept(1)).thenReturn(d);
        when(mapper.toDeptDto(d)).thenReturn(dDto);
        when(uriInfo.getAbsolutePath()).thenReturn(uri);
        when(uriInfo.getAbsolutePathBuilder()).thenReturn(UriBuilder.fromUri(uri));

        Assertions.assertDoesNotThrow(() -> deptCont.getDepartment(1));

        dDto.getLinks().clear();
        Response res = deptCont.getDepartment(1);

        verify(mapper, times(2)).toDeptDto(d);

        Assertions.assertEquals(200, res.getStatus());
        Assertions.assertNotNull(((DepartmentDto) res.getEntity()).getLinks());
        Assertions.assertEquals(2, ((DepartmentDto) res.getEntity()).getLinks().size());
    }

}
