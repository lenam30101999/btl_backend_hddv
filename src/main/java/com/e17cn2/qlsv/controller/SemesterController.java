package com.e17cn2.qlsv.controller;


import com.e17cn2.qlsv.dto.SemesterDTO;
import com.e17cn2.qlsv.service.impl.SemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/semesters")
public class SemesterController {

    @Autowired
    private SemesterService semesterService;

    @GetMapping
    public ResponseEntity<?> getAllSemester(){
        List<SemesterDTO> semesterDTOS = semesterService.getListSemesterDto();
        if (Objects.nonNull(semesterDTOS)) {
            return new ResponseEntity<>(semesterDTOS, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> addSemester(@RequestBody SemesterDTO semesterDTO){
         semesterService.addSemester(semesterDTO);
        return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);
    }
}
