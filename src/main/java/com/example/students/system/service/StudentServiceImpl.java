package com.example.students.system.service;

import com.example.students.system.dao.StudentDao;
import com.example.students.system.domain.Course;
import com.example.students.system.domain.Grade;
import com.example.students.system.domain.Student;
import com.example.students.system.dto.CourseDto;
import com.example.students.system.dto.GradeDto;
import com.example.students.system.dto.StudentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("StudentService")
public class StudentServiceImpl implements SutdentService{

    @Autowired
    StudentDao studentDao;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<StudentDto> findAllStudent() {
        List<Student> student = studentDao.findAll();
        if(student.size()==0) return null;
        return convertAll(student);
    }

    @Override
    public List<StudentDto> findStudentByLastNameAndFirstName(String firstName, String lastName) {
        List<Student> student = studentDao.findByLastnameAndFirstname(lastName, firstName);
        if(student.size()==0) return null;
        return convertAll(student);
    }

    @Override
    public StudentDto findSingleStudentbyId(long id) {
        Student student = studentDao.findOneById(id);
        if(student==null) return null;
        return convertSingleObject(student);
    }

    @Override
    public StudentDto createNewStudent(long id, String lastName, String firstName ) {
        if(studentDao.findOneById(id)!=null)
            return null;
        Student student = new Student();
        student.setFirstname(firstName);
        student.setLastname(lastName);
        student.setId(id);
        //System.out.println( student.toString());
        studentDao.save(student);
        return convertSingleObject(student);
    }

    @Override
    public StudentDto deleteStudentbyId(long id) {
        Student student = studentDao.findOneById(id);
        if(student==null) return null;
        StudentDto studentDto = convertSingleObject(student);
        studentDao.deleteById(id);
        return studentDto;
    }

    @Override
    public StudentDto updateStudentbyId(long id, String firstName, String lastName) {
        Student student = studentDao.findOneById(id);
        if(student==null) return null;
        student.setFirstname(firstName);
        student.setLastname(lastName);
        studentDao.saveAndFlush(student);
        return convertSingleObject(student);
    }

    @Override
    public List<StudentDto> testQuery(long id) {

        return null;
    }

    //    @Override
//    public List<GradeDto> findStudentTakenGrade(long id) {
//
//        return  studentDao.findStudentTakenGrade(id).stream()
//                .map(g -> modelMapper.map(g, GradeDto.class))
//                .collect(Collectors.toList());
//    }
    @Override
    public List<Course> fetchEmpDeptDataLeftJoin() {
        return null;
    }


    public List<StudentDto> convertAll(List<Student> list) {
        return list.stream().map(e -> convertSingleObject(e)).collect(Collectors.toList());
    }

    public StudentDto convertSingleObject(Student obj) {
        StudentDto studentDto =modelMapper.map(obj, StudentDto.class);
        studentDto.SetTakenCourseAndGrade(obj.getGradeSet());
        return studentDto;
    }
}
