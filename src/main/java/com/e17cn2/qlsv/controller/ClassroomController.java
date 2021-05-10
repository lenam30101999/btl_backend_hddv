package com.e17cn2.qlsv.controller;

import com.e17cn2.qlsv.dto.ClassroomDTO;
import com.e17cn2.qlsv.service.impl.ClassroomService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/classrooms")
@RestController
@Log4j2
public class ClassroomController {
  @Autowired
  private ClassroomService classRoomService;

  @PostMapping
  public ResponseEntity<?> addClassroom(@RequestBody ClassroomDTO classroomDTO){
    classRoomService.addClassRoom(classroomDTO);
    return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<?> getAllClassrooms(){
    List<ClassroomDTO> classroomDTOs = classRoomService.getAllClassrooms();
    return new ResponseEntity<>(classroomDTOs, HttpStatus.OK);
  }
}
