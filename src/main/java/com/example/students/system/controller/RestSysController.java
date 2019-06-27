package com.example.students.system.controller;

import com.example.students.system.dao.StudentDao;
import com.example.students.system.dao.TeacherDao;
import com.example.students.system.domain.Student;
import com.example.students.system.dto.StudentDto;

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

@RestController
@RequestMapping("/api")
@Api
public class RestSysController {
    @Autowired
    StudentDao studentDao;

    @Autowired
    StudentDto studentDto;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    ModelMapper modelMapper;

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
    public ResponseEntity<StudentDto> getStudent(@PathVariable("id") int id) {
        //String stu_id = String.valueOf(id);
        List<Student> students = studentDao.findById(id);

        if (students.size() == 0) {
            System.out.println("not found");
        }
        studentDto = modelMapper.map(students.get(0), StudentDto.class);

        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }

    @ApiOperation(value = "gets all Student")
    @GetMapping(value = "/student/")
    public ResponseEntity<List<Student>> getStudentPagenation() {

        List<Student> students = studentDao.findAll();
        if (students.isEmpty()) {
            //throw new UserNotFoundException(messages.getMessage("USER_NOT_FOUND"));
        }
        return new ResponseEntity<List<Student>>( students, HttpStatus.OK);

    }

    @ApiOperation(value = "insert a single getStudent")
    @PostMapping(value = "/student/")
    public Student insertStudent(@Valid @RequestBody Student student) {
        return studentDao.save(student);
    }

    @ApiOperation(value = "update a single getStudent")
    @PutMapping(value = "/student/")
    public Student updateStudent(@Valid @RequestBody Student student) {
        return studentDao.saveAndFlush(student);
    }

    @ApiOperation(value = "delete a single getStudent")
    @DeleteMapping(value = "/student/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        try{
            studentDao.deleteById(id);
            //return "delete successfully";
        }catch (Exception e){

        }
        System.out.print("delete fail");
        //return "failed";
    }


}

