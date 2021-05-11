package com.e17cn2.qlsv.controller;


import com.e17cn2.qlsv.dto.StudentDTO;
import com.e17cn2.qlsv.service.impl.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getListStudentByClassId(@RequestParam("class_id") int classId){
        List<StudentDTO> studentDTOS = studentService.getListStudentByClassId(classId);
        if (Objects.nonNull(studentDTOS)) {
            return new ResponseEntity<>(studentDTOS, HttpStatus.OK);
        }else return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
    }
}
