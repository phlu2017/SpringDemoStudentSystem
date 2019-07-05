package com.example.students.system;
import com.example.students.system.service.StudentService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

import com.example.students.system.controller.RestSysController;
import com.example.students.system.dao.StudentDao;
import com.example.students.system.domain.Student;
import com.example.students.system.dto.GradeDto;
import com.example.students.system.dto.StudentDto;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.students.system.service.StudentServiceImpl;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;

//@RunWith(SpringRunner.class)
@WebMvcTest(value = RestSysController.class, secure = false)
public class SystemApplicationTests {
    @Mock //one which does not connect to a database
    StudentService studentService;
    @Mock
    StudentDao studentDao;

    @Autowired
    MockMvc mockMvc;

    StudentDto mockStudent1 = new StudentDto(0,"mockF","mockL");
    StudentDto mockStudent2 = new StudentDto(1,"mockF","mockL");
    List<StudentDto> list = new LinkedList<>();

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
        list.add(mockStudent1);
        list.add(mockStudent2);
        RestAssuredMockMvc.standaloneSetup(new RestSysController(studentService));
        System.out.println("SystemApplication start test");
    }

    @Test
    public void sutdentServicefindbyIdStudent(){
        Mockito.when(studentService.findSingleStudentbyId(anyLong())).thenReturn(mockStudent1);
        RestAssuredMockMvc.given().accept("application/json").get("/api/student/0").peek().
                then().assertThat()
                .statusCode(200)
                .body(Matchers.equalTo("{\"id\":0,\"firstName\":\"mockF\",\"lastName\":\"mockL\",\"takenCourseAndGrade\":[]}"));
    }

    @Test
    public void sutdentServicefindAllStudent() {
        Mockito.when(studentService.findAllStudent()).thenReturn(list);
        System.out.println(list.size());
        RestAssuredMockMvc.given().accept("application/json").get("/api/student/").peek().
                then().assertThat()
                .statusCode(200).
                body(Matchers.equalTo("[{\"id\":0,\"firstName\":\"mockF\",\"lastName\":\"mockL\",\"takenCourseAndGrade\":[]},{\"id\":1,\"firstName\":\"mockF\",\"lastName\":\"mockL\",\"takenCourseAndGrade\":[]}]"));
    }
    //??
    @Test
    public void sutdentServiceCreateStudent() {
        Mockito.when(studentService.createNewStudent(anyObject())).thenReturn(mockStudent1);
        RestAssuredMockMvc.given().accept("application/json").body(mockStudent2).post("/api/student/post/").peek().
                then().assertThat()
                .statusCode(201)
                .body("body.id",Matchers.is(1));

    }
}
