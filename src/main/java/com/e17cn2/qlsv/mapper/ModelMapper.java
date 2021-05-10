package com.e17cn2.qlsv.mapper;

import com.e17cn2.qlsv.dto.ClassroomDTO;
import com.e17cn2.qlsv.dto.SemesterDTO;
import com.e17cn2.qlsv.entity.ClassRoom;
import com.e17cn2.qlsv.entity.Semester;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModelMapper {

  @Mappings({
//      @Mapping(target = "subjectId", ignore = true),
//      @Mapping(target = "semesterId", ignore = true)
  })
  List<ClassroomDTO> convertToClassroomDTO(List<ClassRoom> classRooms);

  List<SemesterDTO> convertToSemesterDTO(List<Semester> semesters);
}
