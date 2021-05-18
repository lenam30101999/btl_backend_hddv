package com.e17cn2.qlsv.service.impl;

import com.e17cn2.qlsv.dto.StudentDTO;
import com.e17cn2.qlsv.entity.Student;
import com.e17cn2.qlsv.entity.User;
import com.e17cn2.qlsv.security.FirebaseUserDetails;
import com.e17cn2.qlsv.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService extends BaseService {

    public List<StudentDTO> getListStudentByClassId(int classId){
        List<Student> student = studentRepository.findAllByClassRoomsId(classId);
        return convertStudentResponses(student);
    }

    private List<StudentDTO> convertStudentResponses(List<Student> students){
        return students.stream().map(modelMapper::convertToStudentDTO).collect(Collectors.toList());
    }

    public FirebaseUserDetails addUser(Student student, User user){
        Student student1 = studentRepository.findByUserUid(user.getUid()).orElse(null);
        if (Objects.isNull(student1)) {
           studentRepository.save(student);
        }
        return null;
    }
}
