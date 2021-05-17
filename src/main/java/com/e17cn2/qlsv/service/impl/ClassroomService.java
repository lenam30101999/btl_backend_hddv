package com.e17cn2.qlsv.service.impl;

import com.e17cn2.qlsv.dto.ClassroomDTO;
import com.e17cn2.qlsv.entity.ClassRoom;
import com.e17cn2.qlsv.response.ClassResponse;
import com.e17cn2.qlsv.service.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Log4j2
public class ClassroomService extends BaseService {

  public void addClassRoom(ClassroomDTO classroomDTO){
    try {
      ClassRoom saved = ClassRoom.builder()
          .className(classroomDTO.getClassName())
          .semester(initSemester(classroomDTO.getSemesterId()))
          .subject(initSubject(classroomDTO.getSubjectId()))
          .build();
      classRoomRepository.save(saved);
    }catch (Exception e){
      log.info(e);
    }
  }

  public List<ClassroomDTO> getAllClassroomsBySemester(int semesterId){
    List<ClassRoom> classRooms = classRoomRepository.findAllBySemesterId(semesterId);
    return convertToClassroomDTOs(classRooms);
  }

  private List<ClassroomDTO> convertToClassroomDTOs(List<ClassRoom> classRooms){
    return classRooms.stream().map(modelMapper::convertToClassroomDTO).collect(Collectors.toList());
  }

}
