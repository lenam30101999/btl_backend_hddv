package com.e17cn2.qlsv.service.impl;

import com.e17cn2.qlsv.dto.ClassroomDTO;
import com.e17cn2.qlsv.entity.ClassRoom;
import com.e17cn2.qlsv.service.BaseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClassroomService extends BaseService {

  public void addClassRoom(ClassroomDTO classroomDTO){
    ClassRoom saved = ClassRoom.builder()
                      .className(classroomDTO.getClassName())
                      .semester(initSemester(classroomDTO.getSemesterId()))
                      .subject(initSubject(classroomDTO.getSubjectId()))
                      .build();
    classRoomRepository.save(saved);
  }

  public List<ClassroomDTO> getAllClassrooms(){
    List<ClassRoom> classRooms = classRoomRepository.findAll();
    return modelMapper.convertToClassroomDTO(classRooms);
  }
}
