package com.e17cn2.qlsv.mapper;

import com.e17cn2.qlsv.dto.ClassroomDTO;
import com.e17cn2.qlsv.dto.ClassroomDTO.ClassroomDTOBuilder;
import com.e17cn2.qlsv.dto.SubjectDTO;
import com.e17cn2.qlsv.dto.SubjectDTO.SubjectDTOBuilder;
import com.e17cn2.qlsv.entity.ClassRoom;
import com.e17cn2.qlsv.entity.Subject;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-10T23:06:52+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class ModelMapperImpl implements ModelMapper {

    @Override
    public List<ClassroomDTO> convertToClassroomDTO(List<ClassRoom> classRooms) {
        if ( classRooms == null ) {
            return null;
        }

        List<ClassroomDTO> list = new ArrayList<ClassroomDTO>( classRooms.size() );
        for ( ClassRoom classRoom : classRooms ) {
            list.add( classRoomToClassroomDTO( classRoom ) );
        }

        return list;
    }

    @Override
    public SubjectDTO convertToSubjectDTO(Subject subject) {
        if ( subject == null ) {
            return null;
        }

        SubjectDTOBuilder subjectDTO = SubjectDTO.builder();

        subjectDTO.id( subject.getId() );
        subjectDTO.subjectName( subject.getSubjectName() );
        subjectDTO.attendancePercent( subject.getAttendancePercent() );
        subjectDTO.testPercent( subject.getTestPercent() );
        subjectDTO.projectPercent( subject.getProjectPercent() );
        subjectDTO.finalPercent( subject.getFinalPercent() );

        return subjectDTO.build();
    }

    @Override
    public List<SubjectDTO> convertToSubjectDTOs(List<Subject> subjects) {
        if ( subjects == null ) {
            return null;
        }

        List<SubjectDTO> list = new ArrayList<SubjectDTO>( subjects.size() );
        for ( Subject subject : subjects ) {
            list.add( convertToSubjectDTO( subject ) );
        }

        return list;
    }

    protected ClassroomDTO classRoomToClassroomDTO(ClassRoom classRoom) {
        if ( classRoom == null ) {
            return null;
        }

        ClassroomDTOBuilder classroomDTO = ClassroomDTO.builder();

        classroomDTO.id( classRoom.getId() );
        classroomDTO.className( classRoom.getClassName() );

        return classroomDTO.build();
    }
}
