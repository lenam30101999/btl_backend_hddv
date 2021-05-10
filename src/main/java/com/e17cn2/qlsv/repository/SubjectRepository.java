package com.e17cn2.qlsv.repository;

import com.e17cn2.qlsv.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
  Optional<Subject> findSubjectById(int id);
}
