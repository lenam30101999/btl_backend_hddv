package com.e17cn2.qlsv.mapper;

import com.e17cn2.qlsv.dto.*;
import com.e17cn2.qlsv.entity.*;
import com.e17cn2.qlsv.response.ClassResponse;
import com.e17cn2.qlsv.response.PointResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModelMapper {

  @Mappings({
      @Mapping(target = "subjectId", source = "subject.id"),
      @Mapping(target = "semesterId", source = "semester.id")
  })
  ClassroomDTO convertToClassroomDTO(ClassRoom classRooms);


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

  @Mappings({
      @Mapping(target = "name", source = "user.username"),
      @Mapping(target = "studentCode", source = "studentCode")
  })
  StudentDTO convertToStudentDTO(Student student);

}
