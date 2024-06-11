import org.example.dao.DepartmentDAO;
import org.example.dto.DepartmentFilterDto;
import org.example.models.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestDepartmentDao {

    @Mock
    DepartmentFilterDto filter;

    @InjectMocks
    DepartmentDAO dao;


    @Test
    public void testSelectDept() throws SQLException, ClassNotFoundException {
        DepartmentDAO dao = new DepartmentDAO();

        Assertions.assertDoesNotThrow(() -> dao.selectDept(1));

        Department d = dao.selectDept(1);

        Assertions.assertNotNull(d);
        Assertions.assertEquals(1, d.getDepartmentId());
    }

    @Test
    public void testSelectAllDepts() throws SQLException, ClassNotFoundException {
//        DepartmentDAO dao = new DepartmentDAO();
//        DepartmentFilterDto filter = new DepartmentFilterDto();
//        filter.setLocId(1500);

        when(filter.getLocId()).thenReturn(1500);
        when(filter.getLimit()).thenReturn(null);

        Assertions.assertDoesNotThrow(() -> dao.selectAllDepts(filter));

        ArrayList<Department> depts = dao.selectAllDepts(filter);

        Assertions.assertNotNull(depts);
        Assertions.assertTrue(depts.size() != 0);
        for (Department d : depts) {
            Assertions.assertEquals(1500, d.getLocationId());
        }

    }
}
