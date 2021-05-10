package com.e17cn2.qlsv.service;

import com.e17cn2.qlsv.entity.Semester;
import com.e17cn2.qlsv.entity.Subject;
import com.e17cn2.qlsv.mapper.ModelMapper;
import com.e17cn2.qlsv.repository.ClassRoomRepository;
import com.e17cn2.qlsv.repository.SemesterRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
  @Autowired protected ClassRoomRepository classRoomRepository;
  @Autowired protected SemesterRepository semesterRepository;
  @Autowired protected ModelMapper modelMapper;

  protected Subject initSubject(int id){
    Subject subject = new Subject();
    subject.setId(id);
    return subject;
  }

  protected Semester initSemester(int id){
    Semester semester = new Semester();
    semester.setId(id);
    return semester;
  }
}
