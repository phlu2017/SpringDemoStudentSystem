package com.example.students.system.controller;

import com.example.students.system.dao.StudentDao;
import com.example.students.system.dao.TeacherDao;
import com.example.students.system.domain.Student;
import com.example.students.system.dto.StudentDto;

import com.example.students.system.exception.StudentException;
import com.example.students.system.service.StudentEntityToDtoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/student")
@Api
public class RestSysController {
    @Autowired
    StudentDao studentDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentEntityToDtoServiceImpl studentService;

//    @Autowired
//    StudentDto studentDto;
//    @ApiOperation(value = "gets a single Student")
//    @GetMapping(value = "/student/{id}")
//    public ResponseEntity<Student> getStudent(@PathVariable("id") int id) {
//        //String stu_id = String.valueOf(id);
//        List<Student> students = studentDao.findById(id);
//
//        if (students.size() == 0) {
//            System.out.println("not found");
//        }
//        return new ResponseEntity<Student>(students.get(0), HttpStatus.OK);
//    }
    @ApiOperation(value = "gets a single Student")
    @GetMapping(value = "/student/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") long id) {
        Student student = studentDao.findOneById(id);
        if (student==null)
            throw new StudentException("User not found");

        return new ResponseEntity<StudentDto>(studentService.convertSingleObject(student), HttpStatus.OK);
    }


    @ApiOperation(value = "gets all Student")
    @GetMapping(value = "/student/")
    public ResponseEntity<List<StudentDto>> getStudentPagenation() {
        List<StudentDto> studentsDto = studentService.convertAll(studentDao.findAll());
        if(studentsDto.size()==0)
            throw new StudentException("User not found");
        else
            return new ResponseEntity<List<StudentDto>>(studentsDto , HttpStatus.OK);
    }

    @ApiOperation(value = "insert a single getStudent")
    @PostMapping(value = "/student/")
    public ResponseEntity<StudentDto> insertStudent(@Valid @RequestBody StudentDto studentDto) {
        if(studentDao.findOneById((int)studentDto.getId())!=null)
            throw new StudentException("User already exist");
        Student student = new Student();
        student.setFirstname(studentDto.getFirstName());
        student.setLastname(studentDto.getLastName());
        student.setId(studentDto.getId());
        System.out.println("Id: "+ student.getId());
        studentDao.save(student);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }

    @ApiOperation(value = "update a single getStudent")
    @PutMapping(value = "/student/")
    public StudentDto updateStudent(@Valid @RequestBody StudentDto studentDto) {
        Student student = studentDao.findOneById((long)studentDto.getId());
        if (student==null)
            throw new StudentException("User not found");
        student.setFirstname(studentDto.getFirstName());
        student.setLastname(studentDto.getLastName());
        studentDao.saveAndFlush(student);
        return studentDto;
    }

    @ApiOperation(value = "delete a single getStudent")
    @DeleteMapping(value = "/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        Student student = studentDao.findOneById(id);
        if(student==null)
            throw new StudentException("User not found");
        studentDao.deleteById(id);
        //return "failed";
        return new ResponseEntity<String>("Delete successfully id: "+id, HttpStatus.OK);
    }


}

