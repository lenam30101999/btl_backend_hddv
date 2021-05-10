package com.e17cn2.qlsv.service.impl;


import com.e17cn2.qlsv.dto.SemesterDTO;
import com.e17cn2.qlsv.entity.Semester;
import com.e17cn2.qlsv.service.BaseService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class SemesterService extends BaseService {

    public List<SemesterDTO> getListSemesterDto(){
        List<Semester> semesters = semesterRepository.findAll();
        return modelMapper.convertToSemesterDTO(semesters);
    }

    public void addSemester(SemesterDTO semesterDTO){
        Semester semester = semesterRepository.findBySemesterName(semesterDTO.getSemesterName().trim().toLowerCase()).orElse(null);
        try {

            if (Objects.isNull(semester)) {
                Semester saveSemester = Semester.builder()
                        .semesterName(semesterDTO.getSemesterName())
                        .build();
                semesterRepository.save(saveSemester);
            }
        }catch (Exception e){
            e.getLocalizedMessage();
        }
    }
}
