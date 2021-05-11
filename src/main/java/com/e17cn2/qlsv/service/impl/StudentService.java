package com.e17cn2.qlsv.service.impl;

import com.e17cn2.qlsv.dto.StudentDTO;
import com.e17cn2.qlsv.entity.Student;
import com.e17cn2.qlsv.service.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService extends BaseService {

    public List<StudentDTO> getListStudentByClassId(int classId){
        List<Student> student = studentRepository.findAllByClassRoomsId(classId);
        return convertPointResponses(student);
    }

    private List<StudentDTO> convertPointResponses(List<Student> students){
        return students.stream().map(p -> modelMapper.convertToStudentDTO(p)).collect(Collectors.toList());
    }
}
