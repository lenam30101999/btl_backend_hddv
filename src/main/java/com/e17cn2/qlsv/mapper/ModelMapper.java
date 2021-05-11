package com.e17cn2.qlsv.mapper;

import com.e17cn2.qlsv.dto.ClassroomDTO;
import com.e17cn2.qlsv.dto.PointDTO;
import com.e17cn2.qlsv.dto.SubjectDTO;
import com.e17cn2.qlsv.dto.SemesterDTO;
import com.e17cn2.qlsv.entity.ClassRoom;
import com.e17cn2.qlsv.entity.Point;
import com.e17cn2.qlsv.entity.Subject;
import com.e17cn2.qlsv.entity.Semester;
import com.e17cn2.qlsv.response.ClassResponse;
import com.e17cn2.qlsv.response.PointResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModelMapper {

  @Mappings({})
  List<ClassResponse> convertClassResponse(List<ClassRoom> classRooms);


  @Mappings({})
  SubjectDTO convertToSubjectDTO(Subject subject);

  @Mappings({})
  List<SubjectDTO> convertToSubjectDTOs(List<Subject> subjects);

  List<SemesterDTO> convertToSemesterDTO(List<Semester> semesters);

  @Mappings({})
  PointDTO convertToPointDTO(Point point);

  @Mappings({
      @Mapping(target = "semesterResponse", source = "semester"),
      @Mapping(target = "subjectResponse", source = "subject"),
      @Mapping(target = "avg", source = "avgPoint")
  })
  PointResponse convertToPointResponse(Point point);
}
