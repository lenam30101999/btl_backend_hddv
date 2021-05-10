package com.e17cn2.qlsv.repository;

import com.e17cn2.qlsv.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Integer> {

    Optional<Semester> findBySemesterName(String semesterName);
}
