package com.e17cn2.qlsv.service.impl;

import com.e17cn2.qlsv.dto.SubjectDTO;
import com.e17cn2.qlsv.entity.Subject;
import com.e17cn2.qlsv.service.BaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@Log4j2
public class SubjectService extends BaseService {

  public void addSubject(SubjectDTO subjectDTO){
    try {
      Subject saved = Subject.builder()
          .subjectName(subjectDTO.getSubjectName())
          .attendancePercent(subjectDTO.getAttendancePercent())
          .testPercent(subjectDTO.getTestPercent())
          .projectPercent(subjectDTO.getProjectPercent())
          .finalPercent(subjectDTO.getFinalPercent())
          .build();
      subjectRepository.save(saved);
    }catch (Exception e){
      log.info(e);
    }
  }

  public SubjectDTO updateSubject(SubjectDTO subjectDTO, int id){
    try {
      Subject updated = getSubjectById(subjectDTO.getId());
      if (Objects.nonNull(updated)){
        updated.setSubjectName(subjectDTO.getSubjectName());
        updated.setAttendancePercent(subjectDTO.getAttendancePercent());
        updated.setTestPercent(subjectDTO.getTestPercent());
        updated.setProjectPercent(subjectDTO.getProjectPercent());
        updated.setFinalPercent(subjectDTO.getFinalPercent());

        subjectRepository.saveAndFlush(updated);
        return modelMapper.convertToSubjectDTO(updated);
      }
    }catch (Exception e){
      log.info(e);
    }
    return null;
  }

  public void deleteSubject(int id){
    Subject deleted = getSubjectById(id);
    if (Objects.nonNull(deleted)){
      subjectRepository.delete(deleted);
    }
  }

  public List<SubjectDTO> getAllSubject(){
    List<Subject> subjects = subjectRepository.findAll();
    return modelMapper.convertToSubjectDTOs(subjects);
  }

  private Subject getSubjectById(int id){
    return subjectRepository.findSubjectById(id).orElse(null);
  }

  public SubjectDTO getSubjectByTextSearch(String textSearch){
    Subject subject = subjectRepository.getSubjectByTextSearch(textSearch);
    SubjectDTO subjectDTO = new SubjectDTO();
    subjectDTO.setId(subject.getId());
    subjectDTO.setSubjectName(subject.getSubjectName());
    return subjectDTO;
  }
}
