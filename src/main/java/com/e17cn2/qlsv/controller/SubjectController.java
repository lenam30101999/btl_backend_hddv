package com.e17cn2.qlsv.controller;

import com.e17cn2.qlsv.dto.SubjectDTO;
import com.e17cn2.qlsv.service.impl.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/subjects")
public class SubjectController {

  @Autowired
  private SubjectService subjectService;

  @PostMapping
  public ResponseEntity<?> addSubject(@RequestBody SubjectDTO subjectDTO){
    subjectService.addSubject(subjectDTO);
    return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<?> updateSubject(@RequestBody SubjectDTO subjectDTO,
                                         @PathVariable("id") int id){
    SubjectDTO dto =  subjectService.updateSubject(subjectDTO, id);
    if (Objects.nonNull(dto)){
      return new ResponseEntity<>(dto, HttpStatus.OK);
    }else return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> deleteSubject(@PathVariable("id") int id){
    subjectService.deleteSubject(id);
    return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<?> getAllSubject(){
    List<SubjectDTO> subjectDTOs = subjectService.getAllSubject();
    return new ResponseEntity<>(subjectDTOs, HttpStatus.OK);
  }
}
