package com.e17cn2.qlsv.service.impl;

import com.e17cn2.qlsv.dto.StudentDTO;
import com.e17cn2.qlsv.entity.Student;
import com.e17cn2.qlsv.repository.StudentRepository;
import com.e17cn2.qlsv.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService extends BaseService {

    public List<StudentDTO> getListStudentByClassId(int classId){
        List<Student> student = studentRepository.findAllByClassRoomsId(classId);
        return modelMapper.convertToStudentDTOs(student);
    }
}
