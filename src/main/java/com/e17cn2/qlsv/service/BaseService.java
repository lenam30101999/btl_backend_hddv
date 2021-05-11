package com.e17cn2.qlsv.service;

import com.e17cn2.qlsv.entity.Manager;
import com.e17cn2.qlsv.entity.Semester;
import com.e17cn2.qlsv.entity.Student;
import com.e17cn2.qlsv.entity.Subject;
import com.e17cn2.qlsv.mapper.ModelMapper;
import com.e17cn2.qlsv.repository.ClassRoomRepository;
import com.e17cn2.qlsv.repository.PointRepository;
import com.e17cn2.qlsv.repository.SemesterRepository;
import com.e17cn2.qlsv.repository.SubjectRepository;
import com.e17cn2.qlsv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
  @Autowired protected ClassRoomRepository classRoomRepository;
  @Autowired protected SemesterRepository semesterRepository;
  @Autowired protected SubjectRepository subjectRepository;
  @Autowired protected PointRepository pointRepository;
  @Autowired protected UserRepository userRepository;
  @Autowired protected ModelMapper modelMapper;

  protected Subject initSubject(int id){
    return subjectRepository.findSubjectById(id).orElse(null);
  }

  protected Student initStudent(int id){
    Student student = new Student();
    student.setId(id);
    return student;
  }

  protected Manager initManager(int id){
    Manager manager = new Manager();
    manager.setId(id);
    return manager;
  }

  protected Semester initSemester(int id){
    Semester semester = new Semester();
    semester.setId(id);
    return semester;
  }
}
