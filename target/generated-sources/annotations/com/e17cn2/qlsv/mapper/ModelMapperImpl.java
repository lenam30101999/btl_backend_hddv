package com.e17cn2.qlsv.mapper;

import com.e17cn2.qlsv.dto.ClassroomDTO;
import com.e17cn2.qlsv.entity.ClassRoom;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-10T22:08:35+0700",
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

    protected ClassroomDTO classRoomToClassroomDTO(ClassRoom classRoom) {
        if ( classRoom == null ) {
            return null;
        }

        ClassroomDTO classroomDTO = new ClassroomDTO();

        classroomDTO.setId( classRoom.getId() );
        classroomDTO.setClassName( classRoom.getClassName() );

        return classroomDTO;
    }
}
