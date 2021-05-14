package com.e17cn2.qlsv.service;

import com.e17cn2.qlsv.entity.*;
import com.e17cn2.qlsv.mapper.ModelMapper;
import com.e17cn2.qlsv.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
  @Autowired protected ClassRoomRepository classRoomRepository;
  @Autowired protected SemesterRepository semesterRepository;
  @Autowired protected SubjectRepository subjectRepository;
  @Autowired protected PointRepository pointRepository;
  @Autowired protected UserRepository userRepository;
  @Autowired protected ModelMapper modelMapper;
  @Autowired protected StudentRepository studentRepository;

  protected Subject initSubject(int id){
    return subjectRepository.findSubjectById(id).orElse(null);
  }

  protected Student initStudent(String uid){
    Student student = new Student();
    User user = userRepository.findByUid(uid).orElse(null);
    student.setUser(user);
    return student;
  }

  protected Manager initManager(String uid){
    Manager manager = new Manager();
    User user = userRepository.findByUid(uid).orElse(null);
    manager.setUser(user);
    return manager;
  }

  protected Semester initSemester(int id){
    Semester semester = new Semester();
    semester.setId(id);
    return semester;
  }
}
