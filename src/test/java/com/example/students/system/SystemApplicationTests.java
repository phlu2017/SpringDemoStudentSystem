package com.example.students.system;

import com.example.students.system.dao.StudentDao;
import com.example.students.system.dto.GradeDto;
import com.example.students.system.dto.StudentDto;
import com.example.students.system.service.SutdentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.students.system.service.StudentServiceImpl;

import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class SystemApplicationTests {
    @Mock
    SutdentService studentService;
    @Mock
    StudentDao studentDao;

    @Test
    public void sutdentServicefindStudentTakenGradeTest() {
       // List<GradeDto> grades = sutdentService.findStudentTakenGrade(0);
        //List<StudentDto> students = sutdentService.findStudentTakenGrade(0);

        System.out.println(studentDao.findStudentTakenGrade(0).toString());
        //System.out.println(grades.size());
//        for(GradeDto grade : grades) System.out.println(grade.toString());
        //studentDao.findStudentTakenGrade(0).forEach(e-> System.out.println(e.toString()));
    }

}
