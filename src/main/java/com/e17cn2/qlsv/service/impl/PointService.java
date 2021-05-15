package com.e17cn2.qlsv.service.impl;

import com.e17cn2.qlsv.dto.PointDTO;
import com.e17cn2.qlsv.entity.Point;
import com.e17cn2.qlsv.entity.Subject;
import com.e17cn2.qlsv.response.PointResponse;
import com.e17cn2.qlsv.service.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
@Log4j2
public class PointService extends BaseService {

  public void addPoint(PointDTO pointDTO){
    try {
      Subject subject = initSubject(pointDTO.getSubjectId());
      Point saved = Point.builder()
          .attendancePoint(pointDTO.getAttendancePoint())
          .testPoint(pointDTO.getTestPoint())
          .projectPoint(pointDTO.getProjectPoint())
          .finalPoint(pointDTO.getFinalPoint())
          .avgPoint(calculateAvgPoint(subject, pointDTO))
          .semester(initSemester(pointDTO.getSemesterId()))
          .student(initStudent(pointDTO.getStudentId()))
          .manager(initManager(pointDTO.getManagerId()))
          .subject(subject)
          .build();
      pointRepository.save(saved);
    }catch (Exception e){
      log.info(e);
    }
  }

  public PointDTO updatePoint(PointDTO pointDTO, int id){
    try {
      Subject subject = initSubject(pointDTO.getSubjectId());
      Point updated = getPoint(id);
      if (Objects.nonNull(updated)){
        updated.setAttendancePoint(pointDTO.getAttendancePoint());
        updated.setTestPoint(pointDTO.getTestPoint());
        updated.setProjectPoint(pointDTO.getProjectPoint());
        updated.setFinalPoint(pointDTO.getFinalPoint());
        updated.setAvgPoint(calculateAvgPoint(subject, pointDTO));

        pointRepository.saveAndFlush(updated);
        return modelMapper.convertToPointDTO(updated);
      }
    }catch (Exception e){
      log.info(e);
    }
    return null;
  }

  public List<PointResponse> getAllPointByStudent(String studentId){
    List<Point> points = pointRepository.findPointsByStudentUserUidOrderBySemesterId(studentId);
    return convertPointResponses(points);
  }

  private Point getPoint(int id){
    return pointRepository.findPointById(id).orElse(null);
  }

  private float calculateAvgPoint(Subject subject, PointDTO pointDTO){
    return pointDTO.getAttendancePoint() * subject.getAttendancePercent()
              + pointDTO.getTestPoint() * subject.getTestPercent()
              + pointDTO.getProjectPoint() * subject.getProjectPercent()
              + pointDTO.getFinalPoint() * subject.getFinalPercent();
  }

  private List<PointResponse> convertPointResponses(List<Point> points){
    return points.stream().map(p -> modelMapper.convertToPointResponse(p)).collect(Collectors.toList());
  }
}
