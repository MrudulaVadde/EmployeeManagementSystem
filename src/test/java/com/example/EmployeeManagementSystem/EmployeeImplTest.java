package com.example.EmployeeManagementSystem;

import com.example.EmployeeManagementSystem.controller.EmployeeController;
import com.example.EmployeeManagementSystem.entity.EmployeeModel;
import com.example.EmployeeManagementSystem.repository.EmployeeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=EmployeeImplTest.class)
public class EmployeeImplTest {

    @Mock
    EmployeeRepo employeeRepo;

    @InjectMocks
    @Spy
    EmployeeController classUnderTest = new EmployeeController();

    @BeforeMethod
    void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetEmployeeDetails() {
        EmployeeModel employeeModel = new EmployeeModel();
        when(employeeRepo.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<List<EmployeeModel>> data = classUnderTest.getAllEmployeeDetails();

        assertEquals(1, Objects.requireNonNull(data.getBody()).size());
    }
}
