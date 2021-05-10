package com.e17cn2.qlsv.mapper;

import com.e17cn2.qlsv.dto.ClassroomDTO;
import com.e17cn2.qlsv.dto.SemesterDTO;
import com.e17cn2.qlsv.entity.ClassRoom;
import com.e17cn2.qlsv.entity.Semester;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-10T22:30:25+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
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
    public List<SemesterDTO> convertToSemesterDTO(List<Semester> semesters) {
        if ( semesters == null ) {
            return null;
        }

        List<SemesterDTO> list = new ArrayList<SemesterDTO>( semesters.size() );
        for ( Semester semester : semesters ) {
            list.add( semesterToSemesterDTO( semester ) );
        }

        return list;
    }

    protected ClassroomDTO classRoomToClassroomDTO(ClassRoom classRoom) {
        if ( classRoom == null ) {
            return null;
        }

        ClassroomDTO classroomDTO = new ClassroomDTO();

        classroomDTO.setId( classRoom.getId() );
        classroomDTO.setClassName( classRoom.getClassName() );

        return classroomDTO;
    }

    protected SemesterDTO semesterToSemesterDTO(Semester semester) {
        if ( semester == null ) {
            return null;
        }

        SemesterDTO semesterDTO = new SemesterDTO();

        semesterDTO.setId( semester.getId() );
        semesterDTO.setSemesterName( semester.getSemesterName() );

        return semesterDTO;
    }
}
