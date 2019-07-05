package com.example.students.system.controller;

import com.example.students.system.dao.CourseDao;
import com.example.students.system.dao.GradeDao;
import com.example.students.system.dao.StudentDao;
import com.example.students.system.service.StudentService;
import com.example.students.system.domain.Grade;
import com.example.students.system.domain.Student;
import com.example.students.system.dto.CourseDto;
import com.example.students.system.dto.StudentDto;

import com.example.students.system.exception.StudentException;
import com.example.students.system.service.StudentEntityToDtoServiceImpl;
import com.example.students.system.service.StudentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Api
public class RestSysController {
    @Autowired
    StudentDao studentDao;

    @Autowired
    GradeDao gradeDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    StudentService studentService;

    public RestSysController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation(value = "gets a single Student")
    @GetMapping(value = "/student/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") long id) {
        StudentDto student = studentService.findSingleStudentbyId(id);
        if(student == null)
            throw new StudentException("User not found");
        //student.getTakenCourseAndGrade().forEach(e-> System.out.println(e.toString()));
        return new ResponseEntity<StudentDto>(student, HttpStatus.OK);
    }

    @ApiOperation(value = "gets all Student")
    @GetMapping(value = "/student/")
    public ResponseEntity<List<StudentDto>> getStudentPagenation() {
        List<StudentDto> studentsDto = studentService.findAllStudent();
        if(studentsDto.size()==0)
            throw new StudentException("User not found");
        return new ResponseEntity<List<StudentDto>>(studentsDto , HttpStatus.OK);
    }

    @ApiOperation(value = "gets a single Student by lastName and firstName")
    @GetMapping(value = "/student/{lastName}/{firstName}")
    public ResponseEntity<List<StudentDto>> getStudent(@PathVariable("lastName") String last, @PathVariable("firstName") String first) {
        List<StudentDto> studentsDto = studentService.findStudentByLastNameAndFirstName(last, first);
        if (studentsDto==null)
            throw new StudentException("User not found");
        return new ResponseEntity<List<StudentDto>>(studentsDto, HttpStatus.OK);
    }

    @ApiOperation(value = "insert a single getStudent")
    @PostMapping(value = "/student/post/")
    public ResponseEntity<StudentDto> insertStudent(@Valid @RequestBody StudentDto student) {
        StudentDto studentDto = studentService.createNewStudent(student);
        if(studentDto==null)
            throw new StudentException("User already exist");
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }

    @ApiOperation(value = "update a single getStudent")
    @PutMapping(value = "/student/update/")
    public StudentDto updateStudent(@Valid @RequestBody StudentDto student) {
        StudentDto studentDto = studentService.updateStudentbyId(student.getId(), student.getLastName(), student.getFirstName());
        if (studentDto==null)
            throw new StudentException("User not found");
        return studentDto;
    }

    @ApiOperation(value = "delete a single getStudent")
    @DeleteMapping(value = "/student/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        StudentDto studentDto = studentService.deleteStudentbyId(id);
        if(studentDto==null)
            throw new StudentException("User not found");
        return new ResponseEntity<String>("Delete successfully id: "+id, HttpStatus.OK);
    }
}

