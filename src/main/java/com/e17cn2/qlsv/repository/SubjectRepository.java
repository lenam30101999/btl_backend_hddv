package com.e17cn2.qlsv.repository;

import com.e17cn2.qlsv.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
  Optional<Subject> findSubjectById(int id);

  @Query(value = "select sj from Subject sj, ClassRoom cl, Student st " +
          "where sj.id = cl.subject.id and cl.id = st.id and sj.subjectName like %?1%")
  Subject getSubjectByTextSearch(String textSert);
}
