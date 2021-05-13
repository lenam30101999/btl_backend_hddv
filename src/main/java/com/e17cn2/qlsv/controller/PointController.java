package com.e17cn2.qlsv.controller;

import com.e17cn2.qlsv.dto.PointDTO;
import com.e17cn2.qlsv.entity.Point;
import com.e17cn2.qlsv.response.PointResponse;
import com.e17cn2.qlsv.service.impl.PointService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Log4j2
@RestController
@RequestMapping("/api/v1/points")
public class PointController {

  @Autowired
  private PointService pointService;

  @PostMapping
  public ResponseEntity<?> addPoint(@RequestBody PointDTO pointDTO){
    pointService.addPoint(pointDTO);
    return new ResponseEntity<>(HttpStatus.CREATED.getReasonPhrase(), HttpStatus.CREATED);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<?> updatePoint(@RequestBody PointDTO pointDTO,
                                       @PathVariable("id") int id){
    PointDTO data = pointService.updatePoint(pointDTO, id);
    if (Objects.nonNull(data)){
      return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
    }else return new ResponseEntity<>(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
  }

  @GetMapping
  public ResponseEntity<?> getAllPoints(@RequestParam("student") int id ){
    List<PointResponse> points = pointService.getAllPointByStudent(id);
    return new ResponseEntity<>(points, HttpStatus.OK);
  }
}
